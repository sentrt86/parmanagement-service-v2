package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParAllocationDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

@Service
@Transactional
public class ParAllocationServiceImpl implements IParAllocationService{
	
	@Autowired
	ParAllocationDAOImpl parAllocationDaoImpl;
	
	@Override
	public List<ParAllocation> getParAllocationByParNum(String parNum) throws ResourceNotFoundException {
		List<ParAllocation> parAllocationList = new ArrayList<ParAllocation> (); 
		try {
			parAllocationList = parAllocationDaoImpl.getParAllocationByParNum(parNum);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for ParMaster Number : %S",parNum));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parAllocationList;
	}

	@Override
	public List<ParAllocation> getCandidateReceivedByParNum(String parNum) throws ResourceNotFoundException {
		List<ParAllocation> parAllocationList = new ArrayList<ParAllocation> (); 
		try {
			parAllocationList = parAllocationDaoImpl.getCandidateReceivedByParNum(parNum);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for ParMaster Number : %S",parNum));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parAllocationList;
	}

	@Override
	public String deleteParAllocationByParAllocId(int parAllocId) throws ResourceNotFoundException {
		try { 
			boolean candidateReceivedDeleted = parAllocationDaoImpl.deleteParAllocationByParAllocId(parAllocId);
			if(candidateReceivedDeleted) { 
				return String.format(ParConstants.deleteSuccessfull + "for Par Allocation Id:" + Integer.toString(parAllocId)); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Par Allocation Id: " + Integer.toString(parAllocId))); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Par Allocation Id : "+Integer.toString(parAllocId)); 
	}

	@Override
	public String createParAllocation(ParAllocationTO parAllocationTO) throws ResourceNotCreatedException {
		List<ParAllocation> parAllocationList = new ArrayList<ParAllocation> ();
		try {
			parAllocationList = parAllocationDaoImpl.getCandidateReceivedByParCode(parAllocationTO.getParCode());
			if(!parAllocationList.isEmpty()){
				for(ParAllocation data: parAllocationList )
				{
					if(data.getCandidate().getCandidateId() == parAllocationTO.getCandidate().getCandidateId())
					{
						return String.format(ParConstants.duplicateFound + "for Candidate Name: %s",parAllocationTO.getCandidate().getCandidateName());
					}
				}

			}

			boolean parAllocationCreated = parAllocationDaoImpl.createParAllocation(new ParAllocation(parAllocationTO));
			
			if(parAllocationCreated)
			{
				return String.format(ParConstants.createSuccessfull + "for Candidate Name : %s",parAllocationTO.getCandidate().getCandidateName());
			}


		}catch(DataAccessException e) {
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}
		return String.format(ParConstants.createUnSuccessfull + "for Candidate Name : %s",parAllocationTO.getCandidate().getCandidateName());
	}

	@Override
	public List<ParAllocation> getCandidateReceivedByParCode(int parCode) throws ResourceNotFoundException {
		List<ParAllocation> parAllocationList = new ArrayList<ParAllocation> (); 
		try {
			parAllocationList = parAllocationDaoImpl.getCandidateReceivedByParCode(parCode);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for ParMaster Number : %S",parCode));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parAllocationList;
	}

	
	
	@Override
	public String updateSubmitCandidate(ParAllocationTO parAllocationTO) throws ResourceNotUpdatedException {
		try {
			boolean submitCandidateUpdated = parAllocationDaoImpl.updateSubmitCandidate(new ParAllocation(parAllocationTO));
			if (submitCandidateUpdated)
			{
				return String.format(ParConstants.updateSuccessfull + "for Par Allocation  Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %S",parAllocationTO.getCandidate().getCandidateName()));
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
	}


	@Override
	public String updatePrescreening(ParAllocationTO parAllocationTO) throws ResourceNotCreatedException {
		try {
			boolean prescreeningUpdated = parAllocationDaoImpl.updatePrescreening(new ParAllocation(parAllocationTO));
			if (prescreeningUpdated)
			{
				return String.format(ParConstants.updateSuccessfull + "for Par Allocation  Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %S",parAllocationTO.getCandidate().getCandidateName()));
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
	}

	public String updateCandidateOnBoard(@Valid ParAllocationTO parAllocationTO) throws ResourceNotFoundException {
		try {
			System.out.println("SEnthil ---- candidate on board");
			System.out.println("parallocation"+parAllocationTO);
			boolean parAllocationUpdated = parAllocationDaoImpl.updateCandidateOnBoard(new ParAllocation(parAllocationTO));
			if (parAllocationUpdated)
			{
				return String.format(ParConstants.updateSuccessfull + "for Par Allocation  Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %S",parAllocationTO.getCandidate().getCandidateName()));
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Par Allocation Candidate : %s",parAllocationTO.getCandidate().getCandidateName());
	}
}

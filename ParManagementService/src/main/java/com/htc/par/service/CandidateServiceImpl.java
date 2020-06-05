package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.CandidateDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Candidate;
import com.htc.par.to.CandidateTO;

@Service
public class CandidateServiceImpl implements ICandidateService {

	@Autowired
	CandidateDAOImpl candidateDaoImpl;
	
	/*
	 * Request handler to GET all candidate
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */
	
	@Override
	public List<Candidate> getAllCandidate() {
		List<Candidate> candidateList = new ArrayList<Candidate> ();		
		try {
			candidateList = candidateDaoImpl.getAllCandidates();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return candidateList;
	}

	/*
	 * GET Candidate by candidate id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */
	
	@Override
	public List<Candidate> getCandidateById(int candidateId) {
		List<Candidate> candidateList = new ArrayList<Candidate> (); 
		try {
			candidateList = candidateDaoImpl.getCandidateById(candidateId);
			if(candidateList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Candidate Id %S",candidateId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Candidate Id %S",candidateId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return candidateList; 
	}

	/*
	 * GET all active Candidate
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */
	
	@Override
	public List<Candidate> getActiveCandidate() {
		List<Candidate> candidateList = new ArrayList<Candidate> ();		
		try {
			candidateList = candidateDaoImpl.getActiveCandidate();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return candidateList;
	}
	
	/*
	 * GET Candidate by candidate name
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<Candidate> getCandidateByName(String candidateName) {
		List<Candidate> candidateList = new ArrayList<Candidate> (); 
		try {
			candidateList = candidateDaoImpl.getCandidateByName(candidateName);
			if(candidateList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Candidate  %S",candidateName));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Candidate  %S",candidateName));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return candidateList; 
	}

	/*
	 * Update the candidate informations for give candidate id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String updateCandidate(CandidateTO candidateTO) {
		try { 
			List<Candidate> allCandidateList = new ArrayList<Candidate>();
			allCandidateList = candidateDaoImpl.getAllCandidates();
			if(!allCandidateList.isEmpty()) {
				
				for(Candidate data : allCandidateList) 
				{ 
					if (data.getCandidateName().equalsIgnoreCase(candidateTO.getCandidateName()) && data.getCandidatePhoneNum().equalsIgnoreCase(candidateTO.getCandidatePhoneNum())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Candidate : %s",candidateTO.getCandidateName()));
					} 
				}
				boolean updateCandidateSuccess = candidateDaoImpl.updateCandidate(new Candidate(candidateTO.getCandidateId(),candidateTO.getCandidateName(),candidateTO.getCandidatePhoneNum(),candidateTO.getCandidateEmailTxt(),candidateTO.getCandidateReceivedDate(),candidateTO.getCandidateActive(),candidateTO.getSkill())); 
				
				if(updateCandidateSuccess ) { 
					return String.format(ParConstants.updateSuccessfull + "for Candidate: %s",candidateTO.getCandidateName()); 
					}
			}
			
			
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Candidate : %s",candidateTO.getCandidateName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Candidate: %s",candidateTO.getCandidateName()); 

	}

	
	/*
	 * Delete the Candidate for a give candidate id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String deleteCandidate(int candidateId) {
		try { 
			boolean deleteCandidateSuccess = candidateDaoImpl.deleteCandidate(candidateId); 
			if(deleteCandidateSuccess) { 
				return String.format(ParConstants.deleteSuccessfull + "for Candidate Id: " + candidateId); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Candidate  Id : " + candidateId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Candidate Id : %s",candidateId); 
	}

	/*
	 * Create the Candidate information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String createCandidate(CandidateTO candidateTO) {
		List<Candidate> allCandidateList = new ArrayList<Candidate>();

		try { 
			allCandidateList = candidateDaoImpl.getAllCandidates(); 
			if(!allCandidateList.isEmpty()) {
				for(Candidate data : allCandidateList) 
				{ 
					if (data.getCandidateName().equalsIgnoreCase(candidateTO.getCandidateName()) && data.getCandidatePhoneNum().equalsIgnoreCase(candidateTO.getCandidatePhoneNum())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Candidate : %s",candidateTO.getCandidateName()));
					} 
				} 

				if(candidateDaoImpl.createCandidate(new Candidate(candidateTO.getCandidateId(),candidateTO.getCandidateName(),candidateTO.getCandidatePhoneNum(),candidateTO.getCandidateEmailTxt(),candidateTO.getCandidateReceivedDate(),candidateTO.getCandidateActive(),candidateTO.getSkill())))
				{ 
					return String.format(ParConstants.createSuccessfull + "for Candidate : %s",candidateTO.getCandidateName()); 
				} 
			}
			else if(allCandidateList.isEmpty()) {
				if(candidateDaoImpl.createCandidate(new Candidate(candidateTO.getCandidateId(),candidateTO.getCandidateName(),candidateTO.getCandidatePhoneNum(),candidateTO.getCandidateEmailTxt(),candidateTO.getCandidateReceivedDate(),candidateTO.getCandidateActive(),candidateTO.getSkill())))
				{ 
					return String.format(ParConstants.createSuccessfull + "for Candidate : %s",candidateTO.getCandidateName()); 
				} 
			}

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for Candidate : %s ",candidateTO.getCandidateName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Candidate : %s",candidateTO.getCandidateName());

	}
	
	/*
	 * Get the next candidate id from the cand_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public int getNextCandidateId() {
		try {
			return candidateDaoImpl.getNextCandidateId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}


}

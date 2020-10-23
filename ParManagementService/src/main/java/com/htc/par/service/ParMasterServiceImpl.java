package com.htc.par.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParMasterDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParMaster;


import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParMasterServiceImpl  implements IParMasterService{

	@Autowired
	ParMasterDAOImpl parMasterDaoImpl;

	@Override
	public String createParMaster(ParMaster parmaster)  throws ResourceNotCreatedException{
		try {
			
			ParMaster parMaster = parMasterDaoImpl.getParMasterByParNum(parmaster.getParNumber());
			
			if(parMaster.getParNumber().equalsIgnoreCase(parmaster.getParNumber()))
			{
				throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Par Number : %s",parmaster.getParNumber()));
			}

		}catch(EmptyResultDataAccessException e) {
			if(parMasterDaoImpl.createParMaster(parmaster))
			{
				return String.format(ParConstants.createSuccessfull + "for Par Number : %s",parmaster.getParNumber());
			}			
		}catch(DataAccessException e) {
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}
		return String.format(ParConstants.createUnSuccessfull + "for Par Number : %s",parmaster.getParNumber());
	}
	
	
	@Override
	public String updateParMaster(ParMaster parmaster) throws ResourceNotUpdatedException{
		
		try {
			if(parMasterDaoImpl.updateParMaster(parmaster)) {
				return String.format(ParConstants.updateSuccessfull + "for Par Master: %s",parmaster.getParNumber());
			}
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
		
		return String.format(ParConstants.updateUnSuccessfull + "for Par Master: %s",parmaster.getParNumber());
	}

	@Override
	public Boolean createParMasterRltn(ParMaster parmaster) throws ResourceNotCreatedException{
		try {
			return parMasterDaoImpl.createParMasterRltn(parmaster);		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

	@Override
	public int getNextParSeqId() throws ResourceAccessException{
		try {
			return parMasterDaoImpl.getNextParSeqId();		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

	@Override
	public ParMaster getParMasterByParNum(String parNum) throws ResourceNotFoundException {
		ParMaster parMaster = null; 
		try {
			
			parMaster = parMasterDaoImpl.getParMasterByParNum(parNum);
			System.out.println("par master service");
			System.out.println("===================");
			System.out.println("parmaster"+parMaster);
		}catch(EmptyResultDataAccessException ex) {
			parMaster = null;
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parMaster;
	}

	@Override
	public String updateIntentToFill(int parId,String parNum, Boolean intentToFill, String intentSentDate) throws ResourceNotFoundException {
		try {
			boolean updateParmaster = parMasterDaoImpl.updateIntentToFill(parId, intentToFill, intentSentDate);
			if (updateParmaster)
			{
				return String.format(ParConstants.updateSuccessfull + "for Par Master: %s",parNum);
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Par Master Number : %S",parNum));
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Par Master: %s",parNum);
	}


	@Override
	public String deleteParMaster(int parNo) throws ResourceNotFoundException {
		try { 
			boolean deleteParMaster = parMasterDaoImpl.deleteParMaster(parNo);
			if(deleteParMaster) 
			{ 
				return String.format(ParConstants.deleteSuccessfull + "for Par Master : " + parNo); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Par Master : " + parNo)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Par Master : %s", parNo); 
	}


	@Override
	public String updateEmailSent(ParMaster parmaster) throws ResourceNotFoundException {
		try {
			boolean updateParmaster = parMasterDaoImpl.updateEmailSent(parmaster);
			if (updateParmaster)
			{
				return String.format(ParConstants.emailSuccessfull);
			}
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}
		return String.format(ParConstants.emailUnSuccessfull);
	}

	

	

	

}

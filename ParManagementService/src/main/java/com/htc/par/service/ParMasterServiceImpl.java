package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParMasterDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.ParMaster;

@Service
public class ParMasterServiceImpl  implements IParMasterService{

	@Autowired
	ParMasterDAOImpl parMasterDaoImpl;
	
	@Override
	public String createParMaster(ParMaster parmaster)  throws ResourceNotCreatedException{
		try {
			List<ParMaster> parMasterList = parMasterDaoImpl.getParMasterByParNum(parmaster.getParNumber());
			if(!parMasterList.isEmpty())
			{
				if(parMasterDaoImpl.createParMaster(parmaster))
				{
					if(this.createParMasterRltn(parmaster))
					{
						return String.format(ParConstants.createSuccessfull + "for Par Number : %s",parmaster.getParNumber());
					}	
				}
			}
			else
			{
				throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Par Number : %s",parmaster.getParNumber()));
			}
			
		}catch(DataAccessException e) {
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}
		return String.format(ParConstants.createUnSuccessfull + "for Par Number : %s",parmaster.getParNumber());
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
	public List<ParMaster> getParMasterByParNum(String parNum) throws ResourceNotFoundException {
		List<ParMaster> parmasterList = new ArrayList<ParMaster> (); 
		try {
			parmasterList = parMasterDaoImpl.getParMasterByParNum(parNum);
			if(parmasterList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Par Number : %S",parNum));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for ParMaster Number : %S",parNum));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parmasterList;
	}

	@Override
	public String updateIntentToFill(String parNum, Boolean intentToFill, String intentSentDate)
			throws ResourceNotFoundException {
		try {
			parMasterDaoImpl.updateIntentToFill(parNum, intentToFill, intentSentDate);
		}catch(DataAccessException ex) { 
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Par Master Number : %S",parNum));
		}
		return null;
	}

}

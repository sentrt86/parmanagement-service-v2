package com.htc.par.service;


import org.springframework.stereotype.Service;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParMaster;

@Service
public interface IParMasterService {
	
	String createParMaster(ParMaster parmaster) throws ResourceNotCreatedException;
	String updateParMaster(ParMaster parmaster) throws ResourceNotUpdatedException;
	String deleteParMaster(int parId) throws ResourceNotFoundException;
	String updateEmailSent(ParMaster parmaster) throws ResourceNotFoundException;
	Boolean createParMasterRltn(ParMaster parmaster) throws ResourceNotCreatedException;
	ParMaster getParMasterByParNum(String parNum) throws ResourceNotFoundException;
	int getNextParSeqId() throws ResourceAccessException;
	String updateIntentToFill(int parId,String parNum,Boolean intentToFill,String intentSentDate) throws ResourceNotFoundException;

}

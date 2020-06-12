package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.ParMaster;

@Service
public interface IParMasterService {
	
	String createParMaster(ParMaster parmaster) throws ResourceNotCreatedException;
	String updateIntentToFill(int parId,String parNum,Boolean intentToFill,String intentSentDate) throws ResourceNotFoundException;
	Boolean createParMasterRltn(ParMaster parmaster) throws ResourceNotCreatedException;
	List<ParMaster> getParMasterByParNum(String parNum) throws ResourceNotFoundException;
	int getNextParSeqId() throws ResourceAccessException;

}

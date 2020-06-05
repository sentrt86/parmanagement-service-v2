package com.htc.par.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.UserMaster;
import com.htc.par.to.UserMasterTO;

@Service
public interface IUserMasterService {
	
	List<UserMaster> getUserMasterByUserName(String username) throws ResourceNotFoundException;
	List<UserMaster> getAllUserMaster() throws ResourceNotFoundException;
	int getNextUserMasterId();
	String updateUserMaster(UserMasterTO userMasterTO) throws ResourceNotFoundException;
	String deleteUserMaster(int userId) throws ResourceNotFoundException;
	String createUserMaster(UserMasterTO userMasterTO) throws ResourceNotFoundException, ResourceNotCreatedException;
	

}

package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.UserMasterDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.UserMaster;
import com.htc.par.to.UserMasterTO;


@Service
public class UserMasterServiceImpl  implements IUserMasterService{

	@Autowired
	UserMasterDAOImpl userMasterDaoImpl;
	
	
	/*
	 * Get all the UserMaster info for a given user name
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public List<UserMaster> getUserMasterByUserName(String username) throws ResourceNotFoundException {		
		List<UserMaster> userMaster = new ArrayList<UserMaster>(); 
		try {
			userMaster = userMasterDaoImpl.getUserMasterByUserName(username);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for User Master %S",username));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return userMaster;
		
	}
	
	

	/*
	 * Get all the UserMaster info
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	
	@Override
	public List<UserMaster> getAllUserMaster() throws ResourceNotFoundException {		
		List<UserMaster> userMaster = new ArrayList<UserMaster>(); 		
		try {
			userMaster = userMasterDaoImpl.getAllUserMaster();
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return userMaster;
		
	}
	
	
	/*
	 * Delete the UserMaster for a give userMaster id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String deleteUserMaster(int userMasterId) throws ResourceNotFoundException {

		try { 
			boolean deleteUserMasterSuccess = userMasterDaoImpl.deleteUserMaster(userMasterId); 
			if(deleteUserMasterSuccess) 
			{ 
				return String.format(ParConstants.deleteSuccessfull + "for User Master Id: " + userMasterId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for User Master  Id : " + userMasterId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for User Master Id : %s",userMasterId); 
	}
	
	/*
	 * Update the UserMaster information for a given userMaster id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String updateUserMaster(UserMasterTO userMasterTO) throws ResourceNotFoundException {
		try { 			
			boolean updateUserMasterSuccess = userMasterDaoImpl.updateUserMaster(new UserMaster(userMasterTO.getUserId(),userMasterTO.getUserFirstName(),userMasterTO.getUserLastName(),userMasterTO.getUserPhoneNo(),userMasterTO.getUserEmailTxt(),userMasterTO.getUserActive(),userMasterTO.getUserName(),userMasterTO.getPassword(),userMasterTO.getUserRole())); 
			if(updateUserMasterSuccess) { 
				return String.format(ParConstants.updateSuccessfull + "for UserMaster: %s",userMasterTO.getUserFirstName()); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for UserMaster : %s",userMasterTO.getUserFirstName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for UserMaster: %s",userMasterTO.getUserFirstName()); 

	}


	/*
	 * Create the UserMaster information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String createUserMaster(UserMasterTO userMasterTO) throws ResourceNotCreatedException { 
		List<UserMaster> allUserMastersList = new ArrayList<UserMaster>();
		
		try { 
			allUserMastersList = userMasterDaoImpl.getAllUserMaster(); 
			if(!allUserMastersList.isEmpty()) {
				for(UserMaster data : allUserMastersList) 
				{ 
					if (data.getUserFirstName().equalsIgnoreCase(userMasterTO.getUserFirstName()) && data.getUserLastName().equalsIgnoreCase(userMasterTO.getUserLastName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for UserMaster: %s",userMasterTO.getUserFirstName() + " "+userMasterTO.getUserLastName() ));
					} 
				} 
			}
			if(userMasterDaoImpl.createUserMaster(new UserMaster(userMasterTO.getUserId(),userMasterTO.getUserFirstName(),userMasterTO.getUserLastName(),userMasterTO.getUserPhoneNo(),userMasterTO.getUserEmailTxt(),userMasterTO.getUserActive(),userMasterTO.getUserName(),userMasterTO.getPassword(),userMasterTO.getUserRole())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for userMaster : %s",userMasterTO.getUserFirstName()); 
			} 
				

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for UserMaster : %s ",userMasterTO.getUserFirstName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for userMaster : %s",userMasterTO.getUserFirstName());

	}



	/*
	 * Get the next user master id from the user sequence
	 * 
	 * @ResourseAccessException
	 */

	@Override 
	public int getNextUserMasterId() throws ResourceAccessException {
		try {
			return userMasterDaoImpl.getNextUserMasterId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }

	}



}

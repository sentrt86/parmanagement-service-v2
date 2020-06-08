package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.UserRoleDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.UserRole;
import com.htc.par.to.UserRoleTO;

@Service
public class UserRoleServiceImpl  implements IUserRoleService{

	@Autowired
	UserRoleDAOImpl userRoleDaoImpl;

	/*
	 * GET all the User Role
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<UserRole> getAllUserRole() throws ResourceNotFoundException {
		List<UserRole> userRoleList = new ArrayList<UserRole> ();		
		try {
			userRoleList = userRoleDaoImpl.getAllUserRole();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return userRoleList;
	}

	/*
	 * GET User Role by user role id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<UserRole> getUserRoleById(int userRoleId) throws ResourceNotFoundException {
		List<UserRole> userRoleList = new ArrayList<UserRole> (); 
		try {
			userRoleList = userRoleDaoImpl.getUserRoleById(userRoleId);
			if(userRoleList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for User Role Id : %S",userRoleId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for User Role Id : %S",userRoleId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return userRoleList;
	}

	/*
	 * GET User Role by user role name
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */



	@Override
	public List<UserRole> getUserRoleByName(String userRoleName) throws ResourceNotFoundException {
		List<UserRole> userRoleList = new ArrayList<UserRole> (); 
		try {
			userRoleList = userRoleDaoImpl.getUserRoleByName(userRoleName);
			if(userRoleList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for User Role :  %S",userRoleName));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for User Role : %S",userRoleName));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return userRoleList;
	}

	/*
	 * Update the User Role information
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String updateUserRole(UserRoleTO userRoleTO) throws ResourceNotFoundException, ResourceNotUpdatedException {
		try { 
			boolean updateUserRoleSuccess = userRoleDaoImpl.updateUserRole(new UserRole(userRoleTO.getUserRoleId(),userRoleTO.getUserRoleName())); 

			if(updateUserRoleSuccess) { 
				return String.format(ParConstants.updateSuccessfull + "for User Role: %s",userRoleTO.getUserRoleName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for User Role : %s",userRoleTO.getUserRoleName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for User Role : %s",userRoleTO.getUserRoleName()); 
	}

	/*
	 * Delete the User role for a give user role id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String deleteUserRole(int userRoleId) throws ResourceNotFoundException {
		try { 
			boolean deleteUserRoleSuccess = userRoleDaoImpl.deleteUserRole(userRoleId); 
			if(deleteUserRoleSuccess) { 
				return String.format(ParConstants.deleteSuccessfull + "for User Role Id : " + userRoleId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for User Role  Id : " + userRoleId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for User Role Id : %s",userRoleId); 
	}

	/*
	 * Create the User Role information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String createUserRole(UserRoleTO userRoleTO) throws ResourceNotCreatedException {
		List<UserRole> allUserRoleList = new ArrayList<UserRole>();

		try { 
			allUserRoleList = userRoleDaoImpl.getAllUserRole(); 
			if(!allUserRoleList.isEmpty()) {
				for(UserRole data : allUserRoleList) 
				{ 
					if (data.getUserRoleName().equalsIgnoreCase(userRoleTO.getUserRoleName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for User Role: %s",userRoleTO.getUserRoleName()));
					} 
				} 				
			}			
			if(userRoleDaoImpl.createUserRole(new UserRole(userRoleTO.getUserRoleId(),userRoleTO.getUserRoleName())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for User Role : %s",userRoleTO.getUserRoleName()); 
			} 
		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for User Role : %s ",userRoleTO.getUserRoleName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for User Role : %s",userRoleTO.getUserRoleName());
	}

	/*
	 * Get the next user role id  from the user_role_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public int getNextUserRoleId() throws ResourceAccessException {
		try {
			return userRoleDaoImpl.getNextUserRoleId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

}

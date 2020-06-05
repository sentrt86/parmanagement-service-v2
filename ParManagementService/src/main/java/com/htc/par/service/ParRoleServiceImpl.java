package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParRoleDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParRole;
import com.htc.par.to.ParRoleTO;

@Service
public class ParRoleServiceImpl implements IParRoleService {

	@Autowired
	ParRoleDAOImpl parRoleDaoImpl;

	/*
	 * Request handler to GET all Roles
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */

	@Override
	public List<ParRole> getAllParRoles() throws ResourceNotFoundException {
		List<ParRole> parRole = new ArrayList<ParRole> ();	
		try {
			parRole = parRoleDaoImpl.getAllParRoles();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return parRole;
	}

	/*
	 * GET Roles by role id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<ParRole> getParRoleById(int roleId) throws ResourceNotFoundException {
		List<ParRole> parRoleList = new ArrayList<ParRole> (); 
		try {
			parRoleList = parRoleDaoImpl.getParRoleById(roleId);
			if(parRoleList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Role Id %S",roleId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Role Id %S",roleId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parRoleList;
	}


	/*
	 * Delete the Role for a give role id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	@Override
	public String deleteParRole(int roleId) throws ResourceNotFoundException {
		try { 
			boolean deleteRoleSuccess = parRoleDaoImpl.deleteParRole(roleId); 
			if(deleteRoleSuccess) { 
				return String.format(ParConstants.deleteSuccessfull + "for Role Id: " + roleId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Role  Id : " + roleId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Role Id : %s",roleId); 
	}

	/*
	 * Create the Role information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String createParRole(ParRoleTO parRoleTO) throws ResourceNotCreatedException {
		List<ParRole> allParRoleList = new ArrayList<ParRole>();
		try { 
			allParRoleList = parRoleDaoImpl.getAllParRoles(); 
			if(!allParRoleList.isEmpty()) {
				for(ParRole data : allParRoleList) 
				{ 
					if (data.getRoleName().equalsIgnoreCase(parRoleTO.getRoleName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Role: %s",parRoleTO.getRoleName()));
					} 
				} 

				if(parRoleDaoImpl.createParRole(new ParRole(parRoleTO.getRoleId(),parRoleTO.getRoleName(),parRoleTO.getRoleActive())))
				{ 
					return String.format(ParConstants.createSuccessfull + "for Role : %s",parRoleTO.getRoleName()); 
				} 
			}
			else if(allParRoleList.isEmpty()) {
				if(parRoleDaoImpl.createParRole(new ParRole(parRoleTO.getRoleId(),parRoleTO.getRoleName(),parRoleTO.getRoleActive())))
				{ 
					return String.format(ParConstants.createSuccessfull + "for Role : %s",parRoleTO.getRoleName()); 
				}
			}

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for Role : %s ",parRoleTO.getRoleName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Role : %s",parRoleTO.getRoleName());

	}

	/*
	 * Get the next role id from the role_seq
	 * 
	 * @ResourseAccessException
	 */
	@Override
	public int getNextParRoleId() throws ResourceAccessException {
		try {
			return parRoleDaoImpl.getNextParRoleId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}
	
	/*
	 * Update the Role for a give role id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */


	@Override
	public String updateParRole(ParRoleTO parRoleTO) throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 			
			boolean updateRoleSuccess = parRoleDaoImpl.updateParRole(new ParRole(parRoleTO.getRoleId(),parRoleTO.getRoleName(),parRoleTO.getRoleActive())); 

			if(updateRoleSuccess) { 
				return String.format(ParConstants.updateSuccessfull + "for Role : %s",parRoleTO.getRoleName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Area : %s",parRoleTO.getRoleName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Role : %s",parRoleTO.getRoleName()); 

	}

}

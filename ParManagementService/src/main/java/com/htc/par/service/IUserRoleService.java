package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.UserRole;
import com.htc.par.to.UserRoleTO;

@Service
public interface IUserRoleService {

	List<UserRole> getAllUserRole() throws ResourceNotFoundException;
	List<UserRole> getUserRoleById(int userRoleId) throws ResourceNotFoundException;
	List<UserRole> getUserRoleByName(String userRoleName) throws ResourceNotFoundException;
	String updateUserRole(UserRoleTO userRoleTO) throws ResourceNotFoundException,ResourceNotUpdatedException;
	String deleteUserRole(int userRoleId) throws ResourceNotFoundException;
	String createUserRole(UserRoleTO userRoleTO) throws ResourceNotCreatedException; 
	int getNextUserRoleId() throws ResourceAccessException;
}

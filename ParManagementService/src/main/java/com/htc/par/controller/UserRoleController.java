package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.UserRole;
import com.htc.par.service.UserRoleServiceImpl;
import com.htc.par.to.UserRoleTO;

@RestController
@RequestMapping("/par/userrole")
public class UserRoleController {
	
	@Autowired
	UserRoleServiceImpl userRoleServiceImpl;
	
	
	/*
	 * Request handler to get all the user role
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getUserRoles",method=RequestMethod.GET)
	public ResponseEntity<List<UserRole>> getAllUserRole() throws ResourceNotFoundException{
		return new ResponseEntity<List<UserRole>>(userRoleServiceImpl.getAllUserRole(),HttpStatus.OK);		
	}

	/*
	 * Request handler to get  user role by user role id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getUserRoleById/{userRoleId}",method=RequestMethod.GET)
	public ResponseEntity<List<UserRole>> getUserRoleById(@PathVariable("userRoleId") int userRoleId) throws ResourceNotFoundException{
		return new ResponseEntity<List<UserRole>>(userRoleServiceImpl.getUserRoleById(userRoleId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get  user role by user role name
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getUserRoleByName/{userRoleName}",method=RequestMethod.GET)
	public ResponseEntity<List<UserRole>> getUserRoleByName(@PathVariable("userRoleName") String userRoleName) throws ResourceNotFoundException{
		return new ResponseEntity<List<UserRole>>(userRoleServiceImpl.getUserRoleByName(userRoleName),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to update the user role
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/updateUserRole",method=RequestMethod.POST)
	public ResponseEntity<String> updateUserRole(@RequestBody @Valid UserRoleTO userRoleTO) throws ResourceNotCreatedException,ResourceNotUpdatedException{
		return new ResponseEntity<String>(userRoleServiceImpl.updateUserRole(userRoleTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to delete  user role by user role id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/deleteUserRole/{userRoleId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteUserRole(@PathVariable("userRoleId") int userRoleId) throws ResourceNotFoundException{
		return new ResponseEntity<String>(userRoleServiceImpl.deleteUserRole(userRoleId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to create user role
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/createUserRole",method=RequestMethod.POST)
	public ResponseEntity<String> createUserRole(@RequestBody @Valid UserRoleTO userRoleTO) throws ResourceNotCreatedException{
		return new ResponseEntity<String>(userRoleServiceImpl.createUserRole(userRoleTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next user role id
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextUserRoleId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextUserRolrId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(userRoleServiceImpl.getNextUserRoleId(),HttpStatus.OK);
	}
	
	

}

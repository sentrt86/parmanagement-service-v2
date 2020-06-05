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
import com.htc.par.model.ParRole;
import com.htc.par.service.ParRoleServiceImpl;
import com.htc.par.to.ParRoleTO;

@RestController
@RequestMapping("/par/role")
public class ParRoleController {
	
	@Autowired
	ParRoleServiceImpl parRoleServiceImpl;
	
	/*
	 * Request handler to get all the role
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getParRoles",method=RequestMethod.GET)
	public ResponseEntity<List<ParRole>> getAllParRoles() throws ResourceNotFoundException{
		return new ResponseEntity<List<ParRole>>(parRoleServiceImpl.getAllParRoles(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next role id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextParRoleId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextParRoleId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(parRoleServiceImpl.getNextParRoleId(),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to get an Role by role id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getParRoleById/{roleId}",method=RequestMethod.GET)
	public ResponseEntity<List<ParRole>> getParRoleById(@PathVariable("roleId") int roleId) throws ResourceNotFoundException{
		return new  ResponseEntity<List<ParRole>>(parRoleServiceImpl.getParRoleById(roleId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete an Role by role id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteParRole/{roleId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteParRole(@PathVariable("roleId") int roleId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(parRoleServiceImpl.deleteParRole(roleId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update an Role by role id
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateParRole",method=RequestMethod.POST)
	public ResponseEntity<String> updateParRole(@RequestBody @Valid ParRoleTO parRoleTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(parRoleServiceImpl.updateParRole(parRoleTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to create an role
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createParRole",method=RequestMethod.POST)
	public ResponseEntity<String> createParRole(@RequestBody @Valid ParRoleTO parRoleTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(parRoleServiceImpl.createParRole(parRoleTO),HttpStatus.OK);
	}


}

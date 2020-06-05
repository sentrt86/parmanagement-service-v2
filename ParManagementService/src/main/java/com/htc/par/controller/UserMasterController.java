package com.htc.par.controller;

import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.UserMaster;
import com.htc.par.service.UserMasterServiceImpl;
import com.htc.par.to.UserMasterTO;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/par/usermaster")
public class UserMasterController {
	
	@Autowired
	UserMasterServiceImpl userMasterServiceImpl;
	
	
	/*
	 * Request handler to get  user master info by  user name
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getUserMasterByUserName/{username}",method=RequestMethod.GET)
	public ResponseEntity<List<UserMaster>> getUserMasterByName(@PathVariable("username") String username) throws ResourceNotFoundException{
		return new ResponseEntity<List<UserMaster>>(userMasterServiceImpl.getUserMasterByUserName(username),HttpStatus.OK);		
	}
	
	
	/*
	 * Request handler to get  all the user master information
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getAllUserMaster",method=RequestMethod.GET)
	public ResponseEntity<List<UserMaster>> getAllUserMaster() throws ResourceNotFoundException{
		return new ResponseEntity<List<UserMaster>>(userMasterServiceImpl.getAllUserMaster(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next user master id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextUserMasterId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextUserMasterId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(userMasterServiceImpl.getNextUserMasterId(),HttpStatus.OK);
	}
	/*
	 * Request handler to delete an user master by user master id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteUserMaster/{userMasterId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteUserMaster(@PathVariable("userMasterId") int userMasterId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(userMasterServiceImpl.deleteUserMaster(userMasterId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update an user aster by user master id
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateUserMaster",method=RequestMethod.POST)
	public ResponseEntity<String> updateUserMaster(@RequestBody @Valid UserMasterTO userMasterTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(userMasterServiceImpl.updateUserMaster(userMasterTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to create an user master
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createUserMaster",method=RequestMethod.POST)
	public ResponseEntity<String> createUserMaster(@RequestBody @Valid UserMasterTO userMasterTO) throws ResourceNotCreatedException{
		System.out.println("ser:"+userMasterTO.toString());
		return new  ResponseEntity<String>(userMasterServiceImpl.createUserMaster(userMasterTO),HttpStatus.OK);
	}

}

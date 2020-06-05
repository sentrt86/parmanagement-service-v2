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
import com.htc.par.model.ExternalStaff;
import com.htc.par.service.ExternalStaffServiceImpl;
import com.htc.par.to.ExternalStaffTO;

@RestController
@RequestMapping("/par/extstaff")
public class ExternalStaffController {
	
	@Autowired
	ExternalStaffServiceImpl externalStaffServiceImpl;
	
	/*
	 * Request handler to get all the external Staff
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getExtStaffs",method=RequestMethod.GET)
	public ResponseEntity<List<ExternalStaff>> getAllExtStaff() throws ResourceNotFoundException{
		return new ResponseEntity<List<ExternalStaff>>(externalStaffServiceImpl.getAllExternalStaff(),HttpStatus.OK);		
	}

	/*
	 * Request handler to get  external Staff by external staff id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getExtStaffById/{extStaffId}",method=RequestMethod.GET)
	public ResponseEntity<List<ExternalStaff>> getExtStaffById(@PathVariable("extStaffId") int externalStaffId) throws ResourceNotFoundException{
		return new ResponseEntity<List<ExternalStaff>>(externalStaffServiceImpl.getExternalStaffById(externalStaffId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get all the external Staff who are active
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getActiveExtStaff",method=RequestMethod.GET)
	public ResponseEntity<List<ExternalStaff>> getActiveExtStaff() throws ResourceNotFoundException{
		return new ResponseEntity<List<ExternalStaff>>(externalStaffServiceImpl.getActiveExternalStaff(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get  external Staff by external staff name
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getExtStaffByName/{extStaffName}",method=RequestMethod.GET)
	public ResponseEntity<List<ExternalStaff>> getExtStaffByName(@PathVariable("extStaffName") String externalStaffName) throws ResourceNotFoundException{
		return new ResponseEntity<List<ExternalStaff>>(externalStaffServiceImpl.getExternalStaffByName(externalStaffName),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to update the external Staff
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/updateExtStaff",method=RequestMethod.POST)
	public ResponseEntity<String> updateExtStaff(@RequestBody @Valid ExternalStaffTO externalStaffTO) throws ResourceNotCreatedException,ResourceNotUpdatedException{
		return new ResponseEntity<String>(externalStaffServiceImpl.updateExternalStaff(externalStaffTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to delete  external Staff by external staff id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/deleteExtStaff/{extStaffId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteExtStaff(@PathVariable("extStaffId") int externalStaffId) throws ResourceNotFoundException{
		return new ResponseEntity<String>(externalStaffServiceImpl.deleteExternalStaff(externalStaffId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to create external Staff
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/createExtStaff",method=RequestMethod.POST)
	public ResponseEntity<String> createExtStaff(@RequestBody @Valid ExternalStaffTO externalStaffTO) throws ResourceNotCreatedException{
		return new ResponseEntity<String>(externalStaffServiceImpl.createExternalStaff(externalStaffTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next external Staff id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextExtStaffId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextExtStaffId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(externalStaffServiceImpl.getNextExternalStaffId(),HttpStatus.OK);
	}
}

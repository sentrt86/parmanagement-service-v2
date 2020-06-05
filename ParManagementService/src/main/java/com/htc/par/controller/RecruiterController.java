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
import com.htc.par.model.Recruiter;
import com.htc.par.service.RecruiterServiceImpl;
import com.htc.par.to.RecruiterTO;

@RestController
@RequestMapping("/par/recruiter")
public class RecruiterController {
	
	
	@Autowired
	RecruiterServiceImpl recruiterServiceImpl;
	
	/*
	 * Request handler to get all the recruiter
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getRecruiters",method=RequestMethod.GET)
	public ResponseEntity<List<Recruiter>> getAllRecruiter() throws ResourceNotFoundException{
		return new ResponseEntity<List<Recruiter>>(recruiterServiceImpl.getAllRecruiter(),HttpStatus.OK);		
	}

	/*
	 * Request handler to get  recruiter by recruiter id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getRecruiterById/{recruiterId}",method=RequestMethod.GET)
	public ResponseEntity<List<Recruiter>> getRecruiterById(@PathVariable("recruiterId") int recruiterId) throws ResourceNotFoundException{
		return new ResponseEntity<List<Recruiter>>(recruiterServiceImpl.getRecruiterById(recruiterId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get all the recruiter who are active
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getActiveRecruiter",method=RequestMethod.GET)
	public ResponseEntity<List<Recruiter>> getActiveRecruiter() throws ResourceNotFoundException{
		return new ResponseEntity<List<Recruiter>>(recruiterServiceImpl.getActiveRecruiter(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get  recruiter by recruiter name
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getRecruiterByName/{recruiterName}",method=RequestMethod.GET)
	public ResponseEntity<List<Recruiter>> getRecruiterByName(@PathVariable("recruiterName") String recruiterName) throws ResourceNotFoundException{
		return new ResponseEntity<List<Recruiter>>(recruiterServiceImpl.getRecruiterByName(recruiterName),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to update the recruiter
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/updateRecruiter",method=RequestMethod.POST)
	public ResponseEntity<String> updateRecruiter(@RequestBody @Valid RecruiterTO recruiterTO) throws ResourceNotCreatedException,ResourceNotUpdatedException{
		return new ResponseEntity<String>(recruiterServiceImpl.updateRecruiter(recruiterTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to delete  recruiter by recruiter id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/deleteRecruiter/{recruiterId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteRecruiter(@PathVariable("recruiterId") int recruiterId) throws ResourceNotFoundException{
		return new ResponseEntity<String>(recruiterServiceImpl.deleteRecruiter(recruiterId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to create recruiter
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/createRecruiter",method=RequestMethod.POST)
	public ResponseEntity<String> createRecruiter(@RequestBody @Valid RecruiterTO recruiterTO) throws ResourceNotCreatedException{
		return new ResponseEntity<String>(recruiterServiceImpl.createRecruiter(recruiterTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next recruiter id
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextRecruiterId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextRecruiterId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(recruiterServiceImpl.getNextRecruiterId(),HttpStatus.OK);
	}
	
	

}

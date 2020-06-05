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
import com.htc.par.model.Candidate;
import com.htc.par.service.CandidateServiceImpl;
import com.htc.par.to.CandidateTO;

@RestController
@RequestMapping("/par/candidate")
public class CandidateController {
	
	@Autowired
	CandidateServiceImpl candidateServiceImpl;
	
	/*
	 * Request handler to get all the candidate
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getCandidates",method=RequestMethod.GET)
	public ResponseEntity<List<Candidate>> getAllCandidate() throws ResourceNotFoundException{
		return new ResponseEntity<List<Candidate>>(candidateServiceImpl.getAllCandidate(),HttpStatus.OK);		
	}

	/*
	 * Request handler to get  candidate by candidate id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getCandidateById/{candidateId}",method=RequestMethod.GET)
	public ResponseEntity<List<Candidate>> getCandidateById(@PathVariable("candidateId") int candidateId) throws ResourceNotFoundException{
		return new ResponseEntity<List<Candidate>>(candidateServiceImpl.getCandidateById(candidateId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get all the candidate who are active
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getActiveCandidate",method=RequestMethod.GET)
	public ResponseEntity<List<Candidate>> getActiveCandidate() throws ResourceNotFoundException{
		return new ResponseEntity<List<Candidate>>(candidateServiceImpl.getActiveCandidate(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get  candidate by candidate name
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getCandidateByName/{candidateName}",method=RequestMethod.GET)
	public ResponseEntity<List<Candidate>> getCandidateByName(@PathVariable("candidateName") String candidateName) throws ResourceNotFoundException{
		return new ResponseEntity<List<Candidate>>(candidateServiceImpl.getCandidateByName(candidateName),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to update the candidate
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/updateCandidate",method=RequestMethod.POST)
	public ResponseEntity<String> updateCandidate(@RequestBody @Valid CandidateTO candidateTO) throws ResourceNotCreatedException,ResourceNotUpdatedException{
		return new ResponseEntity<String>(candidateServiceImpl.updateCandidate(candidateTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to delete  candidate by candidate id
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/deleteCandidate/{candidateId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteCandidate(@PathVariable("candidateId") int candidateId) throws ResourceNotFoundException{
		return new ResponseEntity<String>(candidateServiceImpl.deleteCandidate(candidateId),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to create candidate
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/createCandidate",method=RequestMethod.POST)
	public ResponseEntity<String> createCandidate(@RequestBody @Valid CandidateTO candidateTO) throws ResourceNotCreatedException{
		return new ResponseEntity<String>(candidateServiceImpl.createCandidate(candidateTO),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next candidate id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextCandidateId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextCandidateId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(candidateServiceImpl.getNextCandidateId(),HttpStatus.OK);
	}

}

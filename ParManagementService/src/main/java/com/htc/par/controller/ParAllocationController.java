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

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.model.ParAllocation;
import com.htc.par.service.ParAllocationServiceImpl;
import com.htc.par.to.ParAllocationTO;

@RestController
@RequestMapping("/par/parallocation")
public class ParAllocationController {
	
	
	@Autowired
	ParAllocationServiceImpl parAllocationServiceImpl;
	
	
	/*
	 * Request handler to get the par allocation information for particular par num
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getParAllocationByParNum/{parNum}",method=RequestMethod.GET)
	public ResponseEntity<List<ParAllocation>> getParAllocationByParNum(@PathVariable("parNum") String parNum) throws ResourceNotCreatedException{
		return new  ResponseEntity<List<ParAllocation>>(parAllocationServiceImpl.getParAllocationByParNum(parNum),HttpStatus.OK);
	}
	
	/*
	 * Request handler to get the par allocation (candidate Received) information for particular par num 
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getCandidateReceivedByParNum/{parNum}",method=RequestMethod.GET)
	public ResponseEntity<List<ParAllocation>> getCandidateReceivedByParNum(@PathVariable("parNum") String parNum) throws ResourceNotCreatedException{
		return new  ResponseEntity<List<ParAllocation>>(parAllocationServiceImpl.getCandidateReceivedByParNum(parNum),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete the par allocation (candidate Received) information for particular par allocation id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteParAllocationParAllocId/{parAllocId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteCandidateReceivedByParAllocId(@PathVariable("parAllocId") int parAllocId) throws ResourceNotCreatedException{
		System.out.println("delete service:"+parAllocId);
		return new  ResponseEntity<String>(parAllocationServiceImpl.deleteParAllocationByParAllocId(parAllocId),HttpStatus.OK);
	}
	

	/*
	 * Request handler to create the par allocation
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createParAllocation",method=RequestMethod.POST)
	public ResponseEntity<String> createCandidateReceived(@RequestBody @Valid ParAllocationTO parAllocationTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(parAllocationServiceImpl.createParAllocation(parAllocationTO),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to update the par allocation (submit candidate) for particular par num
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/updateSubmitCandidate",method=RequestMethod.POST)
	public ResponseEntity<String> updateSubmitCandidate(@RequestBody @Valid ParAllocationTO parAllocationTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(parAllocationServiceImpl.updateSubmitCandidate(parAllocationTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update the par allocation (prescreening) for particular par num
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/updatePrescreening",method=RequestMethod.POST)
	public ResponseEntity<String> updatePrescreening(@RequestBody @Valid ParAllocationTO parAllocationTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(parAllocationServiceImpl.updatePrescreening(parAllocationTO),HttpStatus.OK);
	}
	

}

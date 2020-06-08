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
import com.htc.par.model.Prescreener;
import com.htc.par.service.PrescreenerServiceImpl;
import com.htc.par.to.PrescreenerTO;

@RestController
@RequestMapping("/par/prescreener")
public class PrescreenerController {
	
	
	@Autowired
	PrescreenerServiceImpl preScreenerServiceImpl;
	
	/*
	 * Request handler to get all the prescreeners
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getPrescreeners",method=RequestMethod.GET)
	public ResponseEntity<List<Prescreener>> getAllPrescreeners() throws ResourceNotFoundException{
		return new ResponseEntity<List<Prescreener>>(preScreenerServiceImpl.getAllPrescreeners(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get all the prescreeners
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getActivePrescreeners",method=RequestMethod.GET)
	public ResponseEntity<List<Prescreener>> getActivePrescreeners() throws ResourceNotFoundException{
		return new ResponseEntity<List<Prescreener>>(preScreenerServiceImpl.getActivePrescreeners(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getNextPrescreenerId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextPrescreenerId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(preScreenerServiceImpl.getNextPrescreenerId(),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete a Prescreener by id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deletePrescreener/{preScreenerId}",method=RequestMethod.POST)
	public ResponseEntity<String> deletePrescreener(@PathVariable("preScreenerId") int preScreenerId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(preScreenerServiceImpl.deletePrescreener(preScreenerId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update a Prescreener by Prescreener UI values
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updatePrescreener",method=RequestMethod.POST)
	public ResponseEntity<String> updatePrescreener(@RequestBody @Valid PrescreenerTO prescreenerTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(preScreenerServiceImpl.updatePrescreener(prescreenerTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to Add a preScreener
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createPrescreener",method=RequestMethod.POST)
	public ResponseEntity<String> createPrescreener(@RequestBody @Valid PrescreenerTO prescreenerTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(preScreenerServiceImpl.createPrescreener(prescreenerTO),HttpStatus.OK);
	}

}

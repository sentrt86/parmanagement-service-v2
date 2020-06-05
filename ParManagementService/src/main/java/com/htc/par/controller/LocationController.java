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
import com.htc.par.model.Location;
import com.htc.par.service.LocationServiceImpl;
import com.htc.par.to.LocationTO;

@RestController
@RequestMapping("/par/location")
public class LocationController {
	
	
	@Autowired
	LocationServiceImpl locationServiceimpl;
	
	/*
	 * Request handler to get all the locations
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getLocations",method=RequestMethod.GET)
	public ResponseEntity<List<Location>> getAllLocations() throws ResourceNotFoundException{
		return new ResponseEntity<List<Location>>(locationServiceimpl.getAllLocations(),HttpStatus.OK);		
	}
	
	
	
	@RequestMapping(value="/getNextLocationId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextlocationId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(locationServiceimpl.getNextLocationId(),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete a location by id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteLocation/{locationId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteLocation(@PathVariable("locationId") int locationId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(locationServiceimpl.deleteLocation(locationId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update a location by location UI values
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateLocation",method=RequestMethod.POST)
	public ResponseEntity<String> updatelocation(@RequestBody @Valid LocationTO locationTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(locationServiceimpl.updateLocation(locationTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to Add a preScreener
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createLocation",method=RequestMethod.POST)
	public ResponseEntity<String> createLocation(@RequestBody @Valid LocationTO locationTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(locationServiceimpl.createLocation(locationTO),HttpStatus.OK);
	}

}

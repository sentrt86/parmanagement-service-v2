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
import com.htc.par.model.Area;
import com.htc.par.service.AreaServiceImpl;
import com.htc.par.to.AreaTO;

@RestController
@RequestMapping("/par/area")
public class AreaController {
	
	@Autowired
	AreaServiceImpl areaServiceImpl;
	
	/*
	 * Request handler to get all the areas
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getAreas",method=RequestMethod.GET)
	public ResponseEntity<List<Area>> getAllArea() throws ResourceNotFoundException{
		return new ResponseEntity<List<Area>>(areaServiceImpl.getAllAreas(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next area id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextAreaId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextAreaId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(areaServiceImpl.getNextAreaId(),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to get an Area by area id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getAreaById/{areaId}",method=RequestMethod.GET)
	public ResponseEntity<List<Area>> getAreaById(@PathVariable("areaId") int areaId) throws ResourceNotFoundException{
		return new  ResponseEntity<List<Area>>(areaServiceImpl.getAreaById(areaId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete an Area by area id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteArea/{areaId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteArea(@PathVariable("areaId") int areaId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(areaServiceImpl.deleteArea(areaId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update an Area by area id
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateArea",method=RequestMethod.POST)
	public ResponseEntity<String> updateArea(@RequestBody @Valid AreaTO areaTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(areaServiceImpl.updateArea(areaTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to create an Area
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createArea",method=RequestMethod.POST)
	public ResponseEntity<String> createArea(@RequestBody @Valid AreaTO areaTO) throws ResourceNotCreatedException{
		System.out.println("ser:"+areaTO.toString());
		return new  ResponseEntity<String>(areaServiceImpl.createArea(areaTO),HttpStatus.OK);
	}

}

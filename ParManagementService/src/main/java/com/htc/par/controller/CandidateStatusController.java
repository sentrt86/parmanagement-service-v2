package com.htc.par.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.Area;
import com.htc.par.model.ParMaster;
import com.htc.par.service.CandidateStatusServiceImpl;



@RestController
@RequestMapping("/par")
public class CandidateStatusController {
	
	@Autowired 
	CandidateStatusServiceImpl candidateStatusServiceImpl;
	
	@RequestMapping(value="/getParMasterBycandidateId/{candidateId}",method=RequestMethod.GET)
	public ResponseEntity<List<ParMaster>> getParMasterbyCandidateId(@PathVariable("candidateId") int candidateId) throws ResourceNotFoundException{
		System.out.println("Senthil Skips starte -controller2");
		return new  ResponseEntity<List<ParMaster>>(candidateStatusServiceImpl.getParMasterbyCandidateId(candidateId),HttpStatus.OK);
	}

}

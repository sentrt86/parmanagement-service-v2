package com.htc.par.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.par.data.daoimpl.CandidateStatusDAOImpl;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.ParMaster;

@Service
public class CandidateStatusServiceImpl {
	
	@Autowired
	CandidateStatusDAOImpl candidateStatusDAOImpl;
	
	public List<ParMaster> getParMasterbyCandidateId( int candidateId) throws ResourceNotFoundException {
		System.out.println("Senthil Skips starte -service-2");
		List<ParMaster> parmasters = candidateStatusDAOImpl.getParMasterbyCandidateId(candidateId);
		System.out.println("Service method 2");
		System.out.println(parmasters);
		return parmasters;
		
		
	}

}

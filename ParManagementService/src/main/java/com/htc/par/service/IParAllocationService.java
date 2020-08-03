package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

@Service
public interface IParAllocationService {
	
	List<ParAllocation> getParAllocationByParNum(String parNum) throws ResourceNotFoundException;
	String deleteParAllocationByParAllocId(int parAllocId) throws ResourceNotFoundException;
	
	String createParAllocation(ParAllocationTO parAllocation) throws ResourceNotCreatedException;	
	List<ParAllocation> getCandidateReceivedByParNum(String parNum) throws ResourceNotFoundException;
	List<ParAllocation> getCandidateReceivedByParCode(int parCode) throws ResourceNotFoundException;
	
	String updateSubmitCandidate(ParAllocationTO parAllocationTO) throws ResourceNotCreatedException;
	String updatePrescreening(ParAllocationTO parAllocationTO) throws ResourceNotCreatedException;
	

}

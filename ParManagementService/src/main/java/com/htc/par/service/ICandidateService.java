package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Candidate;
import com.htc.par.to.CandidateTO;

@Service
public interface ICandidateService {
	
	List<Candidate> getAllCandidate() throws ResourceNotFoundException;
	List<Candidate> getCandidateById(int candidateId) throws ResourceNotFoundException;
	List<Candidate> getActiveCandidate() throws ResourceNotFoundException;
	List<Candidate> getCandidateByName(String candidateName) throws ResourceNotFoundException;
	String updateCandidate(CandidateTO candidateTO) throws ResourceNotFoundException, ResourceNotUpdatedException;
	String deleteCandidate(int candidateId) throws ResourceNotFoundException;
	String createCandidate(CandidateTO candidateTO) throws ResourceNotCreatedException; 
	int getNextCandidateId() throws ResourceAccessException;

}

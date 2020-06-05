package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Candidate;

public interface ICandidateDAO {
	
	
	List<Candidate> getAllCandidates();
	List<Candidate> getCandidateById(int candidateId);
	List<Candidate> getActiveCandidate();
	List<Candidate> getCandidateByName(String candidateIdName);
	Boolean updateCandidate(Candidate externalStaff);
	Boolean deleteCandidate(int candidateId);
	boolean createCandidate(Candidate candidate); 
	int getNextCandidateId();

}

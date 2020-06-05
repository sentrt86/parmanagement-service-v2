package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Recruiter;
import com.htc.par.to.RecruiterTO;

@Service
public interface IRecruiterService {
	
	List<Recruiter> getAllRecruiter() throws ResourceNotFoundException;
	List<Recruiter> getRecruiterById(int recruiterId) throws ResourceNotFoundException;
	List<Recruiter> getActiveRecruiter() throws ResourceNotFoundException;
	List<Recruiter> getRecruiterByName(String recruiterName) throws ResourceNotFoundException;
	String updateRecruiter(RecruiterTO recruiterTO) throws ResourceNotFoundException,ResourceNotUpdatedException;
	String deleteRecruiter(int recruiterId) throws ResourceNotFoundException;
	String createRecruiter(RecruiterTO recruiterTO) throws ResourceNotCreatedException; 
	int getNextRecruiterId() throws ResourceAccessException;
	
	

}

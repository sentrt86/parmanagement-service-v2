package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Recruiter;

public interface IRecruiterDAO {
	
	List<Recruiter> getAllRecruiter();
	List<Recruiter> getRecruiterById(int recruiterId);
	List<Recruiter> getActiveRecruiter();
	List<Recruiter> getRecruiterByName(String recruiterName);
	Boolean updateRecruiter(Recruiter recruiter);
	Boolean deleteRecruiter(int recruiterId);
	boolean createRecruiter(Recruiter recruiter); 
	int getNextRecruiterId();

}

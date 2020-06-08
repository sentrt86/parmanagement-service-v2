package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.RecruiterDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Recruiter;
import com.htc.par.to.RecruiterTO;

@Service
public class RecruiterServiceImpl implements IRecruiterService {


	@Autowired
	RecruiterDAOImpl recruiterDaoImpl;

	/*
	 * Request handler to GET all external Staff
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */

	@Override
	public List<Recruiter> getAllRecruiter() {
		List<Recruiter> recruiterList = new ArrayList<Recruiter> ();		
		try {
			recruiterList = recruiterDaoImpl.getAllRecruiter();	
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return recruiterList;
	}

	/*
	 * GET Recruiter by external recruiter id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<Recruiter> getRecruiterById(int recruiterId) {
		List<Recruiter> recruiterList = new ArrayList<Recruiter> (); 
		try {
			recruiterList = recruiterDaoImpl.getRecruiterById(recruiterId);
			if(recruiterList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Recruiter Id %S",recruiterId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Recruiter Id %S",recruiterId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return recruiterList; 
	}

	/*
	 * GET all active recruiter
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<Recruiter> getActiveRecruiter() {
		List<Recruiter> recruiterList = new ArrayList<Recruiter> ();		
		try {
			recruiterList = recruiterDaoImpl.getActiveRecruiter();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return recruiterList;
	}

	/*
	 * GET Recruiter by recruiter name
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<Recruiter> getRecruiterByName(String recruiterName) {
		List<Recruiter> recruiterList = new ArrayList<Recruiter> (); 
		try {
			recruiterList = recruiterDaoImpl.getRecruiterByName(recruiterName);
			if(recruiterList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Recruiter Id %S",recruiterName));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Recruiter Id %S",recruiterName));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return recruiterList; 
	}

	/*
	 * Update the recruiter informations 
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String updateRecruiter(RecruiterTO recruiterTO) {
		try { 
			boolean updateRecruiterSuccess = recruiterDaoImpl.updateRecruiter(new Recruiter(recruiterTO.getRecruiterId(),recruiterTO.getRecruiterName(),recruiterTO.getRecruiterPhoneNo(),recruiterTO.getRecruiterEmail(),recruiterTO.getRecruiterEmailFlag(),recruiterTO.getRecruiterActive())); 

			if(updateRecruiterSuccess ) { 
				return String.format(ParConstants.updateSuccessfull + "for Recruiter : %s",recruiterTO.getRecruiterName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Recruitr : %s",recruiterTO.getRecruiterName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Recruiter : %s",recruiterTO.getRecruiterName()); 

	}


	/*
	 * Delete the Recruiter for a give recruiter id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String deleteRecruiter(int recruiterId) {
		try { 
			boolean deleteRecruiter = recruiterDaoImpl.deleteRecruiter(recruiterId); 
			if(deleteRecruiter) { 
				return String.format(ParConstants.deleteSuccessfull + "for Recruiter Id: " + recruiterId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Recruiter  Id : " + recruiterId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Recruiter Id : %s",recruiterId); 
	}

	/*
	 * Create the Recruiter information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String createRecruiter(RecruiterTO recruiterTO) {
		List<Recruiter> allRecruiterList = new ArrayList<Recruiter>();

		try { 
			allRecruiterList = recruiterDaoImpl.getAllRecruiter(); 
			if(!allRecruiterList.isEmpty()) {
				for(Recruiter data : allRecruiterList) 
				{ 
					if (data.getRecruiterName().equalsIgnoreCase(recruiterTO.getRecruiterName()) && data.getRecruiterPhoneNo().equalsIgnoreCase(recruiterTO.getRecruiterPhoneNo())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Recruiter : %s",recruiterTO.getRecruiterName()));
					} 
				} 


			}
			if(recruiterDaoImpl.createRecruiter(new Recruiter(recruiterTO.getRecruiterId(),recruiterTO.getRecruiterName(),recruiterTO.getRecruiterPhoneNo(),recruiterTO.getRecruiterEmail(),recruiterTO.getRecruiterEmailFlag(),recruiterTO.getRecruiterActive())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for External Staff : %s",recruiterTO.getRecruiterName()); 
			} 

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for Recruiter : %s ",recruiterTO.getRecruiterName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Recruiter : %s",recruiterTO.getRecruiterName());

	}

	/*
	 * Get the next Recruiter from the recruiter_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public int getNextRecruiterId() {
		try {
			return recruiterDaoImpl.getNextRecruiterId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

}

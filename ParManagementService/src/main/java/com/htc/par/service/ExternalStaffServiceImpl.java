package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ExternalStaffDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ExternalStaff;
import com.htc.par.to.ExternalStaffTO;

@Service
public class ExternalStaffServiceImpl implements IExternalStaffService {

	@Autowired
	ExternalStaffDAOImpl externalStaffDaoImpl;
	
	/*
	 * Request handler to GET all external Staff
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */
	
	@Override
	public List<ExternalStaff> getAllExternalStaff() {
		List<ExternalStaff> externalStaffList = new ArrayList<ExternalStaff> ();		
		try {
			externalStaffList = externalStaffDaoImpl.getAllExternalStaff();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return externalStaffList;
	}

	/*
	 * GET External Staff by external Staff id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */
	
	@Override
	public List<ExternalStaff> getExternalStaffById(int externalStaffId) {
		List<ExternalStaff> externalStaffList = new ArrayList<ExternalStaff> (); 
		try {
			externalStaffList = externalStaffDaoImpl.getExternalStaffById(externalStaffId);
			if(externalStaffList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for External Staff Id %S",externalStaffId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for External Staff Id %S",externalStaffId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return externalStaffList; 
	}

	/*
	 * GET all active External Staff
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */
	
	@Override
	public List<ExternalStaff> getActiveExternalStaff() {
		List<ExternalStaff> externalStaffList = new ArrayList<ExternalStaff> ();		
		try {
			externalStaffList = externalStaffDaoImpl.getActiveExternalStaff();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return externalStaffList;
	}
	
	/*
	 * GET External Staff by external Staff name
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<ExternalStaff> getExternalStaffByName(String externalStaffName) {
		List<ExternalStaff> externalStaffList = new ArrayList<ExternalStaff> (); 
		try {
			externalStaffList = externalStaffDaoImpl.getExternalStaffByName(externalStaffName);
			if(externalStaffList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for External Staff  %S",externalStaffName));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for External Staff %S",externalStaffName));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return externalStaffList; 
	}

	/*
	 * Update the external Staff informations for give external staff id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String updateExternalStaff(ExternalStaffTO externalStaffTO) {
		List<ExternalStaff> allExtStaffList = new ArrayList<ExternalStaff>();
		try { 
			allExtStaffList = externalStaffDaoImpl.getAllExternalStaff(); 
			if(!allExtStaffList.isEmpty()) {
				for(ExternalStaff data : allExtStaffList) 
				{ 
					if (data.getExtStaffName().equalsIgnoreCase(externalStaffTO.getExtStaffName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for External Staff : %s",externalStaffTO.getExtStaffName()));
					} 
				} 
				
				boolean updateExtStaffSuccess = externalStaffDaoImpl.updateExternalStaff(new ExternalStaff(externalStaffTO.getExtStaffId(),externalStaffTO.getExtStaffName(),externalStaffTO.getArea(),externalStaffTO.getExtStaffActive())); 
				
				if(updateExtStaffSuccess ) { 
					return String.format(ParConstants.updateSuccessfull + "for External Staff: %s",externalStaffTO.getExtStaffName()); 
					}
			}
			
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for External Staff : %s",externalStaffTO.getExtStaffName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for External Staff: %s",externalStaffTO.getExtStaffName()); 

	}

	
	/*
	 * Delete the External Staff for a give external Staff id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String deleteExternalStaff(int externalStaffId) {
		try { 
			boolean deleteExtStaffSuccess = externalStaffDaoImpl.deleteExternalStaff(externalStaffId); 
			if(deleteExtStaffSuccess) { 
				return String.format(ParConstants.deleteSuccessfull + "for External Staff Id: " + externalStaffId); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for External Staff  Id : " + externalStaffId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for External Staff Id : %s",externalStaffId); 
	}

	/*
	 * Create the External Staff information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */
	
	@Override
	public String createExternalStaff(ExternalStaffTO externalStaffTO) {
		List<ExternalStaff> allExtStaffList = new ArrayList<ExternalStaff>();

		try { 
			allExtStaffList = externalStaffDaoImpl.getAllExternalStaff(); 
			if(!allExtStaffList.isEmpty()) {
				for(ExternalStaff data : allExtStaffList) 
				{ 
					if (data.getExtStaffName().equalsIgnoreCase(externalStaffTO.getExtStaffName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for External Staff : %s",externalStaffTO.getExtStaffName()));
					} 
				} 

			}

			if(externalStaffDaoImpl.createExternalStaff(new ExternalStaff(externalStaffTO.getExtStaffId(),externalStaffTO.getExtStaffName(),externalStaffTO.getArea(),externalStaffTO.getExtStaffActive())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for External Staff : %s",externalStaffTO.getExtStaffName()); 
			} 

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for External Staff : %s ",externalStaffTO.getExtStaffName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for External Staff : %s",externalStaffTO.getExtStaffName());

	}
	
	/*
	 * Get the next external Staff id from the ext_staff_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public int getNextExternalStaffId() {
		try {
			return externalStaffDaoImpl.getNextExternalStaffId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

}

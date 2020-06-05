package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ExternalStaff;
import com.htc.par.to.ExternalStaffTO;

@Service
public interface IExternalStaffService {
	List<ExternalStaff> getAllExternalStaff() throws ResourceNotFoundException;
	List<ExternalStaff> getExternalStaffById(int externalStaffId) throws ResourceNotFoundException;
	List<ExternalStaff> getActiveExternalStaff() throws ResourceNotFoundException;
	List<ExternalStaff> getExternalStaffByName(String externalStaffName) throws ResourceNotFoundException;
	String updateExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceNotFoundException, ResourceNotUpdatedException;
	String deleteExternalStaff(int externalStaffId) throws ResourceNotFoundException;
	String createExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceNotCreatedException; 
	int getNextExternalStaffId() throws ResourceAccessException;

}

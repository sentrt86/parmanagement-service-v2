package com.htc.par.data.dao;

import java.util.List;
import com.htc.par.model.ExternalStaff;

public interface IExternalStaffDAO {
	
	
	List<ExternalStaff> getAllExternalStaff();
	List<ExternalStaff> getExternalStaffById(int externalStaffId);
	List<ExternalStaff> getActiveExternalStaff();
	List<ExternalStaff> getExternalStaffByName(String externalStaffName);
	Boolean updateExternalStaff(ExternalStaff externalStaff);
	Boolean deleteExternalStaff(int externalStaffId);
	boolean createExternalStaff(ExternalStaff externalStaff); 
	int getNextExternalStaffId();

}

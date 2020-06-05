package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IExternalStaffDAO;
import com.htc.par.data.mapper.ExternalStaffRowMapper;
import com.htc.par.model.ExternalStaff;

@Repository
public class ExternalStaffDAOImpl implements IExternalStaffDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Get all the External Staff from the ext_staff_lkup table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalStaff> getAllExternalStaff() {
		return jdbcTemplate.query(ParSqlQueries.getAllExtStaffQuery,new Object[]{}, new ExternalStaffRowMapper());		
	}

	//Get the External Staff from the ext_staff_lkup by external staff id
	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalStaff> getExternalStaffById(int externalStaffId) {
		return jdbcTemplate.query(ParSqlQueries.getExtStaffByIdQuery,new Object[]{externalStaffId}, new ExternalStaffRowMapper());
	}

	//Get all active external staff from ext_staff_lkup table 
	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalStaff> getActiveExternalStaff() {
		return jdbcTemplate.query(ParSqlQueries.getactiveExtStaff,new Object[]{}, new ExternalStaffRowMapper());		
	}

	//Get external Staff from the ext_staff_lkup by staff name
	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalStaff> getExternalStaffByName(String externalStaffName) {
		return jdbcTemplate.query(ParSqlQueries.getExtStaffByName,new Object[]{externalStaffName}, new ExternalStaffRowMapper());
	}

	//Update external Staff information 

	@Override public Boolean updateExternalStaff(ExternalStaff externalStaff) {
		boolean externalStaffUpdated = false;

		System.out.println(externalStaff.toString());
		Object[] parms = new Object[] {externalStaff.getExtStaffName(),externalStaff.getArea().getAreaId(),externalStaff.getExtStaffActive(),externalStaff.getExtStaffId()}; 
		int[] parmsTypes = new int[] {Types.CHAR,Types.INTEGER,Types.BOOLEAN,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateExtStaff,parms,parmsTypes); 
		if (updateCount > 0) 
		{ 
			externalStaffUpdated = true; 
		} 
		return externalStaffUpdated; }


	//Delete external Staff information by external staff id
	
	@Override
	public Boolean deleteExternalStaff(int externalStaffId) {
		boolean externalStaffDeleted = false;		
		Object[] parms = new Object[] {externalStaffId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteExtStaff,parms,parmsType);
		if (deleteCount > 0)
		{
			externalStaffDeleted = true;
		}
		return externalStaffDeleted;
	}

	//Create external staff 
	
	  @Override
	  
	  public boolean createExternalStaff(ExternalStaff externalStaff) { 
		  
	  boolean externalStaffCreated = false; 
	  Object[] parms = new Object[] {externalStaff.getExtStaffId(),externalStaff.getExtStaffName(),externalStaff.getArea().getAreaId(),externalStaff.getExtStaffActive()};
	  int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.INTEGER,Types.BOOLEAN}; 
	  int createCount = jdbcTemplate.update(ParSqlQueries.createExtStaff,parms,parmsType); 
	  if (createCount > 0) 
	  { 
		  externalStaffCreated = true;
	  } 
	  return externalStaffCreated; 
	  
	  }
	 
	 

	//Get the next external staff id 
	@Override
	public int getNextExternalStaffId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextExtStaffId,new Object[] {},Integer.class);
	}
	

}

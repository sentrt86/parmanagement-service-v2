package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Area;
import com.htc.par.model.ExternalStaff;



@SuppressWarnings("rawtypes")
public class ExternalStaffRowMapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		final ExternalStaff externalStaff = new ExternalStaff();
		
		final Area area = new Area();
		
		area.setAreaId(rs.getInt("AREA_ID"));
		area.setAreaName(rs.getString("AREA_NM"));
		area.setAreaActive(rs.getBoolean("AREA_ACTIVE"));
		
		
		externalStaff.setExtStaffId(rs.getInt("EXT_STAFF_ID"));
		externalStaff.setExtStaffName(rs.getString("EXT_STAFF_NM"));
		externalStaff.setArea(area);		
		externalStaff.setExtStaffActive(rs.getBoolean("EXT_STAFF_ACTIVE"));
		return externalStaff;
		
	}

}

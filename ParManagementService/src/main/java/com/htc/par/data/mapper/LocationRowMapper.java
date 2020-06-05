package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Location;

@SuppressWarnings("rawtypes")
public class LocationRowMapper implements RowMapper {
	
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Location location = new Location();		
		location.setLocationId(rs.getInt("LOC_ID"));
		location.setLocationName(rs.getString("LOC_NM"));
		location.setLocationActive(rs.getBoolean("LOC_ACTIVE"));
		return location;
	}

	

}

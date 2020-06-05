package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.ParRole;



@SuppressWarnings("rawtypes")
public class ParRoleRowMapper implements RowMapper {
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		final ParRole role = new ParRole();
		
		role.setRoleId(rs.getInt("ROLE_ID"));
		role.setRoleName(rs.getString("ROLE_NM"));
		role.setRoleActive(rs.getBoolean("ROLE_ACTIVE"));		
		return role;
	}

}

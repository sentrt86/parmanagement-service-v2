package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.UserRole;

@SuppressWarnings("rawtypes")
public class UserRoleRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRole userRole = new UserRole();
		userRole.setUserRoleId(rs.getInt("USER_ROLE_ID"));
		userRole.setUserRoleName(rs.getString("USER_ROLE_NM"));
		return userRole;
	}

}

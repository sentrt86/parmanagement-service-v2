package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.UserMaster;
import com.htc.par.model.UserRole;

@SuppressWarnings("rawtypes")
public class UserMasterRowMapper  implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserMaster userMaster = new UserMaster();
		
		UserRole userRole = new UserRole();
		
		userRole.setUserRoleId(rs.getInt("USER_ROLE_ID"));
		userRole.setUserRoleName(rs.getString("USER_ROLE_NM"));
		
		userMaster.setUserId(rs.getInt("USER_ID"));
		userMaster.setUserFirstName(rs.getString("USER_FIRST_NM"));
		userMaster.setUserLastName(rs.getString("USER_LAST_NM"));
		userMaster.setUserEmailTxt(rs.getString("USER_EMAIL_TXT"));
		userMaster.setUserPhoneNo(rs.getString("USER_PHN_NUM"));
		userMaster.setUserName(rs.getString("USER_USR_NM"));
		userMaster.setPassword(rs.getString("USER_PWD"));
		userMaster.setUserActive(rs.getBoolean("USER_ACTIVE"));
		userMaster.setUserRole(userRole);
		return userMaster;
	}

}

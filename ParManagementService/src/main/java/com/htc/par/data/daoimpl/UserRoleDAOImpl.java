package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IUserRoleDAO;
import com.htc.par.data.mapper.UserRoleRowMapper;
import com.htc.par.model.UserRole;

@Repository
public class UserRoleDAOImpl implements IUserRoleDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUserRole() {		
		return jdbcTemplate.query(ParSqlQueries.getAllUserRoleQuery,new Object[]{}, new UserRoleRowMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoleById(int userRoleId) {
		return jdbcTemplate.query(ParSqlQueries.getUserRoleByIdQuery,new Object[]{userRoleId}, new UserRoleRowMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoleByName(String userRoleName) {
		return jdbcTemplate.query(ParSqlQueries.updateUserRoleQuery,new Object[]{userRoleName}, new UserRoleRowMapper());
	}

	@Override
	public Boolean updateUserRole(UserRole userRole) {
		boolean userRoleUpdated = false;
		
		Object[] parms = new Object[] {userRole.getUserRoleName(),userRole.getUserRoleId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateUserRoleQuery,parms,parmsTypes);		
		if (updateCount > 0)
		{
			userRoleUpdated = true;
		}
		return userRoleUpdated;
	}

	@Override
	public Boolean deleteUserRole(int userRoleId) {
		boolean userRoleDeleted = false;
		
		Object[] parms = new Object[] {userRoleId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteUserRoleQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			userRoleDeleted = true;
		}
		return userRoleDeleted;
	}

	@Override
	public Boolean createUserRole(UserRole userRole) {
		boolean userRoleCreated = false;
		
		Object[] parms = new Object[] {userRole.getUserRoleId(),userRole.getUserRoleName()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR};
		int createCount = jdbcTemplate.update(ParSqlQueries.createUserRoleQuery,parms,parmsType);
		if (createCount > 0)
		{
			userRoleCreated = true;
		}
		return userRoleCreated;
	}

	@Override
	public int getNextUserRoleId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextUserRoleIdQuery,new Object[]{}, Integer.class);
	}

}

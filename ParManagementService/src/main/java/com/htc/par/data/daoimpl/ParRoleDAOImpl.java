package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IParRoleDAO;
import com.htc.par.data.mapper.ParRoleRowMapper;
import com.htc.par.model.ParRole;

@Repository
public class ParRoleDAOImpl  implements IParRoleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Get all the role from the role_lkup table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParRole> getAllParRoles() {
		return  jdbcTemplate.query(ParSqlQueries.getAllRoleQuery,new Object[]{}, new ParRoleRowMapper());	
	}
	
	//Get all the role from the role_lkup table by role id

	@SuppressWarnings("unchecked")
	@Override
	public List<ParRole> getParRoleById(int roleId) {
		return	jdbcTemplate.query(ParSqlQueries.getRoleByIdQuery,new Object[]{roleId}, new ParRoleRowMapper());
	}

	
	//Get all the active role from the role_lkup table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParRole> getActiveParRole() {
		return jdbcTemplate.query(ParSqlQueries.getactiveRole,new Object[]{}, new ParRoleRowMapper());		
	}

	//Update  the role information into the role_lkup table
	
	@Override
	public Boolean updateParRole(ParRole parRole) {
		boolean roleUpdated = false;		
		Object[] parms = new Object[] {parRole.getRoleName(), parRole.getRoleActive(),parRole.getRoleId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.BOOLEAN,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateRole,parms,parmsTypes);		
		if (updateCount > 0)
		{
			roleUpdated = true;
		}
		return roleUpdated;
	}
	
	//Delete the role from the role_lkup table using role id

	@Override
	public Boolean deleteParRole(int roleId) {
		boolean roleDeleted = false;		
		Object[] parms = new Object[] {roleId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteRole,parms,parmsType);
		if (deleteCount > 0)
		{
			roleDeleted = true;
		}
		return roleDeleted;
	}

	//Create the role information in the role_lkup table
	@Override
	public boolean createParRole(ParRole parRole) {
		boolean roleCreated = false;
		
		Object[] parms = new Object[] {parRole.getRoleId(),parRole.getRoleName(),parRole.getRoleActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.BOOLEAN};
		int createCount = jdbcTemplate.update(ParSqlQueries.createRole,parms,parmsType);
		if (createCount > 0)
		{
			roleCreated = true;
		}
		return roleCreated;
	}

	@Override
	public int getNextParRoleId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextRoleId,new Object[] {},Integer.class);
	}

}

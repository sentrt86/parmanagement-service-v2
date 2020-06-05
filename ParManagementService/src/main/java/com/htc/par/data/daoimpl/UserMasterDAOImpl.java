package com.htc.par.data.daoimpl;



import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IUserMasterDAO;
import com.htc.par.data.mapper.UserMasterRowMapper;
import com.htc.par.model.UserMaster;

@Repository
public class UserMasterDAOImpl implements IUserMasterDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	//Get the user information from the user master table for given name

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> getUserMasterByUserName(String username) {
		return jdbcTemplate.query(ParSqlQueries.getUserMasterByUserNameQuery,new Object[]{username},new UserMasterRowMapper());
	}


	// Get all the  user info from the user master table

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> getAllUserMaster() {
		return jdbcTemplate.query(ParSqlQueries.getAllUserMasterQuery,new Object[]{},new UserMasterRowMapper());
	}


	//update the user master info in the user master table for a give user master id

	@Override
	public Boolean updateUserMaster(UserMaster userMaster) {

		boolean userMasterUpdated = false;
		Object[] parms = new Object[] {userMaster.getUserFirstName(),userMaster.getUserLastName(),userMaster.getUserPhoneNo(),userMaster.getUserEmailTxt(),userMaster.getUserActive(),userMaster.getUserName(),userMaster.getPassword(),userMaster.getUserRole().getUserRoleId(),userMaster.getUserId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.CHAR,Types.CHAR,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateUserMasterQuery,parms,parmsTypes);		
		if (updateCount > 0)
		{
			userMasterUpdated = true;
		}
		return userMasterUpdated;
	}


	// Delete the user master from the user master table for give user master id

	@Override
	public Boolean deleteUserMaster(int userMasterId) {
		boolean userMasterDeleted = false;
		Object[] parms = new Object[] {userMasterId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteUserMasterQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			userMasterDeleted = true;
		}
		return userMasterDeleted;
	}

	// Create an user master in the user master table

	@Override
	public Boolean createUserMaster(UserMaster userMaster) {
		boolean userMasterCreated = false;
		Object[] parms = new Object[] {userMaster.getUserId(),userMaster.getUserFirstName(),userMaster.getUserLastName(),userMaster.getUserPhoneNo(),userMaster.getUserEmailTxt(),userMaster.getUserActive(),userMaster.getUserName(),userMaster.getPassword(),userMaster.getUserRole().getUserRoleId()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.CHAR,Types.CHAR,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.createUserMasterQuery,parms,parmsType);
		if (createCount > 0)
		{
			userMasterCreated = true;
		}
		return userMasterCreated;
	}



	// Get the next user master id from the user_seq

	@Override
	public int getNextUserMasterId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextUserMasterIdQuery,new Object[] {},Integer.class);

	}

}

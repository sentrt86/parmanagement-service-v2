package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.UserRole;

public interface IUserRoleDAO {
	
	List<UserRole> getAllUserRole();
	List<UserRole> getUserRoleById(int userRoleId);
	List<UserRole> getUserRoleByName(String userRoleName);
	Boolean updateUserRole(UserRole userRole);
	Boolean deleteUserRole(int userRoleid);
	Boolean createUserRole(UserRole userRole);
	int getNextUserRoleId();

}

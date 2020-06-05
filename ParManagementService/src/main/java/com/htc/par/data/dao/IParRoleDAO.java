package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.ParRole;

public interface IParRoleDAO {
	
	List<ParRole> getAllParRoles();
	List<ParRole> getParRoleById(int value);
	List<ParRole> getActiveParRole();
	Boolean updateParRole(ParRole parRole);
	Boolean deleteParRole(int roleId);
	boolean createParRole(ParRole parRole); 
	int getNextParRoleId();

}

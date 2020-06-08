package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParRole;
import com.htc.par.to.ParRoleTO;

@Service
public interface IParRoleService {
	
	public List<ParRole> getAllParRoles() throws ResourceNotFoundException;
	public List<ParRole> getActiveParRoles() throws ResourceNotFoundException;
	public List<ParRole> getParRoleById(int value) throws ResourceNotFoundException;
	public String updateParRole(ParRoleTO parRoleTO) throws ResourceNotCreatedException, ResourceNotUpdatedException;;
	public String deleteParRole(int roleId) throws ResourceNotFoundException;
	public String createParRole(ParRoleTO parRoleTO) throws ResourceNotCreatedException; 
	public int getNextParRoleId() throws ResourceAccessException;

}

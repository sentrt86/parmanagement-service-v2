package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Skill;
import com.htc.par.to.SkillTO;

@Service
public interface ISkillService {
	
	public List<Skill>  getAllSkills() throws ResourceNotFoundException;
	public List<Skill>  getSkillById(int skillId) throws ResourceNotFoundException;
	public String deleteSkill(int skillId) throws ResourceNotFoundException;
	public String createSkill(SkillTO skillTO) throws ResourceNotCreatedException;
	public String updateSkill(SkillTO skillTO) throws ResourceNotCreatedException, ResourceNotUpdatedException;
	public int  getNextSkillId() throws ResourceAccessException;

}

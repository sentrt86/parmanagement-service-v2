package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Skill;



public interface ISkillDAO {

	List<Skill> getAllSkills();
	List<Skill> getSkillById(int value);
	List<Skill> getActiveSkill();
	Boolean updateSkill(Skill skill);
	Boolean deleteSkill(int skillId);
	boolean createSkill(Skill Skill); 
	int getNextSkillId();
}

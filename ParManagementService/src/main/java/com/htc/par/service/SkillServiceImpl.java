package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.SkillDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Skill;
import com.htc.par.to.SkillTO;

@Service
public class SkillServiceImpl implements ISkillService {


	@Autowired
	SkillDAOImpl skillDaoImpl;

	/*
	 * Request handler to GET all Skill
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */

	@Override
	public List<Skill> getAllSkills() throws ResourceNotFoundException {
		List<Skill> skillList = new ArrayList<Skill> ();		
		try {
			skillList = skillDaoImpl.getAllSkills();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return skillList;
	}

	/*
	 * Request handler to GET all active Skill
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */

	@Override
	public List<Skill> getActiveSkills() throws ResourceNotFoundException {
		List<Skill> skillList = new ArrayList<Skill> ();		
		try {
			skillList = skillDaoImpl.getActiveSkill();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return skillList;
	}

	/*
	 * GET Skills by skill id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourceAccessException
	 */

	@Override
	public List<Skill> getSkillById(int skillId) throws ResourceNotFoundException {
		List<Skill> skillList = new ArrayList<Skill> (); 
		try {
			skillList = skillDaoImpl.getSkillById(skillId);
			if(skillList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Skill Id %S",skillId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Skill Id %S",skillId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return skillList;
	}

	/*
	 * Delete the skill for a give skill id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String deleteSkill(int skillId) throws ResourceNotFoundException {
		try { 
			boolean deleteSkillSuccess = skillDaoImpl.deleteSkill(skillId); 
			if(deleteSkillSuccess) { 
				return String.format(ParConstants.deleteSuccessfull + "for Area Id: " + skillId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Area  Id : " + skillId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Area Id : %s",skillId); 
	}

	/*
	 * Create the Skill information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String createSkill(SkillTO skillTO) throws ResourceNotCreatedException {
		List<Skill> allSkillsList = new ArrayList<Skill>();

		try { 
			allSkillsList = skillDaoImpl.getAllSkills(); 
			if(!allSkillsList.isEmpty()) {
				for(Skill data : allSkillsList) 
				{ 
					if (data.getSkillName().equalsIgnoreCase(skillTO.getSkillName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Skill: %s",skillTO.getSkillName()));
					} 
				} 


			}

			if(skillDaoImpl.createSkill(new Skill(skillTO.getSkillId(),skillTO.getSkillName(),skillTO.getSkillActive())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for Skill : %s",skillTO.getSkillName()); 
			} 

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for Skill : %s ",skillTO.getSkillName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Skill : %s",skillTO.getSkillName());
	}

	/*
	 * Update the Skill information
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public String updateSkill(SkillTO skillTO) throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 	
			boolean updateSkillSuccess = skillDaoImpl.updateSkill(new Skill(skillTO.getSkillId(),skillTO.getSkillName(),skillTO.getSkillActive())); 

			if(updateSkillSuccess) { 
				return String.format(ParConstants.updateSuccessfull + "for Skill: %s",skillTO.getSkillName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Skill : %s",skillTO.getSkillName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Skill: %s",skillTO.getSkillName()); 
	}

	/*
	 * Get the next skill id from the skill_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override
	public int getNextSkillId() throws ResourceAccessException {
		try {
			return skillDaoImpl.getNextSkillId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

}

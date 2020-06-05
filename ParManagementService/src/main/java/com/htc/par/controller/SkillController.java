package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Skill;
import com.htc.par.service.SkillServiceImpl;
import com.htc.par.to.SkillTO;

@RestController
@RequestMapping("/par/skill")
public class SkillController {
	
	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	/*
	 * Request handler to get all the skill
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getSkills",method=RequestMethod.GET)
	public ResponseEntity<List<Skill>> getAllSkill() throws ResourceNotFoundException{
		return new ResponseEntity<List<Skill>>(skillServiceImpl.getAllSkills(),HttpStatus.OK);		
	}
	
	/*
	 * Request handler to get next skill id 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextSkillId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextSkillId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(skillServiceImpl.getNextSkillId(),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to get an Skill by skill id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getSkillById/{skillId}",method=RequestMethod.GET)
	public ResponseEntity<List<Skill>> getAreaById(@PathVariable("skillId") int skillId) throws ResourceNotFoundException{
		return new  ResponseEntity<List<Skill>>(skillServiceImpl.getSkillById(skillId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete an Skill by skill id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteSkill/{skillId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteSkill(@PathVariable("skillId") int skillId) throws ResourceNotFoundException{
		return new  ResponseEntity<String>(skillServiceImpl.deleteSkill(skillId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update an Skill by skill id
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateSkill",method=RequestMethod.POST)
	public ResponseEntity<String> updateSkill(@RequestBody @Valid SkillTO skillTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		return new  ResponseEntity<String>(skillServiceImpl.updateSkill(skillTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to create an Skill
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createSkill",method=RequestMethod.POST)
	public ResponseEntity<String> createSkill(@RequestBody @Valid SkillTO skillTO) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(skillServiceImpl.createSkill(skillTO),HttpStatus.OK);
	}

}

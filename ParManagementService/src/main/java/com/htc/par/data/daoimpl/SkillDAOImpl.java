package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.ISkillDAO;
import com.htc.par.data.mapper.SkillRowMapper;
import com.htc.par.model.Skill;

@Repository
public class SkillDAOImpl  implements ISkillDAO{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ParSqlQueries parSqlQueries;

		//Get all the Skill from the Skill_lkup table
	
		@SuppressWarnings("unchecked")
		@Override
		public List<Skill> getAllSkills() {
			return  jdbcTemplate.query(ParSqlQueries.getAllSkillQuery,new Object[]{}, new SkillRowMapper());		
		}


		//Get an Skill for a given Skill id from the Skill_lkup table
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Skill> getSkillById(int SkillId) {
			return	jdbcTemplate.query(ParSqlQueries.getSkillByIdQuery,new Object[]{SkillId}, new SkillRowMapper());
		}

		//update the Skill info in the Skill_lkup table for a give Skill id

		@Override
		public Boolean updateSkill(Skill Skill) {			
			boolean skillUpdated = false;
			Object[] parms = new Object[] {Skill.getSkillName(), Skill.getSkillActive(),Skill.getSkillId()};
			int[] parmsTypes = new int[] {Types.CHAR,Types.BOOLEAN,Types.INTEGER};
			int updateCount = jdbcTemplate.update(ParSqlQueries.updateSkill,parms,parmsTypes);		
			if (updateCount > 0)
			{
				skillUpdated = true;
			}
			return skillUpdated;
		}


		// Delete the Skill from the Skill_lkup table for give Skill id
		
		@Override
		public Boolean deleteSkill(int SkillId) {
			boolean skillDeleted = false;			
			Object[] parms = new Object[] {SkillId};
			int[] parmsType = new int[] {Types.INTEGER};
			int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteSkill,parms,parmsType);
			if (deleteCount > 0)
			{
				skillDeleted = true;
			}
			return skillDeleted;
		}

		// Create an Skill in the Skill_lkup table

		@Override
		public boolean createSkill(Skill Skill) {
			boolean skillCreated = false;			
			Object[] parms = new Object[] {Skill.getSkillId(),Skill.getSkillName(),Skill.getSkillActive()};
			int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.BOOLEAN};
			int createCount = jdbcTemplate.update(ParSqlQueries.createSkill,parms,parmsType);
			if (createCount > 0)
			{
				skillCreated = true;
			}
			return skillCreated;
		}

		// Get all Skill which are active in the Skill_lkup table
		@SuppressWarnings("unchecked")
		@Override
		public List<Skill> getActiveSkill() {
			return jdbcTemplate.query(ParSqlQueries.getactiveSkill,new Object[]{}, new SkillRowMapper());		
		}

		
		// Get the next Skill id from the Skill_seq
		
		@Override
		public int getNextSkillId() {
			return jdbcTemplate.queryForObject(ParSqlQueries.getNextSkillId,new Object[] {},Integer.class);
			
		}

}

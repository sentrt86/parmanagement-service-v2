package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Skill;



@SuppressWarnings("rawtypes")
public class SkillRowMapper implements RowMapper {
	
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		final Skill skill = new Skill();
		
		skill.setSkillId(rs.getInt("Skill_ID"));
		skill.setSkillName(rs.getString("Skill_NM"));
		skill.setSkillActive(rs.getBoolean("Skill_ACTIVE"));		
		return skill;
	}

}

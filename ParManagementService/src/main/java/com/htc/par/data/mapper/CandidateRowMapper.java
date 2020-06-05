package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Candidate;
import com.htc.par.model.Skill;

@SuppressWarnings("rawtypes")
public class CandidateRowMapper  implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		final Candidate candidate = new Candidate();
		final Skill skill = new Skill();
		
		
		skill.setSkillId(rs.getInt("SKILL_ID"));
		skill.setSkillName(rs.getString("SKILL_NM"));
		skill.setSkillActive(rs.getBoolean("SKILL_ACTIVE"));
		
		candidate.setCandidateId(rs.getInt("CAND_ID"));
		candidate.setCandidateName(rs.getString("CAND_NM"));
		candidate.setCandidatePhoneNum(rs.getString("CAND_PHN_NUM"));
		candidate.setCandidateEmailTxt(rs.getString("CAND_EMAIL_TXT"));
		candidate.setCandidateReceivedDate(ORMHelper.convertDateToString(rs,"CAND_RCVD_DT"));
		candidate.setCandidateActive(rs.getBoolean("CAND_ACTIVE"));
		candidate.setSkill(skill);
		
		return candidate;
	}

}

package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Recruiter;


@SuppressWarnings("rawtypes")
public class RecruiterRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		final Recruiter recruiter = new Recruiter();
		
		recruiter.setRecruiterId(rs.getInt("RECRUIT_ID"));
		recruiter.setRecruiterName(rs.getString("RECRUIT_NM"));
		recruiter.setRecruiterPhoneNo(rs.getString("RECRUIT_PHN_NUM"));
		recruiter.setRecruiterEmail(rs.getString("RECRUIT_EMAIL_TXT"));
		recruiter.setRecruiterEmailFlag(rs.getBoolean("RECRUIT_EMAIL_FLAG"));
		recruiter.setRecruiterActive(rs.getBoolean("RECRUIT_ACTIVE"));	
		return recruiter;
	}

}

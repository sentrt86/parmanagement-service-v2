package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Candidate;
import com.htc.par.model.ParAllocation;
import com.htc.par.model.Recruiter;

public class SubmitCandidateRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParAllocation parAllocation = new ParAllocation();
		final Candidate candidate = new Candidate();

		
		candidate.setCandidateId(rs.getInt("CAND_CD"));
		candidate.setCandidateName(rs.getString("CAND_NM"));

		
		parAllocation.setParAllocationId(rs.getInt("PAR_ALLOC_ID"));
		parAllocation.setParCode(rs.getInt("PAR_CD"));
		parAllocation.setSubmitIndicator(rs.getBoolean("SUBMIT_IND"));
		parAllocation.setSubmitDate(ORMHelper.convertDateToString(rs,"SUBMIT_DT"));
		parAllocation.setCandidate(candidate);

		
		return parAllocation;
	}

}

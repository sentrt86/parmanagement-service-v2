package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Candidate;
import com.htc.par.model.ParAllocation;
import com.htc.par.model.Prescreener;

public class PrescreeningRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParAllocation parAllocation = new ParAllocation();
		final Candidate candidate = new Candidate();
		final Prescreener prescreener = new Prescreener();
		
		prescreener.setPreScreenerId(rs.getInt("PRE_SCR_CD"));
		
		candidate.setCandidateId(rs.getInt("CAND_CD"));
		candidate.setCandidateName(rs.getString("CAND_NM"));
		
		parAllocation.setParAllocationId(rs.getInt("PAR_ALLOC_ID"));
		parAllocation.setPrescreenerCommentText(rs.getString("PRE_SCR_CMNT_TXT"));
		parAllocation.setPrescreenerDate(ORMHelper.convertDateToString(rs,"PRE_SCR_DT"));
		parAllocation.setParCode(rs.getInt("PAR_CD"));
		parAllocation.setCandidate(candidate);
		parAllocation.setPrescreener(prescreener);
		
		return parAllocation;
	}

}

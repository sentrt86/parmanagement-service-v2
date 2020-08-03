package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Candidate;
import com.htc.par.model.ParAllocation;
import com.htc.par.model.Prescreener;
import com.htc.par.model.Recruiter;

@SuppressWarnings("rawtypes")
public class ParAllocationRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParAllocation parAllocation = new ParAllocation();
		final Candidate candidate = new Candidate();
		final Recruiter recruiter = new Recruiter();
		final Prescreener prescreener = new Prescreener();
		
		recruiter.setRecruiterId(rs.getInt("RECRUIT_CD"));
		candidate.setCandidateId(rs.getInt("CAND_CD"));
		prescreener.setPreScreenerId(rs.getInt("PRE_SCR_CD"));
	
		parAllocation.setParAllocationId(rs.getInt("PAR_ALLOC_ID"));
		parAllocation.setParCode(rs.getInt("PAR_CD"));
		parAllocation.setCandidate(candidate);
		parAllocation.setExpectedStartDate(ORMHelper.convertDateToString(rs,"EXPTD_START_DT"));
		parAllocation.setActualStartDate(ORMHelper.convertDateToString(rs,"ACTUAL_START_DT"));
		parAllocation.setOfferReceivedIndicator(rs.getBoolean("OFFER_RECVD_IND"));
		parAllocation.setPrescreener(prescreener);
		parAllocation.setPrescreenerCommentText(rs.getString("PRE_SCR_CMNT_TXT"));
		parAllocation.setPrescreenerDate(ORMHelper.convertDateToString(rs,"PRE_SCR_DT"));
		parAllocation.setRecruiter(recruiter);
		parAllocation.setSubmitDate(ORMHelper.convertDateToString(rs,"SUBMIT_DT"));
		parAllocation.setSubmitIndicator(rs.getBoolean("SUBMIT_IND"));
		
		return parAllocation;
	}

}

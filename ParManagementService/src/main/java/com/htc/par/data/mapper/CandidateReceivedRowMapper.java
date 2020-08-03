package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.htc.par.model.Candidate;
import com.htc.par.model.ParAllocation;
import com.htc.par.model.Recruiter;

@SuppressWarnings("rawtypes")
public class CandidateReceivedRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParAllocation parAllocation = new ParAllocation();
		final Candidate candidate = new Candidate();
		final Recruiter recruiter = new Recruiter();
		
		recruiter.setRecruiterId(rs.getInt("RECRUIT_CD"));
		recruiter.setRecruiterName(rs.getString("RECRUIT_NM"));
		
		candidate.setCandidateId(rs.getInt("CAND_CD"));
		candidate.setCandidateName(rs.getString("CAND_NM"));
		candidate.setCandidateReceivedDate(ORMHelper.convertDateToString(rs,"CAND_RCVD_DT"));
		
		parAllocation.setParAllocationId(rs.getInt("PAR_ALLOC_ID"));
		parAllocation.setParCode(rs.getInt("PAR_CD"));
		parAllocation.setCandidate(candidate);
		parAllocation.setRecruiter(recruiter);
		
		return parAllocation;
	}

}

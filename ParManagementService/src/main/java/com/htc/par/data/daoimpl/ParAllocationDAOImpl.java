package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.IParAllocationDAO;
import com.htc.par.data.mapper.CandidateReceivedRowMapper;
import com.htc.par.data.mapper.CandidateRowMapper;
import com.htc.par.data.mapper.ParAllocationRowMapper;
import com.htc.par.data.mapper.PrescreenerRowMapper;
import com.htc.par.data.mapper.RecruiterRowMapper;
import com.htc.par.model.Candidate;
import com.htc.par.model.ParAllocation;
import com.htc.par.model.Prescreener;
import com.htc.par.model.Recruiter;

@Repository
public class ParAllocationDAOImpl implements IParAllocationDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean deleteParAllocationByParAllocId(int parAllocId) {
		Boolean candidateReceivedDeleted = false;
		Object[] parms = new Object[] {parAllocId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteParAllocationQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			candidateReceivedDeleted = true;
		}
		return candidateReceivedDeleted;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ParAllocation> getParAllocationByParNum(String parNum) {

		List<ParAllocation> parAllocation = new ArrayList<ParAllocation>();
		List<Prescreener>   prescreener   = new ArrayList<Prescreener>();
		List<Candidate>     candidate     = new ArrayList<Candidate>();
		List<Recruiter>     recruiter     = new ArrayList<Recruiter>();

		parAllocation = jdbcTemplate.query(ParSqlQueries.getParAllocationByParNumQuery,new Object[]{parNum}, new ParAllocationRowMapper());
		prescreener = jdbcTemplate.query(ParSqlQueries.getActivePrescreenerQuery, new Object[] {},new PrescreenerRowMapper());
		candidate   = jdbcTemplate.query(ParSqlQueries.getActiveCandidateQuery, new Object[] {},new CandidateRowMapper());
		recruiter   = jdbcTemplate.query(ParSqlQueries.getActiveRecruiterQuery, new Object[] {},new RecruiterRowMapper());

		for (ParAllocation data : parAllocation) {
			int prescreenerId = data.getPrescreener().getPreScreenerId();
			int candidateId = data.getCandidate().getCandidateId();
			int recruiterId = data.getRecruiter().getRecruiterId();

			if (prescreenerId > 0) {
				for (Prescreener prescreenerData : prescreener) {
					if (prescreenerId == prescreenerData.getPreScreenerId()) {
						data.setPrescreener(prescreenerData);
					}
				}

			}

			if(candidateId > 0) {
				for (Candidate candidateData : candidate) {
					if (candidateId == candidateData.getCandidateId()) {
						data.setCandidate(candidateData);
					}
				}
			}

			if(recruiterId > 0) {
				for (Recruiter recruiterData : recruiter) {
					if (recruiterId == recruiterData.getRecruiterId()) {
						data.setRecruiter(recruiterData);
					}
				}
			}


		}

		return parAllocation;

	}


	@Override
	public Boolean updatePrescreening(ParAllocation parAllocation) {
		Boolean prescreeningUpdated = false;
		Object[] parms = new Object[] {parAllocation.getPrescreener().getPreScreenerId(),LocalDate.parse(parAllocation.getPrescreenerDate()),parAllocation.getPrescreenerCommentText(),parAllocation.getParAllocationId(),parAllocation.getParCode()};
		int[] parmsType = new int[] {Types.INTEGER,Types.DATE,Types.CHAR,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updatePrescreeningQuery,parms,parmsType);
		if(updateCount > 0) {
			prescreeningUpdated = true;
		}		
		return prescreeningUpdated;
	}


	@Override
	public Boolean updateSubmitCandidate(ParAllocation parAllocation) {
		Boolean submitCandidateUpdated = false;
		Object[] parms = new Object[] {parAllocation.getSubmitIndicator(),LocalDate.parse(parAllocation.getSubmitDate()),parAllocation.getParAllocationId(),parAllocation.getParCode()};
		int[] parmsType = new int[] {Types.BOOLEAN,Types.DATE,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateSubmitCandidateQuery,parms,parmsType);
		if(updateCount > 0) {
			submitCandidateUpdated = true;
		}		
		return submitCandidateUpdated;
	}
	
	@Override
	public Boolean createParAllocation(ParAllocation parAllocation) {
		Boolean parAllocationCreated = false;
		Object[] parms = new Object[] {parAllocation.getParCode(),parAllocation.getRecruiter().getRecruiterId(),parAllocation.getCandidate().getCandidateId()};
		int[] parmsType = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.createParAllocationQuery,parms,parmsType);
		if(createCount > 0) {
			parAllocationCreated = true;
		}		
		return parAllocationCreated;
	}

	@Override
	public Boolean updateCandidateReceived(int parAllocationId, int candidateId, int recruiterId) {
		Boolean candidateReceivedUpdated = false;
		Object[] parms = new Object[] {candidateId,recruiterId,parAllocationId};
		int[] parmsType = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.updateCandidateReceivedQuery,parms,parmsType);
		if(createCount > 0) {
			candidateReceivedUpdated = true;
		}		
		return candidateReceivedUpdated;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParAllocation> getCandidateReceivedByParNum(String parNum) {

		return jdbcTemplate.query(ParSqlQueries.getCandidateReceivedByParNumQuery,new Object[]{parNum}, new CandidateReceivedRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParAllocation> getCandidateReceivedByParCode(int parCode) {

		return jdbcTemplate.query(ParSqlQueries.getCandidateReceivedByParCdQuery,new Object[]{parCode}, new CandidateReceivedRowMapper());
	}

}

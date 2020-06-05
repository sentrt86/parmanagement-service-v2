package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.ICandidateDAO;
import com.htc.par.data.mapper.CandidateRowMapper;
import com.htc.par.model.Candidate;

@Repository
public class CandidateDAOImpl implements ICandidateDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	//Get all the Candidate from the candidate table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAllCandidates() {
		return jdbcTemplate.query(ParSqlQueries.getAllCandidateQuery,new Object[]{}, new CandidateRowMapper());		
	}


	//Get an Candidate for a given candidate id from the candidate table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getCandidateById(int candidateId) {
		return jdbcTemplate.query(ParSqlQueries.getCandidateByIdQuery,new Object[]{candidateId}, new CandidateRowMapper());
	}

	//update the Candidate info in the candidate table for a give candidate id

	@Override
	public Boolean updateCandidate(Candidate candidate) {		
		boolean candidateUpdated = false;
		Object[] parms = new Object[] {candidate.getCandidateName(),candidate.getCandidatePhoneNum(),candidate.getCandidateEmailTxt(),LocalDate.parse(candidate.getCandidateReceivedDate()),candidate.getCandidateActive(),candidate.getSkill().getSkillId(),candidate.getCandidateId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateCandidateQuery,parms,parmsTypes);		
		if (updateCount > 0)
		{
			candidateUpdated = true;
		}
		return candidateUpdated;
	}


	// Delete the Candidate from the candidate table for give candidate id
	
	@Override
	public Boolean deleteCandidate(int candidateId) {
		boolean candidateDeleted = false;		
		Object[] parms = new Object[] {candidateId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteCandidateQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			candidateDeleted = true;
		}
		return candidateDeleted;
	}

	// Create an Candidate in the candidate table

	@Override
	public boolean createCandidate(Candidate candidate) {
		boolean candidateCreated = false;
		
		System.out.println("service:" +candidate.toString());
		Object[] parms = new Object[] {candidate.getCandidateId(),candidate.getCandidateName(),candidate.getCandidatePhoneNum(),candidate.getCandidateEmailTxt(),LocalDate.parse(candidate.getCandidateReceivedDate()),candidate.getCandidateActive(),candidate.getSkill().getSkillId()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.CHAR,Types.CHAR,Types.DATE,Types.BOOLEAN,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.createCandidateQuery,parms,parmsType);
		if (createCount > 0)
		{
			candidateCreated = true;
		}
		return candidateCreated;
	}

	// Get all Candidate which are active in the candidate table
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getActiveCandidate() {
		return jdbcTemplate.query(ParSqlQueries.getActiveCandidateQuery,new Object[]{}, new CandidateRowMapper());		
	}

	
	// Get the next candidate id from the cand_seq
	
	@Override
	public int getNextCandidateId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextCandidateIdQuery,new Object[] {},Integer.class);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getCandidateByName(String candidateName) {
		return jdbcTemplate.query(ParSqlQueries.getCandidateByNameQuery,new Object[]{candidateName}, new CandidateRowMapper());
	}

}

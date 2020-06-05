package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IRecruiterDAO;
import com.htc.par.data.mapper.RecruiterRowMapper;
import com.htc.par.model.Recruiter;

@Repository
public class RecruiterDAOImpl implements IRecruiterDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Get all the recruiter from the recruiter table
	@SuppressWarnings("unchecked")
	@Override
	public List<Recruiter> getAllRecruiter() {
		return jdbcTemplate.query(ParSqlQueries.getAllRecruiterQuery,new Object[]{}, new RecruiterRowMapper());	
	}
	
	// Get all the recruiter from the recruiter table for a give recruiter id

	@SuppressWarnings("unchecked")
	@Override
	public List<Recruiter> getRecruiterById(int recruiterId) {
		return jdbcTemplate.query(ParSqlQueries.getRecruiterByIdQuery,new Object[]{recruiterId}, new RecruiterRowMapper());
	}

	// Get all the active recruiter from the recruiter table
	@SuppressWarnings("unchecked")
	@Override
	public List<Recruiter> getActiveRecruiter() {
		return jdbcTemplate.query(ParSqlQueries.getactiveRecruiter,new Object[]{}, new RecruiterRowMapper());		
	}

	// Get recruiter from the recruiter table for a given recruiter name
	@SuppressWarnings("unchecked")
	@Override
	public List<Recruiter> getRecruiterByName(String recruiterName) {
		return jdbcTemplate.query(ParSqlQueries.getRecruiterByName,new Object[]{recruiterName}, new RecruiterRowMapper());
	}

	//Update the recruiter
	@Override
	public Boolean updateRecruiter(Recruiter recruiter) {
		boolean recruiterUpdated = false;
		
		Object[] parms = new Object[] {recruiter.getRecruiterName(), recruiter.getRecruiterPhoneNo(),recruiter.getRecruiterEmail(),recruiter.getRecruiterEmailFlag(),recruiter.getRecruiterActive(),recruiter.getRecruiterId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.BOOLEAN,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateRecruiter,parms,parmsTypes);		
		if (updateCount > 0)
		{
			recruiterUpdated = true;
		}
		return recruiterUpdated;
	}

	// Delete the recruiter by recruiter id
	@Override
	public Boolean deleteRecruiter(int recruiterId) {
		boolean recruiterDeleted = false;		
		Object[] parms = new Object[] {recruiterId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteRecruiter,parms,parmsType);
		if (deleteCount > 0)
		{
			recruiterDeleted = true;
		}
		return recruiterDeleted;
	}
	// Create the Recruiter
	@Override
	public boolean createRecruiter(Recruiter recruiter) {
		boolean recruiterCreated = false;		
		Object[] parms = new Object[] {recruiter.getRecruiterId(),recruiter.getRecruiterName(),recruiter.getRecruiterPhoneNo(),recruiter.getRecruiterEmail(),recruiter.getRecruiterEmailFlag(),recruiter.getRecruiterActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.BOOLEAN};
		int createCount = jdbcTemplate.update(ParSqlQueries.createRecruiter,parms,parmsType);
		if (createCount > 0)
		{
			recruiterCreated = true;
		}
		return recruiterCreated;
	}
	//Get the next recruiter id
	@Override
	public int getNextRecruiterId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextRecruiterId,new Object[] {},Integer.class);
	}

}

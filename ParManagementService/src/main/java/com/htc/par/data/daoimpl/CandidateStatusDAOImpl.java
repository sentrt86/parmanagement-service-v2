package com.htc.par.data.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.mapper.ParMasterRowMapper;
import com.htc.par.model.ParMaster;

@Repository
public class CandidateStatusDAOImpl {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ParMaster> getParMasterbyCandidateId(int candidateId) {
		System.out.println("Senthil Skips starte -DAO class");
		List<ParMaster> parmasters =  new ArrayList<ParMaster>();
		parmasters = (List<ParMaster>) jdbcTemplate.query(ParSqlQueries.getParMasterbyCandidateId, new Object[] {candidateId}, new ParMasterRowMapper());
		System.out.println(parmasters);
		return parmasters;
	}

}

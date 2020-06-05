package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IPrescreenerDAO;
import com.htc.par.data.mapper.PrescreenerRowMapper;
import com.htc.par.model.Prescreener;


@Repository
public class PrescreenerDAOImpl implements IPrescreenerDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	//Get all Prescreeners

	@SuppressWarnings("unchecked")
	@Override
	public List<Prescreener> getAllPrescreeners() {
		return jdbcTemplate.query(ParSqlQueries.getAllPrescreenerQuery, new Object[] {}, new PrescreenerRowMapper());
	}

	@Override
	public boolean createPrescreener(Prescreener prescreener) {
		System.out.println(prescreener.toString());
		boolean prescreenerAdded = false;
		Object[] parms = new Object[] {prescreener.getPreScreenerId(),prescreener.getPreScreenerName(),prescreener.getPreScreenerEmailId(),prescreener.getPreScreenercontactNo(),prescreener.getPreScreenerActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN};
		int AddCount = jdbcTemplate.update(ParSqlQueries.addPrescreenerQuery,parms,parmsType);
		if (AddCount > 0)
		{
			prescreenerAdded = true;
		}
		return prescreenerAdded;
	}

	@Override
	public boolean updatePrescreener(Prescreener prescreener) {
		boolean prescreenerUpdated = false;
		Object[] parms = new Object[] {prescreener.getPreScreenerName(),prescreener.getPreScreenerEmailId(),prescreener.getPreScreenercontactNo(),prescreener.getPreScreenerActive(),prescreener.getPreScreenerId()};
		int[] parmsType = new int[] {Types.CHAR,Types.CHAR,Types.CHAR,Types.BOOLEAN,Types.INTEGER};
		int AddCount = jdbcTemplate.update(ParSqlQueries.updatePrescreenerQuery,parms,parmsType);
		if (AddCount > 0)
		{
			prescreenerUpdated = true;
		}
		return prescreenerUpdated;
	}

	@Override
	public boolean deletePrescreener(int prescreenerId) {
		boolean prescreenerDeleted = false;
		Object[] parms = new Object[] {prescreenerId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deletePrescreenerQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			prescreenerDeleted = true;
		}
		return prescreenerDeleted;
	}

	@Override
	public int getnextPrescreenerId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextPrescreenerId,new Object[] {},Integer.class);
	}
}
package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.htc.par.data.dao.IParMasterDAO;
import com.htc.par.data.mapper.ParMasterRowMapper;
import com.htc.par.model.ParMaster;

@Repository
public class ParMasterDAOImpl implements IParMasterDAO{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// create the par information in the par master table
	
	@Override
	public Boolean createParMaster(ParMaster parmaster) {
		Boolean parMasterCreated = false;
		Object[] parms = new Object[] {parmaster.getParId(),parmaster.getParNumber(),parmaster.getParDescriptionText(),LocalDate.parse(parmaster.getParReceivedDate()),parmaster.getParStatus()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.CHAR,Types.DATE,Types.CHAR};
		int createParmasterCount = jdbcTemplate.update(ParSqlQueries.createParMasterQuery,parms,parmsType);
		if (createParmasterCount > 0)
		{
			if (this.createParMasterRltn(parmaster))
			{
				parMasterCreated = true;
			}
		}
		return parMasterCreated;
	}

	// create the par information relation in the par master relation table
	
	@Override
	public Boolean createParMasterRltn(ParMaster parmaster) {
		Boolean parMasterRltnCreated = false;
		Object[] parms = new Object[] {parmaster.getParId(),parmaster.getParRole().getRoleId(),parmaster.getSkill().getSkillId(),parmaster.getArea().getAreaId(),parmaster.getExternalStaff().getExtStaffId(),parmaster.getLocation().getLocationId()};
		int[] parmsType = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.createParRltnQuery,parms,parmsType);
		if(createCount > 0) {
			parMasterRltnCreated = true;
		}		
		return parMasterRltnCreated;
	}

	// Get the next par sequence from the par_seq
	
	@Override
	public int getNextParSeqId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextParSeqQuery,new Object[] {},Integer.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ParMaster> getParMasterByParNum(String parNum) {	
		return jdbcTemplate.query(ParSqlQueries.getParMasterByParNumQuery,new Object[]{parNum}, new ParMasterRowMapper());
	}

	// Update the intent to fill and intent sent date in the par master
	@Override
	public Boolean updateIntentToFill(int parId, Boolean intentToFill, String intentSentDate) {
		Boolean parMasterUpdated = false;
		Object[] parms = new Object[] {intentToFill,LocalDate.parse(intentSentDate),parId};
		int[] parmsType = new int[] {Types.BOOLEAN,Types.DATE,Types.INTEGER};
		int createCount = jdbcTemplate.update(ParSqlQueries.UpdateIntentToFillQuery,parms,parmsType);
		if(createCount > 0) {
			parMasterUpdated = true;
		}		
		return parMasterUpdated;
	}

}

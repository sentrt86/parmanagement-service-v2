package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.time.LocalDate;
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

	// update the par information in the par master table

	@Override
	public Boolean updateParMaster(ParMaster parmaster) {
		Boolean parMasterUpdated = false;
		Object[] parms = new Object[] {parmaster.getParDescriptionText(),LocalDate.parse(parmaster.getParReceivedDate()),parmaster.getParStatus(),parmaster.getParNumber()};
		int[] parmsType = new int[] {Types.CHAR,Types.DATE,Types.CHAR,Types.CHAR};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateParMasterQuery,parms,parmsType);
		if (updateCount > 0)
		{
			if (this.updateParMasterRltn(parmaster))
			{
				parMasterUpdated = true;
			}
		}
		return parMasterUpdated;
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


	// update the par information relation in the par master relation table

	@Override
	public Boolean updateParMasterRltn(ParMaster parmaster) {
		Boolean parMasterRltnUpdated = false;
		Object[] parms = new Object[] {parmaster.getParRole().getRoleId(),parmaster.getSkill().getSkillId(),parmaster.getArea().getAreaId(),parmaster.getExternalStaff().getExtStaffId(),parmaster.getLocation().getLocationId(),parmaster.getParId()};
		int[] parmsType = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateParRltnQuery,parms,parmsType);
		if(updateCount > 0) {
			parMasterRltnUpdated = true;
		}		
		return parMasterRltnUpdated;
	}

	// Get the next par sequence from the par_seq

	@Override
	public int getNextParSeqId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextParSeqQuery,new Object[] {},Integer.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public ParMaster getParMasterByParNum(String parNum) {	
		return (ParMaster) jdbcTemplate.queryForObject(ParSqlQueries.getParMasterByParNumQuery,new Object[]{parNum}, new ParMasterRowMapper());
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

	@Override
	public Boolean deleteParMaster(int parNo) {
		boolean parMasterDeleted = false;
		Object[] parms = new Object[] {parNo};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteParMasterQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			if(this.deleteParMasterRltn(parNo))
			{
				parMasterDeleted = true;
			}
			
		}
		return parMasterDeleted;
	}

	@Override
	public Boolean deleteParMasterRltn(int parNo) {
		boolean parMasterRltnDeleted = false;
		Object[] parms = new Object[] {parNo};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteParRltnQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			parMasterRltnDeleted = true;
		}
		return parMasterRltnDeleted;
	}

	@Override
	public Boolean updateEmailSent(ParMaster parmaster) {
		Boolean parMasterUpdated = false;
		Object[] parms = new Object[] {parmaster.getEmailSent(),parmaster.getParComment(),parmaster.getParNumber()};
		int[] parmsType = new int[] {Types.BOOLEAN,Types.CHAR,Types.CHAR};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateEmailSentQuery,parms,parmsType);
		if(updateCount > 0) {
			parMasterUpdated = true;
		}		
		return parMasterUpdated;
	}









}

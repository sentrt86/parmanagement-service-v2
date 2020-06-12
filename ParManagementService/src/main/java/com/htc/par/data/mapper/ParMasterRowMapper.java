package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Area;
import com.htc.par.model.ExternalStaff;
import com.htc.par.model.Location;
import com.htc.par.model.ParMaster;
import com.htc.par.model.ParRole;
import com.htc.par.model.Skill;

@SuppressWarnings("rawtypes")
public class ParMasterRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParMaster parmaster = new ParMaster();
		final Area area = new Area();
		final Skill skill = new Skill();
		final ParRole role  = new ParRole();
		final Location location = new Location();
		final ExternalStaff externalStaff = new ExternalStaff();
		
		
		area.setAreaId(rs.getInt("AREA_ID"));
		area.setAreaName(rs.getString("AREA_NM"));
		area.setAreaActive(rs.getBoolean("AREA_ACTIVE"));
		
		skill.setSkillId(rs.getInt("SKILL_ID"));
		skill.setSkillName(rs.getString("SKILL_NM"));
		skill.setSkillActive(rs.getBoolean("SKILL_ACTIVE"));		
		
		role.setRoleId(rs.getInt("ROLE_ID"));
		role.setRoleName(rs.getString("ROLE_NM"));
		role.setRoleActive(rs.getBoolean("ROLE_ACTIVE"));
		
		location.setLocationId(rs.getInt("LOC_ID"));
		location.setLocationName(rs.getString("LOC_NM"));
		location.setLocationActive(rs.getBoolean("LOC_ACTIVE"));
		
		externalStaff.setExtStaffId(rs.getInt("EXT_STAFF_ID"));
		externalStaff.setExtStaffName(rs.getString("EXT_STAFF_NM"));		
		externalStaff.setExtStaffActive(rs.getBoolean("EXT_STAFF_ACTIVE"));
		
		parmaster.setArea(area);
		parmaster.setSkill(skill);
		parmaster.setParRole(role);
		parmaster.setExternalStaff(externalStaff);
		parmaster.setLocation(location);
		
		parmaster.setParId(rs.getInt("PAR_ID"));
		parmaster.setParNumber(rs.getString("PAR_NUM"));
		parmaster.setParDescriptionText(rs.getString("PAR_DESC_TXT"));
		parmaster.setParReceivedDate(ORMHelper.convertDateToString(rs,"PAR_RCVD_DT"));
		parmaster.setIntentToFill(rs.getBoolean("INTNT_TO_FIL_IND"));
		parmaster.setIntentSentDate(ORMHelper.convertDateToString(rs,"INTNT_SENT_DT"));
		parmaster.setEmailSent(rs.getBoolean("EMAIL_SENT"));
		parmaster.setParComment(rs.getString("PAR_CMMNT"));
		parmaster.setParStatus(rs.getString("PAR_STTS"));
		
		return parmaster;
	}

}

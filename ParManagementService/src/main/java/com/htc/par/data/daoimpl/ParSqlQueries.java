package com.htc.par.data.daoimpl;

import org.springframework.stereotype.Component;

@Component
public class ParSqlQueries {
	
	
	//  Area Queries
	public static String getAllAreasQuery = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP";
	public static String getAreaByIdQuery = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP WHERE AREA_ID = ?";
	public static String deleteArea       = "DELETE FROM AREA_LKUP WHERE AREA_ID = ?";
	public static String updateArea       = "UPDATE AREA_LKUP SET AREA_NM = ? , AREA_ACTIVE = ? WHERE AREA_ID = ?";
	public static String createArea       = "INSERT INTO AREA_LKUP (AREA_ID,AREA_NM,AREA_ACTIVE) VALUES(?,?,?)";
    public static String getactiveArea    = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP WHERE AREA_ACTIVE = true";
    public static String getNextAreaId    = "SELECT NEXTVAL('AREA_SEQ')";
    
	//  Skill Queries
	public static String getAllSkillQuery  = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP";
	public static String getSkillByIdQuery = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP WHERE SKILL_ID = ?";
	public static String deleteSkill       = "DELETE FROM SKILL_LKUP WHERE SKILL_ID = ?";
	public static String updateSkill       = "UPDATE SKILL_LKUP SET SKILL_NM = ? , SKILL_ACTIVE = ? WHERE SKILL_ID = ?";
	public static String createSkill       = "INSERT INTO SKILL_LKUP (SKILL_ID,SKILL_NM,SKILL_ACTIVE) VALUES(?,?,?)";
    public static String getactiveSkill    = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP WHERE SKILL_ACTIVE = true";
    public static String getNextSkillId    = "SELECT NEXTVAL('SKILL_SEQ')";
}

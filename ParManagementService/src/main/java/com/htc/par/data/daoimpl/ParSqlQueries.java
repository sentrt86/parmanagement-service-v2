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
    
//  Role Queries
	public static String getAllRoleQuery  = "SELECT ROLE_ID,ROLE_NM,ROLE_ACTIVE FROM ROLE_LKUP";
	public static String getRoleByIdQuery = "SELECT ROLE_ID,ROLE_NM,ROLE_ACTIVE FROM ROLE_LKUP WHERE ROLE_ID = ?";
	public static String deleteRole       = "DELETE FROM ROLE_LKUP WHERE ROLE_ID = ?";
	public static String updateRole       = "UPDATE ROLE_LKUP SET ROLE_NM = ? , ROLE_ACTIVE = ? WHERE ROLE_ID = ?";
	public static String createRole       = "INSERT INTO ROLE_LKUP (ROLE_ID,ROLE_NM,ROLE_ACTIVE) VALUES(?,?,?)";
    public static String getactiveRole    = "SELECT ROLE_ID,ROLE_NM,ROLE_ACTIVE FROM ROLE_LKUP WHERE ROLE_ACTIVE = true";
    public static String getNextRoleId    = "SELECT NEXTVAL('ROLE_SEQ')";
    
//  External Staff Queries
	public static String getAllExtStaffQuery               =   " SELECT E.EXT_STAFF_ID,E.EXT_STAFF_NM,E.EXT_STAFF_ACTIVE,A.AREA_ID,A.AREA_NM,A.AREA_ACTIVE FROM EXT_STAFF_LKUP E, AREA_LKUP A WHERE A.AREA_ID = E.AREA_CD";	
	public static String getExtStaffByIdQuery              =   " SELECT E.EXT_STAFF_ID,E.EXT_STAFF_NM,E.EXT_STAFF_ACTIVE, A.AREA_ID,A.AREA_NM,A.AREA_ACTIVE FROM EXT_STAFF_LKUP E, AREA_LKUP A WHERE A.AREA_ID = E.AREA_CD AND EXT_STAFF_ID = ?";	
	public static String deleteExtStaff                    =   " DELETE FROM EXT_STAFF_LKUP WHERE EXT_STAFF_ID = ?";
	public static String updateExtStaff                    =   " UPDATE EXT_STAFF_LKUP SET EXT_STAFF_NM = ? ,AREA_CD = ?, EXT_STAFF_ACTIVE = ? WHERE EXT_STAFF_ID = ?";
	public static String createExtStaff                    =   " INSERT INTO EXT_STAFF_LKUP (EXT_STAFF_ID,EXT_STAFF_NM,AREA_CD,EXT_STAFF_ACTIVE) VALUES(?,?,?,?)";
    public static String getactiveExtStaff                 =   " SELECT E.EXT_STAFF_ID,E.EXT_STAFF_NM,E.EXT_STAFF_ACTIVE, A.AREA_ID,A.AREA_NM,A.AREA_ACTIVE FROM EXT_STAFF_LKUP E, AREA_LKUP A WHERE A.AREA_ID = E.AREA_CD AND EXT_STAFF_ACTIVE = true";
    public static String getNextExtStaffId                 =   " SELECT NEXTVAL('EXT_STAFF_SEQ')";    
    public static String getExtStaffByName                 =   " SELECT E.EXT_STAFF_ID,E.EXT_STAFF_NM,E.EXT_STAFF_ACTIVE,A.AREA_ID,A.AREA_NM,A.AREA_ACTIVE FROM EXT_STAFF_LKUP E, AREA A WHERE A.AREA_ID = E.AREA_ID AND EXT_STAFF_NM = ?";

    		                                    
    
//  Recruiter Queries
	public static String getAllRecruiterQuery              = "SELECT RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE FROM RECRUITER";
	public static String getRecruiterByIdQuery             = "SELECT RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE FROM RECRUITER WHERE RECRUIT_ID = ?";
	public static String deleteRecruiter                   = "DELETE FROM RECRUITER WHERE RECRUIT_ID = ?";
	public static String updateRecruiter                   = "UPDATE RECRUITER SET RECRUIT_NM = ? ,RECRUIT_PHN_NUM = ?, RECRUIT_EMAIL_TXT = ?,RECRUIT_EMAIL_FLAG = ?,RECRUIT_ACTIVE = ? WHERE RECRUIT_ID = ?";
	public static String createRecruiter                   = "INSERT INTO RECRUITER (RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE) VALUES(?,?,?,?,?,?)";
    public static String getactiveRecruiter                = "SELECT RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE FROM RECRUITER WHERE RECRUIT_ACTIVE = true";
    public static String getNextRecruiterId                = "SELECT NEXTVAL('RECRUIT_SEQ')";
    public static String getRecruiterByName                = "SELECT RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE FROM RECRUITER WHERE RECRUIT_NM = ?";
    
//  User Role Queries
	public static String getAllUserRoleQuery               = "SELECT USER_ROLE_ID,USER_ROLE_NM FROM USER_ROLE";
	public static String getUserRoleByIdQuery              = "SELECT USER_ROLE_ID,USER_ROLE_NM FROM USER_ROLE WHERE USER_ROLE_ID = ?";
	public static String deleteUserRoleQuery               = "DELETE FROM USER_ROLE WHERE USER_ROLE_ID = ?";
	public static String updateUserRoleQuery               = "UPDATE USER_ROLE SET USER_ROLE_NM = ?  WHERE USER_ROLE_ID = ?";
	public static String createUserRoleQuery               = "INSERT INTO USER_ROLE (USER_ROLE_ID,USER_ROLE_NM) VALUES(?,?)";
    public static String getNextUserRoleIdQuery            = "SELECT NEXTVAL('USER_ROLE_SEQ')";
    public static String getUserRoleByNameQuery            = "SELECT USER_ROLE_ID,USER_ROLE_NM FROM USER_ROLE WHERE USER_ROLE_NM = ?";
    
    
    
//  Candidate Queries
	public static String getAllCandidateQuery               =   " SELECT C.CAND_ID,C.CAND_NM,C.CAND_PHN_NUM,C.CAND_EMAIL_TXT,C.CAND_RCVD_DT,C.CAND_ACTIVE,S.SKILL_ID,S.SKILL_NM,S.SKILL_ACTIVE FROM CANDIDATE C, SKILL_LKUP S WHERE S.SKILL_ID = C.SKILL_CD";
	public static String getCandidateByIdQuery              =   " SELECT C.CAND_ID,C.CAND_NM,C.CAND_PHN_NUM,C.CAND_EMAIL_TXT,C.CAND_RCVD_DT,C.CAND_ACTIVE,S.SKILL_ID,S.SKILL_NM,S.SKILL_ACTIVE FROM CANDIDATE C, SKILL_LKUP S WHERE S.SKILL_ID = C.SKILL_CD AND CAND_ID = ?";
	public static String deleteCandidateQuery               =   " DELETE FROM CANDIDATE WHERE CAND_ID = ?";
	public static String updateCandidateQuery               =   " UPDATE CANDIDATE SET CAND_NM = ? ,CAND_PHN_NUM = ?, CAND_EMAIL_TXT = ?,CAND_RCVD_DT = ?, CAND_ACTIVE = ? , SKILL_CD =  ? WHERE CAND_ID = ?";
	public static String createCandidateQuery               =   " INSERT INTO CANDIDATE (CAND_ID,CAND_NM,CAND_PHN_NUM,CAND_EMAIL_TXT,CAND_RCVD_DT,CAND_ACTIVE,SKILL_CD) VALUES(?,?,?,?,?,?,?)";
    public static String getNextCandidateIdQuery            =   " SELECT NEXTVAL('CAND_SEQ')";
    public static String getCandidateByNameQuery            =   " SELECT C.CAND_ID,C.CAND_NM,C.CAND_PHN_NUM,C.CAND_EMAIL_TXT,C.CAND_RCVD_DT,C.CAND_ACTIVE,S.SKILL_ID,S.SKILL_NM,S.SKILL_ACTIVE FROM CANDIDATE C, SKILL_LKUP S WHERE S.SKILL_ID = C.SKILL_CD AND CAND_NM = ?";
    public static String getActiveCandidateQuery            =   " SELECT C.CAND_ID,C.CAND_NM,C.CAND_PHN_NUM,C.CAND_EMAIL_TXT,C.CAND_RCVD_DT,C.CAND_ACTIVE,S.SKILL_ID,S.SKILL_NM,S.SKILL_ACTIVE FROM CANDIDATE C, SKILL_LKUP S WHERE S.SKILL_ID = C.SKILL_CD AND CAND_ACTIVE = true";
    
//  User Master Queries
	public static String getUserMasterByUserNameQuery       =   " SELECT UM.USER_ID,UM.USER_FIRST_NM,UM.USER_LAST_NM,UM.USER_PHN_NUM,UM.USER_EMAIL_TXT,UM.USER_ACTIVE,UM.USER_USR_NM,UM.USER_PWD,UR.USER_ROLE_ID,UR.USER_ROLE_NM FROM USER_MSTR UM, USER_ROLE UR WHERE UR.USER_ROLE_ID = UM.USER_ROLE_CD AND UM.USER_USR_NM = ? ";	
	public static String getAllUserMasterQuery      	    =   " SELECT UM.USER_ID,UM.USER_FIRST_NM,UM.USER_LAST_NM,UM.USER_PHN_NUM,UM.USER_EMAIL_TXT, UM.USER_ACTIVE,UM.USER_USR_NM,UM.USER_PWD,UR.USER_ROLE_ID,UR.USER_ROLE_NM  FROM USER_MSTR UM, USER_ROLE UR WHERE UR.USER_ROLE_ID = UM.USER_ROLE_CD";
	public static String deleteUserMasterQuery              =   " DELETE FROM USER_MSTR WHERE USER_ID = ?";
	public static String createUserMasterQuery              =   " INSERT INTO USER_MSTR (USER_ID,USER_FIRST_NM,USER_LAST_NM,USER_PHN_NUM,USER_EMAIL_TXT,USER_ACTIVE,USER_USR_NM,USER_PWD,USER_ROLE_CD) VALUES(?,?,?,?,?,?,?,?,?)";
	public static String updateUserMasterQuery              =   " UPDATE USER_MSTR SET USER_FIRST_NM = ? ,USER_LAST_NM = ?, USER_PHN_NUM = ?, USER_EMAIL_TXT= ?,USER_ACTIVE = ?, USER_USR_NM = ?, USER_PWD = ? , USER_ROLE_CD = ? WHERE USER_ID = ?";
	public static String getNextUserMasterIdQuery           =   " SELECT NEXTVAL('USER_SEQ')";
	

// Par Master Queries
	
	public static String insertParMasterQuery               =   " INSERT INTO PAR_MSTR (PAR_ID,PAR_NUM,PAR_DESC_TXT,PAR_RCVD_DT,PAR_STTS,INTNT_TO_FIL,EMAIL_SENT,PAR_CMNT) VALUES (?,?,?,?,?,?,?,?)";

// Par Relation Queries
	
	public static String insertParRltnQuery                 =   " INSERT INTO PAR_RLTN (PAR_CD,ROLE_CD,SKILL_CD,AREA_CD,EXT_STAFF_CD) VALUES(?,?,?,?,?)";

// Par Allocation Queries
	
	public static String insertParAllocationQuery           =   " INSERT INTO PAR_ALLOCATION(PAR_ALLOC_ID,PAR_CD,RECRUIT_CD,PRE_SCR_CD,CAND_CD,PRE_SCR_DT,PRE_SCR_CMNT_TXT,SUBMIT_IND,SUBMIT_DT,OFFER_RECVD_IND,EXPT_START_DT,ACTUAL_START_DT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)_";

}

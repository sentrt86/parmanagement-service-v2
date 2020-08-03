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
    public static String getActiveRecruiterQuery           = "SELECT RECRUIT_ID,RECRUIT_NM,RECRUIT_PHN_NUM,RECRUIT_EMAIL_TXT,RECRUIT_EMAIL_FLAG,RECRUIT_ACTIVE FROM RECRUITER WHERE RECRUIT_ACTIVE = true";
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
	
	// Prescreener Queries
    public static String getAllPrescreenerQuery             =   " SELECT PRE_SCR_ID,PRE_SCR_NM,PRE_SCR_EMAIL_TXT,PRE_SCR_PHN_NUM,PRE_SCR_ACTIVE FROM PRE_SCREENER";
    public static String createPrescreenerQuery             =   " INSERT INTO PRE_SCREENER (PRE_SCR_ID,PRE_SCR_NM,PRE_SCR_EMAIL_TXT,PRE_SCR_PHN_NUM,PRE_SCR_ACTIVE) VALUES(?,?,?,?,?)";
    public static String updatePrescreenerQuery             =   " UPDATE PRE_SCREENER SET PRE_SCR_NM=?, PRE_SCR_EMAIL_TXT=?,PRE_SCR_PHN_NUM=?,PRE_SCR_ACTIVE=? WHERE PRE_SCR_ID=?";
    public static String deletePrescreenerQuery             =   " DELETE FROM PRE_SCREENER WHERE PRE_SCR_ID = ?";
    public static String getActivePrescreenerQuery          =   " SELECT PRE_SCR_ID,PRE_SCR_NM,PRE_SCR_EMAIL_TXT,PRE_SCR_PHN_NUM,PRE_SCR_ACTIVE FROM  PRE_SCREENER WHERE PRE_SCR_ACTIVE = true";
    public static String getNextPrescreenerId               =   " SELECT NEXTVAL('PRE_SCR_SEQ')";
    
    
 // Location Queries
    public static String getAllLocationsQuery               =   " SELECT LOC_ID,LOC_NM,LOC_ACTIVE FROM LOCATION";
    public static String createLocationQuery                =   " INSERT INTO LOCATION(LOC_ID,LOC_NM,LOC_ACTIVE) VALUES(?,?,?)";
    public static String updateLocationQuery                =   " UPDATE LOCATION SET LOC_NM =?, LOC_ACTIVE=? WHERE LOC_ID=?";
    public static String deleteLocationQuery                =   " DELETE FROM LOCATION WHERE LOC_ID = ?";
    public static String getActiveLocationQuery             =   " SELECT LOC_ID,LOC_NM,LOC_ACTIVE FROM LOCATION WHERE LOC_ACTIVE = true";
    public static String getNextLocationId                  =   " SELECT NEXTVAL('LOC_SEQ')";

// Par Master Queries
	
	public static String createParMasterQuery               =   " INSERT INTO PAR_MSTR (PAR_ID,PAR_NUM,PAR_DESC_TXT,PAR_RCVD_DT,PAR_STTS) VALUES (?,?,?,?,?)";
	public static String getParMasterByParNumQuery          =   " SELECT PM.PAR_ID,PM.PAR_NUM,PM.PAR_DESC_TXT,PM.PAR_RCVD_DT,PM.PAR_STTS,PM.INTNT_TO_FIL_IND,PM.INTNT_SENT_DT,PM.EMAIL_SENT,PM.PAR_CMMNT,A.AREA_ID,A.AREA_NM,A.AREA_ACTIVE,S.SKILL_ID,S.SKILL_NM,S.SKILL_ACTIVE,PR.ROLE_ID,PR.ROLE_NM,PR.ROLE_ACTIVE,E.EXT_STAFF_ID,E.EXT_STAFF_NM,E.EXT_STAFF_ACTIVE,L.LOC_ID,L.LOC_NM,L.LOC_ACTIVE "
															  + " FROM PAR_MSTR PM,PAR_RLTN PMR, AREA_LKUP A, SKILL_LKUP S, ROLE_LKUP PR, EXT_STAFF_LKUP E, LOCATION L "
															  + " WHERE PM.PAR_ID = PMR.PAR_CD "
															  + " AND A.AREA_ID = PMR.AREA_CD "
															  + " AND S.SKILL_ID = PMR.SKILL_CD "
															  + " AND PR.ROLE_ID = PMR.ROLE_CD "
															  + " AND L.LOC_ID = PMR.LOC_CD "
															  + " AND E.EXT_STAFF_ID = PMR.EXT_STAFF_CD "
															  + " AND PM.PAR_NUM = ?";
	public static String getNextParSeqQuery                 =   " SELECT NEXTVAL('PAR_SEQ')";
	public static String updateParMasterQuery               =   " UPDATE PAR_MSTR SET PAR_DESC_TXT = ?, PAR_RCVD_DT = ?, PAR_STTS = ? WHERE PAR_NUM = ? ";
	public static String updateEmailSentQuery               =   " UPDATE PAR_MSTR SET EMAIL_SENT = ?,PAR_CMMNT = ? WHERE PAR_NUM = ?";
	public static String updateParCommentQuery              =   " UPDATE PAR_MSTR SET PAR_CMMNT = ? WHERE PAR_NUM = ?";
	public static String UpdateIntentToFillQuery            =   " UPDATE PAR_MSTR SET INTNT_TO_FIL_IND = ? , INTNT_SENT_DT = ? WHERE PAR_ID = ?";
	public static String deleteParMasterQuery               =   " DELETE FROM PAR_MSTR WHERE PAR_NUM = ?";

// Par Relation Queries
	
	public static String createParRltnQuery                 =   " INSERT INTO PAR_RLTN (PAR_CD,ROLE_CD,SKILL_CD,AREA_CD,EXT_STAFF_CD,LOC_CD) VALUES(?,?,?,?,?,?)";
	public static String updateParRltnQuery                 =   " UPDATE PAR_RLTN SET ROLE_CD = ? ,SKILL_CD = ?, AREA_CD = ?, EXT_STAFF_CD = ? , LOC_CD= ? WHERE PAR_CD = ?";
	public static String deleteParRltnQuery                 =   " DELETE FROM PAR_RLTN PR,PAR_MASTER PM  WHERE PR.PAR_CD = PM.PAR_ID AND PAR_NUM = ?";

// Par Allocation Queries
	
	public static String createParAllocationQuery           =   " INSERT INTO PAR_ALLOCATION(PAR_ALLOC_ID,PAR_CD,RECRUIT_CD,CAND_CD) VALUES(NEXTVAL('PAR_ALLOC_SEQ'),?,?,?)";
	public static String updateCandidateReceivedQuery       =   " UPDATE PAR_ALLOCATION SET CAND_CD = ? , RECRUIT_CD = ? WHERE PAR_ALLOC_ID = ?";
	public static String getCandidateReceivedByParNumQuery  =   " SELECT PA.PAR_ALLOC_ID,PA.PAR_CD,PA.RECRUIT_CD,PA.CAND_CD,C.CAND_NM,C.CAND_RCVD_DT,R.RECRUIT_NM"
															  + " FROM PAR_ALLOCATION PA, PAR_MSTR PM,CANDIDATE C, RECRUITER R "
															  + " WHERE PM.PAR_ID = PA.PAR_CD "
															  + " AND PA.CAND_CD = C.CAND_ID "
															  + " AND PA.RECRUIT_CD = R.RECRUIT_ID"
															  + " AND PM.PAR_NUM = ?";
	public static String getCandidateReceivedByParCdQuery   =   " SELECT PA.PAR_ALLOC_ID,PA.PAR_CD,PA.RECRUIT_CD,PA.CAND_CD,C.CAND_NM,C.CAND_RCVD_DT,R.RECRUIT_NM"
															  + " FROM PAR_ALLOCATION PA,CANDIDATE C, RECRUITER R "
															  + " WHERE PA.CAND_CD = C.CAND_ID "
															  + " AND PA.RECRUIT_CD = R.RECRUIT_ID"
															  + " AND PA.PAR_CD = ?";
			
	public static String deleteParAllocationQuery           =   " DELETE FROM PAR_ALLOCATION WHERE PAR_ALLOC_ID = ?";
	
	
	
	public static String updateSubmitCandidateQuery	        =   "UPDATE PAR_ALLOCATION SET SUBMIT_IND = ?, SUBMIT_DT = ? WHERE PAR_ALLOC_ID = ? AND PAR_CD = ?";
	
															  
	public static String getParAllocationByParNumQuery      =   " SELECT PA.PAR_ALLOC_ID,PA.PAR_CD,PA.RECRUIT_CD,PA.PRE_SCR_CD,PA.CAND_CD,PA.PRE_SCR_DT,PA.PRE_SCR_CMNT_TXT,PA.SUBMIT_IND,PA.SUBMIT_DT,PA.OFFER_RECVD_IND,PA.EXPTD_START_DT,PA.ACTUAL_START_DT "
			                                                  + " FROM PAR_ALLOCATION PA, PAR_MSTR PM "
			                                                  + " WHERE PM.PAR_ID = PA.PAR_CD "
			                                                  + " AND PM.PAR_NUM = ?";
	
    public static String updatePrescreeningQuery	       =   " UPDATE PAR_ALLOCATION SET PRE_SCR_CD = ? ,PRE_SCR_DT = ? ,PRE_SCR_CMNT_TXT = ? WHERE PAR_ALLOC_ID = ? AND PAR_CD = ?";
			                                               

}

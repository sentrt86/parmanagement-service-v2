package com.htc.par.data.dao;

import com.htc.par.model.ParMaster;

public interface IParMasterDAO {
	
	Boolean createParMaster(ParMaster parmaster);
	Boolean updateParMaster(ParMaster parmaster);
	Boolean createParMasterRltn(ParMaster parmaster);
	Boolean updateParMasterRltn(ParMaster parmaster);
	Boolean updateEmailSent(ParMaster parmaster);
	Boolean deleteParMaster(int parNo);
	Boolean deleteParMasterRltn(int parNo);
	ParMaster  getParMasterByParNum(String parNum);		
	int getNextParSeqId();
	Boolean updateIntentToFill(int parId,Boolean intentToFill,String intentSentDate);
	

}

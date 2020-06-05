package com.htc.par.data.dao;



import java.util.List;
import com.htc.par.model.UserMaster;


public interface IUserMasterDAO {
	
	List<UserMaster> getUserMasterByUserName(String username);
	List<UserMaster> getAllUserMaster();
	int getNextUserMasterId();
	Boolean updateUserMaster(UserMaster area);
	Boolean deleteUserMaster(int userId);
	Boolean createUserMaster(UserMaster userMaster); 
	

}

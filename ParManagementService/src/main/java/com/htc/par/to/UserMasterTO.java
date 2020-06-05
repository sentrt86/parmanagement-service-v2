package com.htc.par.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.htc.par.model.UserRole;

public class UserMasterTO {
	
	
	private int userId;
	@NotNull
	@NotEmpty(message="External Staff name is mandatory")
	@Size(min=2, max=30)
	private String userFirstName;
	@NotNull
	@NotEmpty(message="External Staff name is mandatory")
	@Size(min=2, max=30)
	private String userLastName;
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String userEmailTxt;
	private String userPhoneNo;
	private Boolean userActive;
	private String  userName;
	private String  password;
	private UserRole userRole;
	public UserMasterTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMasterTO(int userId,
			@NotNull @NotEmpty(message = "External Staff name is mandatory") @Size(min = 2, max = 30) String userFirstName,
			@NotNull @NotEmpty(message = "External Staff name is mandatory") @Size(min = 2, max = 30) String userLastName,
			@Email(message = "Please provide a valid email address") @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address") String userEmailTxt,
			String userPhoneNo, Boolean userActive, String userName, String password, UserRole userRole) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailTxt = userEmailTxt;
		this.userPhoneNo = userPhoneNo;
		this.userActive = userActive;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmailTxt() {
		return userEmailTxt;
	}
	public void setUserEmailTxt(String userEmailTxt) {
		this.userEmailTxt = userEmailTxt;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public Boolean getUserActive() {
		return userActive;
	}
	public void setUserActive(Boolean userActive) {
		this.userActive = userActive;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserMasterTO [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmailTxt=" + userEmailTxt + ", userPhoneNo=" + userPhoneNo + ", userActive=" + userActive
				+ ", userName=" + userName + ", password=" + password + ", userRole=" + userRole + "]";
	}
	
	
	

}

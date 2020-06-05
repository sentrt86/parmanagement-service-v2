package com.htc.par.model;

public class Recruiter {
	
	private int recruiterId;
	private String recruiterName;
	private String recruiterPhoneNo;
	private String recruiterEmail;
	private Boolean recruiterEmailFlag;
	private Boolean recruiterActive;
	
	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recruiter(int recruiterId, String recruiterName, String recruiterPhoneNo, String recruiterEmail,
			Boolean recruiterEmailFlag, Boolean recruiterActive) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.recruiterPhoneNo = recruiterPhoneNo;
		this.recruiterEmail = recruiterEmail;
		this.recruiterEmailFlag = recruiterEmailFlag;
		this.recruiterActive = recruiterActive;
	}

	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getRecruiterPhoneNo() {
		return recruiterPhoneNo;
	}

	public void setRecruiterPhoneNo(String recruiterPhoneNo) {
		this.recruiterPhoneNo = recruiterPhoneNo;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}

	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}

	public Boolean getRecruiterEmailFlag() {
		return recruiterEmailFlag;
	}

	public void setRecruiterEmailFlag(Boolean recruiterEmailFlag) {
		this.recruiterEmailFlag = recruiterEmailFlag;
	}

	public Boolean getRecruiterActive() {
		return recruiterActive;
	}

	public void setRecruiterActive(Boolean recruiterActive) {
		this.recruiterActive = recruiterActive;
	}

	@Override
	public String toString() {
		return "Recruiter [recruiterId=" + recruiterId + ", recuriterName=" + recruiterName + ", recruiterPhoneNo="
				+ recruiterPhoneNo + ", recruiterEmail=" + recruiterEmail + ", recruiterEmailFlag=" + recruiterEmailFlag
				+ ", recruiterActive=" + recruiterActive + "]";
	}
	
	
	
	
	

}

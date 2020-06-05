package com.htc.par.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RecruiterTO {
	
	private int recruiterId;
	
	@NotNull
	@NotEmpty(message="Role name is mandatory")
	@Size(min=2, max=30)
	private String recruiterName;
	private String recruiterPhoneNo;
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String recruiterEmail;
	private Boolean recruiterEmailFlag;
	private Boolean recruiterActive;
	
	
	public RecruiterTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecruiterTO(int recruiterId, String recruiterName, String recruiterPhoneNo, String recruiterEmail,
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

	public void setRecuriterName(String recuriterName) {
		this.recruiterName = recuriterName;
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
		return "Recruiter [recruiterId=" + recruiterId + ", recruiterName=" + recruiterName + ", recruiterPhoneNo="
				+ recruiterPhoneNo + ", recruiterEmail=" + recruiterEmail + ", recruiterEmailFlag=" + recruiterEmailFlag
				+ ", recruiterActive=" + recruiterActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recruiterActive == null) ? 0 : recruiterActive.hashCode());
		result = prime * result + ((recruiterEmail == null) ? 0 : recruiterEmail.hashCode());
		result = prime * result + ((recruiterEmailFlag == null) ? 0 : recruiterEmailFlag.hashCode());
		result = prime * result + recruiterId;
		result = prime * result + ((recruiterPhoneNo == null) ? 0 : recruiterPhoneNo.hashCode());
		result = prime * result + ((recruiterName == null) ? 0 : recruiterName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecruiterTO other = (RecruiterTO) obj;
		if (recruiterActive == null) {
			if (other.recruiterActive != null)
				return false;
		} else if (!recruiterActive.equals(other.recruiterActive))
			return false;
		if (recruiterEmail == null) {
			if (other.recruiterEmail != null)
				return false;
		} else if (!recruiterEmail.equals(other.recruiterEmail))
			return false;
		if (recruiterEmailFlag == null) {
			if (other.recruiterEmailFlag != null)
				return false;
		} else if (!recruiterEmailFlag.equals(other.recruiterEmailFlag))
			return false;
		if (recruiterId != other.recruiterId)
			return false;
		if (recruiterPhoneNo == null) {
			if (other.recruiterPhoneNo != null)
				return false;
		} else if (!recruiterPhoneNo.equals(other.recruiterPhoneNo))
			return false;
		if (recruiterName == null) {
			if (other.recruiterName != null)
				return false;
		} else if (!recruiterName.equals(other.recruiterName))
			return false;
		return true;
	}
	

}

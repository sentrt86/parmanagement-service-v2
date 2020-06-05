package com.htc.par.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.htc.par.model.Skill;

public class CandidateTO {
	

	private int candidateId;
	@NotNull
	@NotEmpty(message="External Staff name is mandatory")
	@Size(min=2, max=30)
	private String candidateName;
	private String candidatePhoneNum;
	
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String candidateEmailTxt;
	
	@NotNull
	@NotEmpty(message="Candidate received date is mandatory")
	@Size(min=8, max=10)
	private String candidateReceivedDate;
	private Boolean candidateActive;
	private Skill skill;
	public CandidateTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateTO(int candidateId,
			@NotNull @NotEmpty(message = "External Staff name is mandatory") @Size(min = 2, max = 30) String candidateName,
			String candidatePhoneNum,
			@Email(message = "Please provide a valid email address") @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address") String candidateEmailTxt,
			String candidateReceivedDate, Boolean candidateActive, Skill skill) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidatePhoneNum = candidatePhoneNum;
		this.candidateEmailTxt = candidateEmailTxt;
		this.candidateReceivedDate = candidateReceivedDate;
		this.candidateActive = candidateActive;
		this.skill = skill;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidatePhoneNum() {
		return candidatePhoneNum;
	}
	public void setCandidatePhoneNum(String candidatePhoneNum) {
		this.candidatePhoneNum = candidatePhoneNum;
	}
	public String getCandidateEmailTxt() {
		return candidateEmailTxt;
	}
	public void setCandidateEmailTxt(String candidateEmailTxt) {
		this.candidateEmailTxt = candidateEmailTxt;
	}
	public String getCandidateReceivedDate() {
		return candidateReceivedDate;
	}
	public void setCandidateReceivedDate(String candidateReceivedDate) {
		this.candidateReceivedDate = candidateReceivedDate;
	}
	public Boolean getCandidateActive() {
		return candidateActive;
	}
	public void setCandidateActive(Boolean candidateActive) {
		this.candidateActive = candidateActive;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateActive == null) ? 0 : candidateActive.hashCode());
		result = prime * result + ((candidateEmailTxt == null) ? 0 : candidateEmailTxt.hashCode());
		result = prime * result + candidateId;
		result = prime * result + ((candidateName == null) ? 0 : candidateName.hashCode());
		result = prime * result + ((candidatePhoneNum == null) ? 0 : candidatePhoneNum.hashCode());
		result = prime * result + ((candidateReceivedDate == null) ? 0 : candidateReceivedDate.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
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
		CandidateTO other = (CandidateTO) obj;
		if (candidateActive == null) {
			if (other.candidateActive != null)
				return false;
		} else if (!candidateActive.equals(other.candidateActive))
			return false;
		if (candidateEmailTxt == null) {
			if (other.candidateEmailTxt != null)
				return false;
		} else if (!candidateEmailTxt.equals(other.candidateEmailTxt))
			return false;
		if (candidateId != other.candidateId)
			return false;
		if (candidateName == null) {
			if (other.candidateName != null)
				return false;
		} else if (!candidateName.equals(other.candidateName))
			return false;
		if (candidatePhoneNum == null) {
			if (other.candidatePhoneNum != null)
				return false;
		} else if (!candidatePhoneNum.equals(other.candidatePhoneNum))
			return false;
		if (candidateReceivedDate == null) {
			if (other.candidateReceivedDate != null)
				return false;
		} else if (!candidateReceivedDate.equals(other.candidateReceivedDate))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CandidateTO [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidatePhoneNum="
				+ candidatePhoneNum + ", candidateEmailTxt=" + candidateEmailTxt + ", candidateReceivedDate="
				+ candidateReceivedDate + ", candidateActive=" + candidateActive + ", skill=" + skill + "]";
	}
	
	
	

}

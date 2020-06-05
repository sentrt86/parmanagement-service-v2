package com.htc.par.model;


public class Candidate {
	
	private int candidateId;
	private String candidateName;
	private String candidatePhoneNum;
	private String candidateEmailTxt;
	private String candidateReceivedDate;
	private Boolean candidateActive;
	private Skill skill;
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int candidateId, String candidateName, String candidatePhoneNum, String candidateEmailTxt,
			String candidateReceivedDate,Boolean candidateActive, Skill skill) {
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
	
	
	public String getCandidateReceivedDate() {
		return candidateReceivedDate;
	}
	public void setCandidateReceivedDate(String candidateReceivedDate) {
		this.candidateReceivedDate = candidateReceivedDate;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidatePhoneNum="
				+ candidatePhoneNum + ", candidateEmailTxt=" + candidateEmailTxt + ", candidateReceivedDate="
				+ candidateReceivedDate + ", candidateActive=" + candidateActive + ", skill=" + skill + "]";
	}
	
	
	
	
	

}

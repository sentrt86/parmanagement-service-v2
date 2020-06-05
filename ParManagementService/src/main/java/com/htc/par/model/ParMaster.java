package com.htc.par.model;

public class ParMaster {
	
	private int parId;
	private int parNumber;
	private String parDescriptionText;
	private String parReceivedDate;
	private String parStatus;
	private String intentToFill;
	private Boolean emailSent;
	private String  parComment;
	public ParMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParMaster(int parId, int parNumber, String parDescriptionText, String parReceivedDate, String parStatus,
			String intentToFill, Boolean emailSent, String parComment) {
		super();
		this.parId = parId;
		this.parNumber = parNumber;
		this.parDescriptionText = parDescriptionText;
		this.parReceivedDate = parReceivedDate;
		this.parStatus = parStatus;
		this.intentToFill = intentToFill;
		this.emailSent = emailSent;
		this.parComment = parComment;
	}
	public int getParId() {
		return parId;
	}
	public void setParId(int parId) {
		this.parId = parId;
	}
	public int getParNumber() {
		return parNumber;
	}
	public void setParNumber(int parNumber) {
		this.parNumber = parNumber;
	}
	public String getParDescriptionText() {
		return parDescriptionText;
	}
	public void setParDescriptionText(String parDescriptionText) {
		this.parDescriptionText = parDescriptionText;
	}
	public String getParReceivedDate() {
		return parReceivedDate;
	}
	public void setParReceivedDate(String parReceivedDate) {
		this.parReceivedDate = parReceivedDate;
	}
	public String getParStatus() {
		return parStatus;
	}
	public void setParStatus(String parStatus) {
		this.parStatus = parStatus;
	}
	public String getIntentToFill() {
		return intentToFill;
	}
	public void setIntentToFill(String intentToFill) {
		this.intentToFill = intentToFill;
	}
	public Boolean getEmailSent() {
		return emailSent;
	}
	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}
	public String getParComment() {
		return parComment;
	}
	public void setParComment(String parComment) {
		this.parComment = parComment;
	}
	@Override
	public String toString() {
		return "ParMaster [parId=" + parId + ", parNumber=" + parNumber + ", parDescriptionText=" + parDescriptionText
				+ ", parReceivedDate=" + parReceivedDate + ", parStatus=" + parStatus + ", intentToFill=" + intentToFill
				+ ", emailSent=" + emailSent + ", parComment=" + parComment + "]";
	}
	
	
	
	

}

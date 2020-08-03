package com.htc.par.to;

import com.htc.par.model.Candidate;
import com.htc.par.model.Prescreener;
import com.htc.par.model.Recruiter;

public class ParAllocationTO {
	
	private int parAllocationId;
	private int parCode;
	private Recruiter recruiter;
	private Candidate candidate;
	private Prescreener prescreener;
	private String prescreenerDate;
	private String prescreenerCommentText;
	private Boolean submitIndicator;
	private String submitDate;
	private Boolean offerReceivedIndicator;
	private String expectedStartDate;
	private String actualStartDate;
	public ParAllocationTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParAllocationTO(int parAllocationId, int parCode, Recruiter recruiter, Candidate candidate,
			Prescreener prescreener, String prescreenerDate, String prescreenerCommentText, Boolean submitIndicator,
			String submitDate, Boolean offerReceivedIndicator, String expectedStartDate, String actualStartDate) {
		super();
		this.parAllocationId = parAllocationId;
		this.parCode = parCode;
		this.recruiter = recruiter;
		this.candidate = candidate;
		this.prescreener = prescreener;
		this.prescreenerDate = prescreenerDate;
		this.prescreenerCommentText = prescreenerCommentText;
		this.submitIndicator = submitIndicator;
		this.submitDate = submitDate;
		this.offerReceivedIndicator = offerReceivedIndicator;
		this.expectedStartDate = expectedStartDate;
		this.actualStartDate = actualStartDate;
	}
	public int getParAllocationId() {
		return parAllocationId;
	}
	public void setParAllocationId(int parAllocationId) {
		this.parAllocationId = parAllocationId;
	}
	public int getParCode() {
		return parCode;
	}
	public void setParCode(int parCode) {
		this.parCode = parCode;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Prescreener getPrescreener() {
		return prescreener;
	}
	public void setPrescreener(Prescreener prescreener) {
		this.prescreener = prescreener;
	}
	public String getPrescreenerDate() {
		return prescreenerDate;
	}
	public void setPrescreenerDate(String prescreenerDate) {
		this.prescreenerDate = prescreenerDate;
	}
	public String getPrescreenerCommentText() {
		return prescreenerCommentText;
	}
	public void setPrescreenerCommentText(String prescreenerCommentText) {
		this.prescreenerCommentText = prescreenerCommentText;
	}
	public Boolean getSubmitIndicator() {
		return submitIndicator;
	}
	public void setSubmitIndicator(Boolean submitIndicator) {
		this.submitIndicator = submitIndicator;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public Boolean getOfferReceivedIndicator() {
		return offerReceivedIndicator;
	}
	public void setOfferReceivedIndicator(Boolean offerReceivedIndicator) {
		this.offerReceivedIndicator = offerReceivedIndicator;
	}
	public String getExpectedStartDate() {
		return expectedStartDate;
	}
	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}
	public String getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	@Override
	public String toString() {
		return "ParAllocation [parAllocationId=" + parAllocationId + ", parCode=" + parCode + ", recruiter=" + recruiter
				+ ", candidate=" + candidate + ", prescreener=" + prescreener + ", prescreenerDate=" + prescreenerDate
				+ ", prescreenerCommentText=" + prescreenerCommentText + ", submitIndicator=" + submitIndicator
				+ ", submitDate=" + submitDate + ", offerReceivedIndicator=" + offerReceivedIndicator
				+ ", expectedStartDate=" + expectedStartDate + ", actualStartDate=" + actualStartDate + "]";
	}
	
	
	

}

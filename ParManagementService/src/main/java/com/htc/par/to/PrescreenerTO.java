package com.htc.par.to;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PrescreenerTO  implements Serializable{
	
	
	private static final long serialVersionUID = -1479022528557635406L;
	private int preScreenerId;
	@NotNull
	@NotEmpty(message="Presceener name is mandatory")
	@Size(min=2, max=30)
	private String preScreenerName;
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String preScreenerEmailId;
	private String preScreenercontactNo;
	private Boolean preScreenerActive;
	public int getPreScreenerId() {
		return preScreenerId;
	}
	public void setPreScreenerId(int preScreenerId) {
		this.preScreenerId = preScreenerId;
	}
	public String getPreScreenerName() {
		return preScreenerName;
	}
	public void setPreScreenerName(String preScreenerName) {
		this.preScreenerName = preScreenerName;
	}
	public String getPreScreenerEmailId() {
		return preScreenerEmailId;
	}
	public void setPreScreenerEmailId(String preScreenerEmailId) {
		this.preScreenerEmailId = preScreenerEmailId;
	}
	public String getPreScreenercontactNo() {
		return preScreenercontactNo;
	}
	public void setPreScreenercontactNo(String preScreenercontactNo) {
		this.preScreenercontactNo = preScreenercontactNo;
	}
	public Boolean getPreScreenerActive() {
		return preScreenerActive;
	}
	public void setPreScreenerActive(Boolean preScreenerActive) {
		this.preScreenerActive = preScreenerActive;
	}
	@Override
	public String toString() {
		return "PrescreenerTO [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerEmailId=" + preScreenerEmailId + ", preScreenercontactNo=" + preScreenercontactNo
				+ ", preScreenerActive=" + preScreenerActive + "]";
	}
	
		
	

}

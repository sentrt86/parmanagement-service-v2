package com.htc.par.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.htc.par.model.Area;

public class ExternalStaffTO {
	
	private int extStaffId;
	
	@NotNull
	@NotEmpty(message="External Staff name is mandatory")
	@Size(min=2, max=30)
	private String extStaffName;
	private Area area;
	private Boolean extStaffActive;
	public ExternalStaffTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExternalStaffTO(int extStaffId,
			@NotNull @NotEmpty(message = "External Staff name is mandatory") @Size(min = 2, max = 30) String extStaffName,
			Area area, Boolean extStaffActive) {
		super();
		this.extStaffId = extStaffId;
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = extStaffActive;
	}
	public int getExtStaffId() {
		return extStaffId;
	}
	public void setExtStaffId(int extStaffId) {
		this.extStaffId = extStaffId;
	}
	public String getExtStaffName() {
		return extStaffName;
	}
	public void setExtStaffName(String extStaffName) {
		this.extStaffName = extStaffName;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Boolean getExtStaffActive() {
		return extStaffActive;
	}
	public void setExtStaffActive(Boolean extStaffActive) {
		this.extStaffActive = extStaffActive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extStaffActive == null) ? 0 : extStaffActive.hashCode());
		result = prime * result + extStaffId;
		result = prime * result + ((extStaffName == null) ? 0 : extStaffName.hashCode());
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
		ExternalStaffTO other = (ExternalStaffTO) obj;
		if (extStaffActive == null) {
			if (other.extStaffActive != null)
				return false;
		} else if (!extStaffActive.equals(other.extStaffActive))
			return false;
		if (extStaffId != other.extStaffId)
			return false;
		if (extStaffName == null) {
			if (other.extStaffName != null)
				return false;
		} else if (!extStaffName.equals(other.extStaffName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExternalStaffTO [extStaffId=" + extStaffId + ", extStaffName=" + extStaffName + ", extStaffActive="
				+ extStaffActive + "]";
	}
	

	
	

}

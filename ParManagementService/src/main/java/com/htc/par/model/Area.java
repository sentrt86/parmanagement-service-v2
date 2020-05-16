package com.htc.par.model;

public class Area {
	
	private int areaId;
	private String areaName;
	private Boolean areaActive;
	
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Area(int areaId, String areaName, Boolean areaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaActive = areaActive;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Boolean getAreaActive() {
		return areaActive;
	}

	public void setAreaActive(Boolean areaActive) {
		this.areaActive = areaActive;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", areaActive=" + areaActive + "]";
	}
	
	
	

}

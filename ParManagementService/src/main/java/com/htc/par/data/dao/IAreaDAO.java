package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Area;

public interface IAreaDAO {

	List<Area> getAllAreas();
	List<Area> getAreaById(int value);
	List<Area> getActiveArea();
	Boolean updateArea(Area area);
	Boolean deleteArea(int areaId);
	Boolean createArea(Area area); 
	int getNextAreaId();

}

package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Location;

public interface ILocationDAO {
	
	List<Location> getALLLocations();
	int getnextLocationId();
	boolean createLocation(Location location);
	boolean updateLocation(Location location);
	boolean deleteLocation(int  locationId);
	List<Location> getActiveLocation();
	
	

}
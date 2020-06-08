package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.ILocationDAO;
import com.htc.par.data.mapper.LocationRowMapper;
import com.htc.par.model.Location;

@Repository
public class LocationDAOImpl implements ILocationDAO{
	
	@Autowired JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getALLLocations() {
		List<Location> locations = new ArrayList<Location>();
		locations = jdbcTemplate.query(ParSqlQueries.getAllLocationsQuery, new Object[] {}, new LocationRowMapper());
		return locations;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getActiveLocation() {
		List<Location> locations = new ArrayList<Location>();
		locations = jdbcTemplate.query(ParSqlQueries.getAllLocationsQuery, new Object[] {}, new LocationRowMapper());
		return locations;
	}

	@Override
	public int getnextLocationId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextLocationId,new Object[] {},Integer.class);
	}

	@Override
	public boolean createLocation(Location location) {
		boolean locationAdded = false;
		Object[] parms = new Object[] {location.getLocationId(),location.getLocationName(),location.getLocationActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.BOOLEAN};
		int AddCount = jdbcTemplate.update(ParSqlQueries.createLocationQuery,parms,parmsType);
		if (AddCount > 0)
		{
			locationAdded = true;
		}
		return locationAdded;
	}

	@Override
	public boolean updateLocation(Location location) {
		boolean locationUdpated = false;
		Object[] parms = new Object[] {location.getLocationName(),location.getLocationActive(),location.getLocationId()};
		int[] parmsType = new int[] {Types.CHAR,Types.BOOLEAN,Types.INTEGER};
		int AddCount = jdbcTemplate.update(ParSqlQueries.updateLocationQuery,parms,parmsType);
		
		if (AddCount > 0)
		{
			locationUdpated = true;
		}
		return locationUdpated;
	}

	@Override
	public boolean deleteLocation(int locationId) {
		boolean locationDeleted = false;
		Object[] parms = new Object[] {locationId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteLocationQuery,parms,parmsType);
		if (deleteCount > 0)
		{
			locationDeleted = true;
		}
		return locationDeleted;	}

}

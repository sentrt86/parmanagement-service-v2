package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.IAreaDAO;
import com.htc.par.data.mapper.AreaRowMapper;
import com.htc.par.model.Area;

@Repository
public class AreaDAOImpl implements IAreaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	//Get all the Area from the area_lkup table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getAllAreas() {
		return jdbcTemplate.query(ParSqlQueries.getAllAreasQuery,new Object[]{}, new AreaRowMapper());		
	}


	//Get an Area for a given area id from the area_lkup table
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getAreaById(int areaId) {
		return jdbcTemplate.query(ParSqlQueries.getAreaByIdQuery,new Object[]{areaId}, new AreaRowMapper());
	}

	//update the Area info in the area_lkup table for a give area id

	@Override
	public Boolean updateArea(Area area) {
		
		boolean areaUpdated = false;
		
		Object[] parms = new Object[] {area.getAreaName(), area.getAreaActive(),area.getAreaId()};
		int[] parmsTypes = new int[] {Types.CHAR,Types.BOOLEAN,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateArea,parms,parmsTypes);		
		if (updateCount > 0)
		{
			areaUpdated = true;
		}
		return areaUpdated;
	}


	// Delete the Area from the area_lkup table for give area id
	
	@Override
	public Boolean deleteArea(int areaId) {
		boolean areaDeleted = false;
		
		Object[] parms = new Object[] {areaId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteArea,parms,parmsType);
		if (deleteCount > 0)
		{
			areaDeleted = true;
		}
		return areaDeleted;
	}

	// Create an Area in the area_lkup table

	@Override
	public Boolean createArea(Area area) {
		boolean areaCreated = false;
		Object[] parms = new Object[] {area.getAreaId(),area.getAreaName(),area.getAreaActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.CHAR,Types.BOOLEAN};
		int createCount = jdbcTemplate.update(ParSqlQueries.createArea,parms,parmsType);
		if (createCount > 0)
		{
			areaCreated = true;
		}
		return areaCreated;
	}

	// Get all Area which are active in the area_lkup table
	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getActiveArea() {
		return jdbcTemplate.query(ParSqlQueries.getactiveArea,new Object[]{}, new AreaRowMapper());		
	}

	
	// Get the next area id from the area_seq
	
	@Override
	public int getNextAreaId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextAreaId,new Object[] {},Integer.class);
		
	}

}

package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Area;
import com.htc.par.to.AreaTO;

@Service
public interface IAreaService {
	
	
	public List<Area>  getAllAreas() throws ResourceNotFoundException;
	public List<Area>  getActiveAreas() throws ResourceNotFoundException;
	public List<Area>  getAreaById(int areaId) throws ResourceNotFoundException;
	public String deleteArea(int areaId) throws ResourceNotFoundException;
	public String createArea(AreaTO areaTO) throws ResourceNotCreatedException;
	public String updateArea(AreaTO areaTO) throws ResourceNotCreatedException, ResourceNotUpdatedException;
	public int  getNextAreaId() throws ResourceAccessException;
	
	
	
	


}

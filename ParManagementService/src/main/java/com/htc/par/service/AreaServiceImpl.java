package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.AreaDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Area;
import com.htc.par.service.IAreaService;
import com.htc.par.to.AreaTO;

@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	AreaDAOImpl areaDaoImpl;

	/*
	 * Request handler to GET all Areas
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */

	@Override
	public List<Area> getAllAreas() throws ResourceNotFoundException {	
		List<Area> areaList = new ArrayList<Area> ();		
		try {
			areaList = areaDaoImpl.getAllAreas();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return areaList;
	}


	/*
	 * GET Areas by area id
	 * 
	 * @ResourseNotFoundException
	 * @ResourceAccessException
	 */


	@Override 
	public List<Area> getAreaById(int areaId) throws ResourceNotFoundException { 
		List<Area> areaList = new ArrayList<Area> (); 
		try {
			areaList = areaDaoImpl.getAreaById(areaId);
			if(areaList.isEmpty()) {
				throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Area Id %S",areaId));	
			}
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Area Id %S",areaId));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return areaList; 
	
	}


	/*
	 * Delete the Area for a give area id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String deleteArea(int areaId) throws ResourceNotFoundException {

		try { 
			boolean deleteAreaSuccess = areaDaoImpl.deleteArea(areaId); 
			if(deleteAreaSuccess) 
			{ 
				return String.format(ParConstants.deleteSuccessfull + "for Area Id: " + areaId); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Area  Id : " + areaId)); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Area Id : %s",areaId); 
	}
	
	/*
	 * Update the Area information for a given area id
	 * 
	 * @ResourseNotFoundException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String updateArea(AreaTO areaTO) throws ResourceNotFoundException {
		List<Area> allAreasList = new ArrayList<Area>();
		try { 
			allAreasList = areaDaoImpl.getAllAreas(); 
			if(!allAreasList.isEmpty()) {
				for(Area data : allAreasList) 
				{ 
					if (data.getAreaName().equalsIgnoreCase(areaTO.getAreaName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Area: %s",areaTO.getAreaName()));
					} 
				} 
				boolean updateAreaSuccess = areaDaoImpl.updateArea(new Area(areaTO.getAreaId(),areaTO.getAreaName(),areaTO.getAreaActive())); 
			
				if(updateAreaSuccess) { 
					return String.format(ParConstants.updateSuccessfull + "for Area: %s",areaTO.getAreaName()); 
				}
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for Area : %s",areaTO.getAreaName())); 
		}
		return String.format(ParConstants.updateUnSuccessfull + "for Area: %s",areaTO.getAreaName()); 

	}


	/*
	 * Create the Area information
	 * 
	 * @ResourseNotCreatedException
	 * 
	 * @ResourseAccessException
	 */


	@Override 
	public String createArea(AreaTO areaTO) throws ResourceNotCreatedException { 
		List<Area> allAreasList = new ArrayList<Area>();
		
		try { 
			allAreasList = areaDaoImpl.getAllAreas(); 
			if(!allAreasList.isEmpty()) {
				for(Area data : allAreasList) 
				{ 
					if (data.getAreaName().equalsIgnoreCase(areaTO.getAreaName())) 
					{ 
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Area: %s",areaTO.getAreaName()));
					} 
				} 
				
			}
			
			if(areaDaoImpl.createArea(new Area(areaTO.getAreaId(),areaTO.getAreaName(),areaTO.getAreaActive())))
			{ 
				return String.format(ParConstants.createSuccessfull + "for area : %s",areaTO.getAreaName()); 
			} 
				

		}catch(DataAccessException ex) { 
			throw new ResourceNotCreatedException(String.format(ParConstants.createUnSuccessfull + "for Area : %s ",areaTO.getAreaName())); 
		} 
		return String.format(ParConstants.createUnSuccessfull + "for area : %s",areaTO.getAreaName());

	}



	/*
	 * Get the next area id from the area_seq
	 * 
	 * @ResourseAccessException
	 */

	@Override 
	public int getNextAreaId() throws ResourceAccessException {
		try {
			return areaDaoImpl.getNextAreaId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }

	}
 

}

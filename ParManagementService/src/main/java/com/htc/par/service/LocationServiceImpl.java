package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.LocationDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Location;
import com.htc.par.to.LocationTO;

@Service
public class LocationServiceImpl implements ILocationService {


	@Autowired
	LocationDAOImpl locationDaoImpl;

	@Override
	public List<Location> getAllLocations() throws ResourceNotFoundException {
		List<Location> locations = new ArrayList<Location> ();		
		try {
			locations = locationDaoImpl.getALLLocations();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return locations;
	}

	@Override
	public List<Location> getActiveLocations() throws ResourceNotFoundException {
		List<Location> locations = new ArrayList<Location> ();		
		try {
			locations = locationDaoImpl.getActiveLocation();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return locations;
	}

	@Override
	public int getNextLocationId() throws ResourceNotFoundException {
		try {
			return locationDaoImpl.getnextLocationId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}


	}

	@Override
	public String deleteLocation(int locationId) throws ResourceNotFoundException {
		try { 
			boolean locationDeleted = locationDaoImpl.deleteLocation(locationId); 
			if(locationDeleted) { 
				return String.format(ParConstants.deleteSuccessfull + "for Location Id:" + Integer.toString(locationId)); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Location Id: " + Integer.toString(locationId))); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Location Id : "+Integer.toString(locationId)); 	
	}

	@Override
	public String createLocation(LocationTO locationTO) throws ResourceNotCreatedException {
		List<Location> allLocations = new ArrayList<Location> ();
		System.out.println(locationTO.toString());
		try { 
			allLocations = locationDaoImpl.getALLLocations();
			if(!allLocations.isEmpty()) {
				for(Location data : allLocations) {

					if(data.getLocationName().equalsIgnoreCase(locationTO.getLocationName())) {
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Location : %s",locationTO.getLocationName()));
					}
				}
			}
			boolean locationAdded = locationDaoImpl.createLocation(new Location(locationTO.getLocationId(),locationTO.getLocationName(),locationTO.getLocationActive())); 
			if(locationAdded) { 
				return String.format(ParConstants.createSuccessfull + "for Location Name: "+ locationTO.getLocationName() );

			}

		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.createUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Location Name: "+ locationTO.getLocationName() ); 

	}

	@Override
	public String updateLocation(LocationTO locationTO) throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 
			boolean locationUpdated = locationDaoImpl.updateLocation(new Location(locationTO.getLocationId(),locationTO.getLocationName(),locationTO.getLocationActive())); 
			if(locationUpdated) {
				return String.format(ParConstants.updateSuccessfull + "for Location Name: "+ locationTO.getLocationName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.updateUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
		} 
		return String.format(ParConstants.updateUnSuccessfull + "for Location Name: "+ locationTO.getLocationName() ); 
	}

}

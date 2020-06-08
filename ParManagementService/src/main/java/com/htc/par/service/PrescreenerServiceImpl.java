package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.PrescreenerDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Prescreener;
import com.htc.par.to.PrescreenerTO;

@Service
public class PrescreenerServiceImpl implements IPrescreenerService {

	@Autowired
	PrescreenerDAOImpl prescreenerDAOImpl;


	// Get all the Prescreeners
	@Override
	public List<Prescreener> getAllPrescreeners() throws ResourceNotFoundException {
		List<Prescreener> prescreenerlist = new ArrayList<Prescreener> ();		
		try {
			prescreenerlist = prescreenerDAOImpl.getAllPrescreeners();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return prescreenerlist;
	}

	// Get all the Prescreeners
	@Override
	public List<Prescreener> getActivePrescreeners() throws ResourceNotFoundException {
		List<Prescreener> prescreenerlist = new ArrayList<Prescreener> ();		
		try {
			prescreenerlist = prescreenerDAOImpl.getActivePrescreener();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return prescreenerlist;
	}

	//delete the given prescreener ID
	@Override
	public String deletePrescreener(int prescreenerId) throws ResourceNotFoundException {
		try { 
			boolean prescreenerDeleted = prescreenerDAOImpl.deletePrescreener(prescreenerId); 
			if(prescreenerDeleted) { 
				return String.format(ParConstants.deleteSuccessfull + "for Prescreener Id:" + Integer.toString(prescreenerId)); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Prescreener Id : " +Integer.toString(prescreenerId))); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Prescreener Id : "+Integer.toString(prescreenerId)); 
	}

	@Override
	public String createPrescreener(PrescreenerTO prescreenerTO) throws ResourceNotCreatedException {
		List<Prescreener> allPrescreenerList = new ArrayList<Prescreener> ();		
		try { 
			allPrescreenerList = prescreenerDAOImpl.getAllPrescreeners();
			if(!allPrescreenerList.isEmpty())
			{
				for(Prescreener data : allPrescreenerList) {
					if(data.getPreScreenerName().equalsIgnoreCase(prescreenerTO.getPreScreenerName()) && data.getPreScreenercontactNo().equalsIgnoreCase(prescreenerTO.getPreScreenercontactNo()))
					{
						throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Prescreener : %s",prescreenerTO.getPreScreenerName()));
					}
				}

			}
			boolean prescreenerAdded = prescreenerDAOImpl.createPrescreener(new Prescreener(prescreenerTO.getPreScreenerId(),prescreenerTO.getPreScreenerName(),prescreenerTO.getPreScreenerEmailId(),prescreenerTO.getPreScreenercontactNo(),prescreenerTO.getPreScreenerActive())); 
			if(prescreenerAdded) { 
				return String.format(ParConstants.createSuccessfull + "for Prescreener Name: "+ prescreenerTO.getPreScreenerName() );

			}


		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.createUnSuccessfull + "for Prescreener Id :" + Integer.toString(prescreenerTO.getPreScreenerId()) +" and Prescreener Name: " + prescreenerTO.getPreScreenerName()));
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Prescreener Name: "+ prescreenerTO.getPreScreenerName() ); 

	}

	@Override
	public String updatePrescreener(PrescreenerTO prescreenerTO) throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 
			boolean prescreenerUpdated = prescreenerDAOImpl.updatePrescreener(new Prescreener(prescreenerTO.getPreScreenerId(),prescreenerTO.getPreScreenerName(),prescreenerTO.getPreScreenerEmailId(),prescreenerTO.getPreScreenercontactNo(),prescreenerTO.getPreScreenerActive()));
			if(prescreenerUpdated) {
				return String.format(ParConstants.updateSuccessfull + "for Prescreener Name: "+ prescreenerTO.getPreScreenerName()); 
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.updateUnSuccessfull + "for Prescreener Id :" + Integer.toString(prescreenerTO.getPreScreenerId()) +" and Prescreener Name: " + prescreenerTO.getPreScreenerName()));
		} 
		return String.format(ParConstants.updateUnSuccessfull + "for Prescreener Name: "+ prescreenerTO.getPreScreenerName() ); 
	}

	@Override
	public int getNextPrescreenerId() throws ResourceNotFoundException {
		try {
			return prescreenerDAOImpl.getnextPrescreenerId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }

	}

}

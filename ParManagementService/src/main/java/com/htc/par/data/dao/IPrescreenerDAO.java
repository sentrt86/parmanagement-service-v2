package com.htc.par.data.dao;

import java.util.List;
import com.htc.par.model.Prescreener;

public interface IPrescreenerDAO {
	List<Prescreener> getAllPrescreeners();
	int getnextPrescreenerId();
	boolean createPrescreener(Prescreener prescreener);
	boolean updatePrescreener(Prescreener prescreener);
	boolean deletePrescreener(int  prescreenerId);
	

}
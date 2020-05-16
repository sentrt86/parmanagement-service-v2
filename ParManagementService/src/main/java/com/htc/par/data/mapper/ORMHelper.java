package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ORMHelper {
	
	public static String  getBooleanToString(ResultSet rs, String columnLabel) throws SQLException{	
		Boolean value = rs.getBoolean(columnLabel);
		return value ? "Yes" : "No";
		
	}
	
	public static boolean  getStringToBoolean(String value) {
		return Boolean.getBoolean(value);
		
	}

}

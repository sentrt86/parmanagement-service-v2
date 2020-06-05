package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ORMHelper {
	
	public static String  getBooleanToString(ResultSet rs, String columnLabel) throws SQLException{	
		Boolean value = rs.getBoolean(columnLabel);
		return value ? "Yes" : "No";
		
	}
	
	public static boolean  getStringToBoolean(String value) {
		return Boolean.getBoolean(value);
		
	}
	
	public static String convertDateToString(ResultSet rs,String columnLable) throws SQLException {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(rs.getDate(columnLable));
		
	}

}

package com.sap.scholarProject.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sap.scholarProject.model.Scholar;

@Service
public class ScholarDatabase {
    
    public void closeDb(Connection conn) {
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public boolean enterData(Connection conn, String sid, String name, String batch) {
		System.out.println("got here");
    	
		try {
			Statement stmt = conn.createStatement();
		
	        String sqlQuery = "insert into scholars (i_number, sid, name, batch) values('" + sid + "', '" + sid + "', '" + name + "', '" + batch + "');";
	        
	        System.out.println(sqlQuery);

	        stmt.executeUpdate(sqlQuery);
	        
	        return true;

		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
    }

    public List<Scholar> getAllData(Connection conn) {
    	
    	List<Scholar> scholars = new ArrayList<>();
    	
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			String sqlQuery = "select * from scholars;";
	    	
	        ResultSet rs = stmt.executeQuery(sqlQuery);

	        rs = stmt.executeQuery(sqlQuery);

	        while(rs.next()) {
	        	Scholar scholar = new Scholar();
	        	scholar.setiNumber(rs.getString(1));
	        	scholar.setName(rs.getString(2));
	        	scholar.setBatch(rs.getString(3));
	        	scholars.add(scholar);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return scholars; 
    }
    
    public Scholar getData(Connection conn, String sid) {
    	String sqlQuery = "show tables;";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
		
	        sqlQuery = "select * from scholars where sid='" + sid + "';";
	        
	        System.out.println(sqlQuery);
	        
	        // need to handle when the query results in an empty set

	        stmt.executeQuery(sqlQuery);
	        
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        String foundtype = "empty";
	        
	        if(rs.next()){
        	   foundtype = rs.getString(1);
        	}
	        
	        System.out.println(foundtype);

	        Scholar scholar = new Scholar();
        	scholar.setiNumber(rs.getString(1));
        	scholar.setName(rs.getString(2));
        	scholar.setBatch(rs.getString(3));
        	
        	return scholar;

		} catch (SQLException e) {
			e.printStackTrace();
			return new Scholar();
		}
    }

    public void removeData(Connection conn, String sid) {
    	String sqlQuery = "show tables;";
    	Statement stmt;
		try {
			stmt = conn.createStatement();
		
	        sqlQuery = "delete from scholars where sid='" + sid + "';";
	        
	        System.out.println(sqlQuery);

	        stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
        
}
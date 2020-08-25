package com.sap.scholarProject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.scholarProject.model.Scholar;
import com.sap.scholarProject.repository.ScholarRepository;

@Service
public class ScholarService {
	
	@Autowired
	private ScholarDatabase scholarDatabase;
	private ScholarRepository scholarRepository;
	private Connection conn;
	
	public ScholarService() {
		setConnection();
	}
	
	public void setConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost";
        String username = "root";
        String password = "root";
        
        try {
            Class.forName(driver);

            this.conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            stmt.executeQuery("use world;");
            
            System.out.println("Connected database successfully");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
	}
	
	public List<Scholar> getAllScholars() {
		// code that works
		return scholarDatabase.getAllData(conn);
		
		// code that doesn't
		/*
		public List<Scholar> getAllScholars() {
		  List<Scholar> scholars = new ArrayList<>();
		  for(Scholar scholar: scholarRepository.findAll()) {
		    scholars.add(scholar);
		  }
		  return scholars;
		}
		*/
	}
	
	public Scholar getScholar(String id) {
		return scholarDatabase.getData(conn, id);
	}
	
	public void addScholar(Scholar scholar) {
		scholarDatabase.enterData(conn, scholar.getiNumber(), scholar.getName(), scholar.getBatch());
	}
	
	public void deleteScholar(String id) {
		scholarDatabase.removeData(conn, id);
	}
}

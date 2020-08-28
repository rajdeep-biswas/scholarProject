package com.sap.scholarProject.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.scholarProject.config.DatabaseConfiguration;
import com.sap.scholarProject.model.Scholar;

@Service
public class ScholarService {
	
//	private DatabaseConfiguration dbCon;
	private Connection conn;
	
	@Autowired
	private ScholarDatabase scholarDatabase;
	
	@Autowired
	public ScholarService(DatabaseConfiguration dbCon) {
//		this.dbCon = dbCon;
		this.conn = dbCon.setConnection();
	}
	
	public List<Scholar> getAllScholars() {
		return scholarDatabase.getAllData(conn);
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

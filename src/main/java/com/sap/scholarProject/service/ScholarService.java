package com.sap.scholarProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.scholarProject.model.Scholar;
import com.sap.scholarProject.repository.ScholarRepository;

@Service
public class ScholarService {
	
	@Autowired
	ScholarRepository scholarRepository;
	
////	private DatabaseConfiguration dbCon;
//	private Connection conn;
//	
//	@Autowired
//	private ScholarDatabase scholarDatabase;
//	
//	@Autowired
//	public ScholarService(DatabaseConfiguration dbCon) {
////		this.dbCon = dbCon;
//		this.conn = dbCon.setConnection();
//	}
	
	public List<Scholar> getAllScholars() {
		return (List<Scholar>) scholarRepository.findAll();
	}
	
	public Scholar getScholar(String id) {
		Optional<Scholar> scholr = scholarRepository.findById(id);
		return scholr.get();
	}
	
	public void addScholar(Scholar scholar) {
		scholarRepository.save(scholar );
	}
	
	public void deleteScholar(String id) {
//		scholarDatabase.removeData(conn, id);
	}
}

package com.sap.scholarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.scholarProject.model.Scholar;

// Connect to DB, do DB operation, return the data / result

@Repository
public interface ScholarRepository extends CrudRepository<Scholar, String> {

}

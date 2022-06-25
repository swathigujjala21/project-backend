package com.example.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query(value = "SELECT Count(p.id) FROM patient p WHERE p.visited_doctor=?1",nativeQuery = true)
	int countTotal(String docName);

}

package com.example.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query(value = "SELECT d.name FROM doc d",nativeQuery = true)
	List<String> findAllByName();
	
	@Query(value = "SELECT * FROM doctor d WHERE d.name=?1",nativeQuery = true)
	Doctor getDoctorByName(String docName);

}

package com.example.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	public ResponseEntity<Doctor> saveDoctor(Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorRepository.save(doctor),HttpStatus.CREATED);
	}

	public List<String> getDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAllByName();
	}

	public Doctor getDoctorByName(String docName) {
		// TODO Auto-generated method stub
		return doctorRepository.getDoctorByName(docName);
	}

	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

}

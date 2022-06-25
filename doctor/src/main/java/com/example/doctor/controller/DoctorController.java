package com.example.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.entity.Doctor;
import com.example.doctor.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	@GetMapping("/doctors")
	public List<String> getDoctors(){
		return doctorService.getDoctors();
	}
	@GetMapping("/doctors/")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/{docName}")
	public Doctor getDoctorByName(@PathVariable String docName) {
		return doctorService.getDoctorByName(docName);
	}
	@GetMapping("doctors/get/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}
	
	

}

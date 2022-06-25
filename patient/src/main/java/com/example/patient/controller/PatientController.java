package com.example.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient.entity.Patient;
import com.example.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable int id){
		return patientService.getPatientById(id);
	}
	
	@PutMapping("/{id}/{docName}")
	public Patient assignDocId(@PathVariable int id,@PathVariable String docName){
		return patientService.assignDocId(id,docName);
	}

}

package com.example.patient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.patient.VO.Doctor;
import com.example.patient.VO.ResponseTemplateObject;
import com.example.patient.entity.Patient;
import com.example.patient.exception.ResourceNotFoundException;
import com.example.patient.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Patient savePatient(Patient patient) {
		Patient savedPatient=new Patient();
		savedPatient=patientRepository.save(patient);
		//ResponseTemplateObject vo =new ResponseTemplateObject();
		ResponseEntity<Doctor> d= restTemplate.getForEntity("http://localhost:8081/"
				+savedPatient.getVisitedDoctor(), 
				Doctor.class);
		Doctor doc=d.getBody();
		int c=patientRepository.countTotal(doc.getName());
		System.out.println("Hello"+c);
		doc.setNumberOfPatients(patientRepository.countTotal(doc.getName()));
		
		ResponseEntity<Doctor> savedDoctor=restTemplate.postForEntity("http://localhost:8081/"
				+ "doctors",doc, Doctor.class);
		return patientRepository.save(patient);
	}

	public Patient getPatientById(int id) {
		Optional<Patient> patient=patientRepository.findById(id);
		Patient savedPatient=new Patient();
		if(patient.isPresent()) {
			savedPatient=patient.get();
		}
		else {
			throw new ResourceNotFoundException("Patient", "id", savedPatient);
		}
		return savedPatient;
	}

	public Patient assignDocId(int id, String docName) {
		Optional<Patient> patient=patientRepository.findById(id);
		Patient savedPatient=new Patient();
		if(patient.isPresent()) {
			savedPatient=patient.get();
		}
		savedPatient.setVisitedDoctor(docName);
		return patientRepository.save(savedPatient);

	}

}

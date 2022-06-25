package com.example.patient.VO;

import com.example.patient.entity.Patient;

public class ResponseTemplateObject {
	
	private Doctor doctor;
	private Patient[] patient;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient[] getPatient() {
		return patient;
	}
	public void setPatient(Patient[] patient) {
		this.patient = patient;
	}
	
	

}

package com.example.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String visitedDoctor;
	private String dateOfVisit;
	private String prescription;
	
	//@Transient
	private int visitedDoctorId;
	
	
	public int getVisitedDoctorId() {
		return visitedDoctorId;
	}
	public void setVisitedDoctorId(int visitedDoctorId) {
		this.visitedDoctorId = visitedDoctorId;
	}
	
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Patient( String name, String dateOfVisit) {
		super();
		this.name = name;
		this.dateOfVisit = dateOfVisit;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id, String name, String visitedDoctor, String dateOfVisit, String prescription,
			int visitedDoctorId) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
		this.visitedDoctorId = visitedDoctorId;
	}
	
	
	

}

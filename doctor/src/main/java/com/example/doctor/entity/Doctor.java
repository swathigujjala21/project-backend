package com.example.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String specialist;
	private int numberOfPatients;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public Doctor(int id, String name, String gender, String specialist,int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.specialist = specialist;
		this.age=age;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int id, String name, String gender, String specialist, int numberOfPatients, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.specialist = specialist;
		this.numberOfPatients = numberOfPatients;
		this.age = age;
	}
	
	
	

}

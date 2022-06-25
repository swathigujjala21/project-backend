package com.example.doctor.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.doctor.controller.DoctorController;
import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import com.example.doctor.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
	
	@WebMvcTest(DoctorController.class)
	public class DoctorTest {
	  @MockBean
	  private DoctorRepository doctorRepository;
	  
	  @MockBean
	  private DoctorService doctorService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Doctor doctor=new Doctor(9, "Mona", "F", "O&G", 6, 25);

	    mockMvc.perform(post("/doctors").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(doctor)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=9;
	    String name="Mona";
	    Doctor doctor=new Doctor(id, name, "F", "O&G", 6, 25);

	    when(doctorRepository.findById(id)).thenReturn(Optional.of(doctor));
	    mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
	        .andDo(print());
	  }
	  


	  @Test
	  void shouldReturnListOfDoctors() throws Exception {
	    List<Doctor> doctors = new ArrayList<>(
	        Arrays.asList(new Doctor(1, "Mona", "F", "O&G", 6, 25),
	            new Doctor(2, "Sona", "F", "O&G", 6, 25),
	            new Doctor(3, "Dona", "F", "O&G", 6, 25)));

	    when(doctorRepository.findAll()).thenReturn(doctors);
	    mockMvc.perform(get("/doctors/"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.size()").value(doctors.size()))
	        .andDo(print());
	  }

}
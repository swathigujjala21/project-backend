package com.example.patient.test;

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

import com.example.patient.controller.PatientController;
import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	
	  @MockBean
	  private PatientRepository patientRepository;
	  
	  @MockBean
	  private PatientService patientService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Patient patient=new Patient(1, "Mona", "Dr.Mona", "22-06-2022","Thyronorm",
				1);

	    mockMvc.perform(post("/patients/").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(patient)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=9;
	    String name="Mona";
	    Patient patient=new Patient(id,"Mona", "Dr.Mona", "22-06-2022","Thyronorm",
				1);

	    mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
	      
	        .andDo(print());
	  }
	  


}
package com.detector.mutantdetector.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.detector.mutantdetector.AppApplication;
import com.detector.mutantdetector.entiry.DnaReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = AppApplication.class)
class MutantDetectorCTRLTest {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	void testMutant() {
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("TGTGTC", "GAGGAG", "TAGGTA", "GAACGT", "TACGCT", "CCCTGA"));

		try {
			for (int i = 0; i < 100; i++) {
				this.mvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(dnaReq))).andDo(print())
						.andExpect(status().isOk());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testIsNotMutant() {
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("TGTGTC", "GAGGAG", "TAGATA", "GCACGT", "TACGCT", "CCCTGA"));

		try {
			for (int i = 0; i < 100; i++) {
				this.mvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(dnaReq))).andDo(print())
						.andExpect(status().isForbidden());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testBadRequetDnaData() {
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("TGTGTC", "GAGGAG", "TAGAT", "GCACGT", "TACGCt", "CCCTGA"));

		try {
			for (int i = 0; i < 100; i++) {
				this.mvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(dnaReq))).andDo(print())
						.andExpect(status().isBadRequest());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

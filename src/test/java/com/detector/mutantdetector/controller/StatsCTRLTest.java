package com.detector.mutantdetector.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.detector.mutantdetector.AppApplication;

@SpringBootTest(classes = AppApplication.class)
class StatsCTRLTest {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testStats() {
		try {
			this.mvc.perform(get("/stats/")).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

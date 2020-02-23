package com.detector.mutantdetector.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.detector.mutantdetector.business.ValidatorBusiness;
import com.detector.mutantdetector.entiry.Dna;
import com.detector.mutantdetector.entiry.DnaReq;
import com.detector.mutantdetector.repository.DnaRepository;
import com.detector.mutantdetector.service.DnaService;
import com.detector.mutantdetector.service.DnaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MutantDetectorCTRL {

//	@Autowired
//	UserRepository userRepository;

	@Autowired
	DnaRepository dnaRepository;
	
	@Autowired
	DnaService<Dna> dnaService;

	@Autowired
	ValidatorBusiness validatorBusiness;
//
//	@RequestMapping("/")
//	@ResponseBody
//	String home() {
//		System.out.print("<<<<<<<<<<<<<Cleaning MongoDatabase>>>>>>>>>>>>>>");
//		userRepository.deleteAll();
//
//		for (int i = 0; i < 5; i++) {
//			User user = userRepository.save(new User(i, "Test" + i, String.valueOf(i + 12)));
//
//			System.out.println("<<<<<<<<<<<<<Adding User >>>>>>>>>>>>>>");
//			System.out.println("***" + user.toString() + "***");
//		}
//
//		System.out.println("<<<<<<<<<<<<<Get All  User >>>>>>>>>>>>>>");
//		List<User> alluser = userRepository.findAll();
//		alluser.forEach(item -> System.out.println(item));
//
//		alluser.clear();
//
//		System.out.println("<<<<<<<<<<<<<Find User By Name >>>>>>>>>>>>>>");
//		alluser = userRepository.findByName("Test1");
//		alluser.forEach(item -> System.out.println(item));
//
//		System.out.println("Executed");
//		return "Hello World!";
//	}

	@PostMapping("/mutant/")
	@ResponseBody
	public void detectMutant(@RequestBody DnaReq dnaReq, HttpServletResponse response) throws IOException {

		dnaReq.getDna().forEach(System.out::println);
		System.out.println("Llego: " + new ObjectMapper().writeValueAsString(dnaReq.getDna()));

		Dna dna = new Dna();
		dna.setDna(new ObjectMapper().writeValueAsString(dnaReq.getDna()));
		dna.setMutant(validatorBusiness.isMutant(dnaReq.getDna().toArray(new String[0])));
//
//		dnaService.save(dna);

//		System.out.println("Inserted with: "+dna.get_id());
		if(dna.isMutant())
//		if (validatorBusiness.isMutant(dnaReq.getDna().toArray(new String[0])))
			response.setStatus(HttpServletResponse.SC_OK);
		else
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
//		return ResponseEntity.ok("");
//		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}

}

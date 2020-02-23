package com.detector.mutantdetector.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.detector.mutantdetector.Data;
import com.detector.mutantdetector.business.ValidatorBusiness;
import com.detector.mutantdetector.entiry.Dna;
import com.detector.mutantdetector.entiry.DnaReq;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Resolves the dna validation petition 
 * @author cesar_contreras
 *
 */
@Controller
public class MutantDetectorCTRL {


	@Autowired
	ValidatorBusiness validatorBusiness;

	@PostMapping("/mutant/")
	@ResponseBody
	public void detectMutant(@RequestBody DnaReq dnaReq, HttpServletResponse response) throws IOException {

		Dna dna = new Dna();
		dna.setDna(new ObjectMapper().writeValueAsString(dnaReq.getDna()));
		dna.setMutant(validatorBusiness.isMutant(dnaReq.getDna().toArray(new String[0])));

		//Save the dna in safe list after validate
		Data.add(dna);

		if(dna.isMutant())
			response.setStatus(HttpServletResponse.SC_OK);
		else
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

}

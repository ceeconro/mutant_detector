package com.detector.mutantdetector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.detector.mutantdetector.entiry.DnaStatsResp;
import com.detector.mutantdetector.repository.DnaRepository;

/**
 * Resolves the stats petitions
 * @author cesar_contreras
 *
 */
@Controller
public class StatsCTRL {

	@Autowired
	DnaRepository dnaRepository;

	@GetMapping("/stats")
	@ResponseBody
	public DnaStatsResp getStats() {
		Long val = dnaRepository.countByIsMutant(true);
		Long valAll = dnaRepository.count();
		System.out.println("All DNA: " + valAll + " Cant Mutants: " + val + " Ratio: " + ((double) val / valAll));
		return new DnaStatsResp(val, valAll, (Math.round(((double) val / valAll) * 1000.0) / 1000.0));
	}

}

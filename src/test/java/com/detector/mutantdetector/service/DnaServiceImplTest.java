package com.detector.mutantdetector.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.detector.mutantdetector.AppApplication;
import com.detector.mutantdetector.Data;
import com.detector.mutantdetector.entiry.Dna;

@SpringBootTest(classes = AppApplication.class)
class DnaServiceImplTest {

	@Autowired
	DnaService<Dna> dnaService;

	@Test
	void test() {
		Dna dna = new Dna();
		dna.setDna("{\"TGTGTC\", \r\n" + "\"GAGGAG\", \r\n" + "\"TAGGTA\", \r\n" + "\"GCACGT\", \r\n"
				+ "\"TACGCt\", \r\n" + "\"CCCTGA\"}");
		dna.setMutant(true);
//
		Data.add(dna);
		while (Data.getListDna().size() > 0) {
			dnaService.bulkSave();
		}
		assertEquals(0, Data.getListDna().size());
	}

}

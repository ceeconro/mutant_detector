package com.detector.mutantdetector.entiry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DnaTest {

	Dna dna;
	DnaStatsResp nsr2;

	@BeforeEach
    public void init() {
		dna = new Dna();
		dna.set_id("111100000");
		dna.setDna("AAAA");
		dna.setMutant(true);
    }
	

	@Test
	void testDnaId() {
		assertTrue(dna.get_id().equals("111100000"));
	}

	@Test
	void testDna() {
		assertTrue(dna.getDna().equals("AAAA"));

	}

	@Test
	void testDnaIsMutant() {
		assertTrue(dna.isMutant());
	}

}

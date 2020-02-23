package com.detector.mutantdetector.entiry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DnaStatsRespTest {

	DnaStatsResp nsr;
	DnaStatsResp nsr2;

	@BeforeEach
    public void init() {
		nsr = new DnaStatsResp(1L, 1L, 1.0d);
		nsr2 = new DnaStatsResp();
		nsr2.setCountHumanDna(1L);
		nsr2.setCountMutantDna(1L);
		nsr2.setRatio(1.0d);
    }
	

	@Test
	void testNotEqualsObjects() {
		assertNotEquals(nsr, nsr2);

	}

	@Test
	void testNotEqualsString() {
		assertNotEquals(nsr.toString(), nsr2.toString());

	}

	@Test
	void testEqualsCountDna() {
		assertEquals(nsr.getCountHumanDna(), nsr2.getCountHumanDna());

	}

	@Test
	void testEqualsCountMutanrDna() {
		assertEquals(nsr.getCountMutantDna(), nsr2.getCountMutantDna());
	}

	@Test
	void testEqualsRatio() {
		assertEquals(nsr.getRatio(), nsr2.getRatio());
	}

	@Test
	void testNotEquals() {
		assertFalse(nsr.equals(nsr2));
	}

}

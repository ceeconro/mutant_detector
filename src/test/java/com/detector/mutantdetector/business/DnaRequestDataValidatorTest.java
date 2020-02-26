package com.detector.mutantdetector.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.detector.mutantdetector.entiry.DnaReq;

/**
 * 
 * @author cesar_contreras
 *
 */
class DnaRequestDataValidatorTest {

	@Test
	void testDnaReqIsNull() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.IS_NOT_NULL);
		assertFalse(validator.isValid(null));

	}

	@Test
	void testDnaReqListIsNull() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(null);
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.IS_NOT_NULL);
		assertFalse(validator.isValid(dnaReq));

	}

	@Test
	void testDnaReqListIsEmpty() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(new ArrayList<String>());
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.IS_NOT_NULL);
		assertFalse(validator.isValid(dnaReq));

	}

	@Test
	void testDnaReqListIsNotEmpty() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB"));
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.IS_NOT_NULL);
		assertTrue(validator.isValid(dnaReq));

	}

	@Test
	void testDnaReqListNotMoreThanOneElement() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA"));
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.HAS_MORE_THAN_ONE);
		assertFalse(validator.isValid(dnaReq));

	}

	@Test
	void testDnaReqListMoreThanOneElement() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB"));
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.HAS_MORE_THAN_ONE);
		assertTrue(validator.isValid(dnaReq));

	}

	@Test
	void testDnaReqListIsNotNxN() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB"));
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.ARRAY_IS_N_X_N);
		assertFalse(validator.isValid(dnaReq));
	}

	@Test
	void testDnaReqListIsNxN() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB", "BBBB", "BBBB"));
		validator.getValidators().clear();
		validator.getValidators().add(DnaRequestValidators.ARRAY_IS_N_X_N);
		assertTrue(validator.isValid(dnaReq));
	}

	@Test
	void testDnaReqListAllStringSameSize() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB", "BBBB", "BBBB"));
		validator.getValidators().clear();
		validator.getValidators().add(new DnaReqAllElementSameSizeValidator());
		assertTrue(validator.isValid(dnaReq));
	}

	@Test
	void testDnaReqListNotAllStringSameSize() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("AAAA", "BBBB", "BBBB", "BBB"));
		validator.getValidators().add(new DnaReqAllElementSameSizeValidator());
		assertFalse(validator.isValid(dnaReq));
	}

	@Test
	void testDnaReqHasNitrogenChars() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("TGTGTC", "GAGGAG", "TAGATA", "GCACGT", "TACGCT", "CCCTGA"));
		validator.getValidators().clear();
		validator.getValidators().add(new DnaReqAreNitrogenCharsValidator());
		assertTrue(validator.isValid(dnaReq));
	}
	
	@Test
	void testDnaReqHasNotNitrogenChars() {
		DnaRequestDataValidator validator = new DnaRequestDataValidator();
		DnaReq dnaReq = new DnaReq();
		dnaReq.setDna(Arrays.asList("TGTGTC", "GAGPAG", "TAGATA", "GCACGT", "TACGCT", "CCCTGA"));
		validator.getValidators().clear();
		validator.getValidators().add(new DnaReqAreNitrogenCharsValidator());
		assertFalse(validator.isValid(dnaReq));
	}

}

package com.detector.mutantdetector.business;

public interface MutantDetectorBusiness {

	/**
	 * 
	 * @param dna
	 * @return true if dna is mutant
	 */
	boolean isMutant(String[] dna);

}
package com.detector.mutantdetector.business;

/**
 * 
 * @author cesar_contreras
 *
 * @param <T>
 * @param <R>
 */
public interface CountFormSequence<T, R> {
	
	int getMutantSequences(T dna, R test, int total);

}

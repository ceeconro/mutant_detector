package com.detector.mutantdetector.business;

public interface CountFormSequence<T, R> {
	
	int getMutantSequences(T dna, R test, int total);

}

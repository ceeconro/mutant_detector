package com.detector.mutantdetector.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

/**
 * @author cesar_contreras
 *
 */

@Component
public class ValidatorBusiness {

	private static final String[] MUTAN_SEQUENCE = { "AAAA", "TTTT", "CCCC", "GGGG" };
	

	/**
	 * 
	 * @param dna
	 * @return true if dna is mutant
	 */
	public boolean isMutant(String[] dna) {
		Predicate<String> test = new ValidSequenceMutant(MUTAN_SEQUENCE);
		int total = 0;
		List<CountFormSequence<String[], Predicate<String>>> listValidators = new ArrayList<CountFormSequence<String[], Predicate<String>>>();
		listValidators.add(new CountHorizontalFormSequence());
		listValidators.add(new CountVerticalFormSequence());
		listValidators.add(new CountObliqueFormSequence());

		for (CountFormSequence<String[], Predicate<String>> val : listValidators) {
			total = val.getMutantSequences(dna, test, total);
			if (total > 1)
				return true;
		}

		return false;
	}

}

/**
 * Check if sequence is a correct sequence
 * 
 * @author cesar_contreras
 *
 */
class ValidSequenceMutant implements Predicate<String> {

	String[] sequences;

	public ValidSequenceMutant(String[] sequences) {
		this.sequences = sequences;
	}

	@Override
	public boolean test(String t) {
		for (int i = 0; i < sequences.length; i++) {
			if (t.contains(sequences[i]))
				return true;
		}
		return false;
	}

}

/**
 * Verification for Horizontal form
 * 
 * @author cesar_contreras
 *
 */
class CountHorizontalFormSequence implements CountFormSequence<String[], Predicate<String>> {

	@Override
	public int getMutantSequences(String[] dna, Predicate<String> test, int total) {
		return ((int) Arrays.stream(dna).filter(s -> test.test(s)).count()) + total;
	}

}

/**
 * Verification for Vertical form
 * 
 * @author cesar_contreras
 *
 */
class CountVerticalFormSequence implements CountFormSequence<String[], Predicate<String>> {

	@Override
	public int getMutantSequences(String[] dna, Predicate<String> test, int countMatchSequence) {
		int sequenceSize = dna[0].length();
		for (int i = 0; i < sequenceSize; i++) {
			StringBuffer sequence = new StringBuffer();
			for (int j = 0; j < dna.length; j++) {
				sequence.append(dna[j].charAt(i));
			}
			if (test.test(sequence.toString()))
				countMatchSequence++;

			if (countMatchSequence > 1)
				return countMatchSequence;

		}

		return countMatchSequence;
	}

}

/**
 * Verification for oblique form
 * 
 * @author cesar_contreras
 *
 */
class CountObliqueFormSequence implements CountFormSequence<String[], Predicate<String>> {

	@Override
	public int getMutantSequences(String[] dna, Predicate<String> test, int countMatchSequence) {
		// get horizontal size
		int horizontalSize = dna[0].length();
		countMatchSequence = findSequences(dna, test, 0, horizontalSize, countMatchSequence);

		// if countMatchSequence is major than 1 the dna is mutant and not validate no
		// else
		if (countMatchSequence > 1)
			return countMatchSequence;

		// reverses the string array to validate the sequences oblique ascendents
		List<String> list = Arrays.asList(dna);
		Collections.reverse(list);
		String[] dnaReverse = (String[]) list.toArray();

		return findSequences(dnaReverse, test, 1, horizontalSize, countMatchSequence);

	}

	/**
	 * Builds the string sequence in oblique form and check if is valid
	 * 
	 * @param dna
	 * @param test:          Validator
	 * @param initCicle:     init value for dont repeat oblique validation when
	 *                       invert the array
	 * @param horizontalSize
	 * @return
	 */
	private int findSequences(String[] dna, Predicate<String> test, int initCicle, int horizontalSize,
			int countMatchSequence) {
		for (int i = initCicle; i < horizontalSize-initCicle; i++) {
			StringBuffer sequence = new StringBuffer();
			int k = i;
			boolean swithPos = changeDirection(horizontalSize, i, 4);
			for (int j = 0; j < dna.length; j++) {
				sequence.append(dna[j].charAt(k));

				// if the size is minor than the valid sequence size, get out
				if ((k - 1 < 0 && swithPos) || ((k + 1) >= horizontalSize && !swithPos))
					break;

				// change the position to other direction
				if (swithPos) {
					k--;
				} else {
					k++;
				}

			}
			if (test.test(sequence.toString()))
				countMatchSequence++;

			if (countMatchSequence > 1)
				return countMatchSequence;

		}

		return countMatchSequence;
	}

	/**
	 * Checks if the size of the characters in this direction are valids
	 * 
	 * @param sequenceSize      value for the horizontal size of the array
	 * @param position          actual horizontal position
	 * @param validSequenceSize size of the valid sequence compared
	 * @return
	 */
	private boolean changeDirection(int sequenceSize, int position, int validSequenceSize) {
		if ((sequenceSize - position) < validSequenceSize)
			return true;
		return false;

	}

}

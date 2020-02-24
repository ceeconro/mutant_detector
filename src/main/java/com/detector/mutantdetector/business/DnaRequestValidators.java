package com.detector.mutantdetector.business;

import java.util.function.Predicate;

import com.detector.mutantdetector.entiry.DnaReq;

/**
 * 
 * @author cesar_contreras
 *
 */
public interface DnaRequestValidators {

	// Validation for not null or empty data
	public static final Predicate<DnaReq> IS_NOT_NULL = (
			t) -> !(t == null || t.getDna() == null || t.getDna().isEmpty());
	// Validate tha the array has more than one element
	public static final Predicate<DnaReq> HAS_MORE_THAN_ONE = (t) -> !(t.getDna().size() < 2);
	// Validate for array size N x N
	public static final Predicate<DnaReq> ARRAY_IS_N_X_N = (t) -> (t.getDna().size() == t.getDna().get(0).length());

}

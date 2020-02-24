package com.detector.mutantdetector.business;

import java.util.function.Predicate;

import com.detector.mutantdetector.entiry.DnaReq;

public class DnaReqAllElementSameSizeValidator implements Predicate<DnaReq> {

	@Override
	public boolean test(DnaReq t) {
		for (String dnaR : t.getDna()) {
			if (t.getDna().size() != dnaR.length())
				return false;
		}
		return true;
	}

}

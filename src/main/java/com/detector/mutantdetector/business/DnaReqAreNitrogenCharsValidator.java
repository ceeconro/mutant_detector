package com.detector.mutantdetector.business;

import java.util.function.Predicate;

import com.detector.mutantdetector.entiry.DnaReq;

public class DnaReqAreNitrogenCharsValidator implements Predicate<DnaReq> {

	String nitrogensChars = "ATCG";

	@Override
	public boolean test(DnaReq t) {
		for (String dnaR : t.getDna()) {
			for (Character charDna : dnaR.toCharArray()) {
				if (nitrogensChars.indexOf(charDna) < 0)
					return false;
			}
		}
		return true;
	}

}

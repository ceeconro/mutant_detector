package com.detector.mutantdetector.business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.detector.mutantdetector.entiry.DnaReq;

/**
 * 
 * @author cesar_contreras
 *
 * @param <T>
 */

@Component
public class DnaRequestDataValidator implements RequestDataValidator<DnaReq, Predicate<DnaReq>> {

	List<Predicate<DnaReq>> validators = new ArrayList<Predicate<DnaReq>>();
	

	public DnaRequestDataValidator() {
		super();
		validators.add(DnaRequestValidators.IS_NOT_NULL);
		validators.add(DnaRequestValidators.HAS_MORE_THAN_ONE);
		validators.add(DnaRequestValidators.ARRAY_IS_N_X_N);
		validators.add(new DnaReqAllElementSameSizeValidator());
		validators.add(new DnaReqAreNitrogenCharsValidator());
	}

	@Override
	public List<Predicate<DnaReq>> getValidators() {
		return validators;
	}

	@Override
	public boolean isValid(DnaReq data) {
		for (Predicate<DnaReq> predicate : validators) {
			if (!predicate.test(data))
				return false;
		}
		return true;
	}

}

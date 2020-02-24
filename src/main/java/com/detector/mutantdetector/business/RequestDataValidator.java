package com.detector.mutantdetector.business;

import java.util.List;

/**
 * 
 * @author cesar_contreras
 *
 * @param <T>
 */
public interface RequestDataValidator <T, R> {
	
	List<R> getValidators();
	
	boolean isValid(T data);
}

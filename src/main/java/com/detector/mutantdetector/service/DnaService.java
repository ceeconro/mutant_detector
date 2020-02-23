package com.detector.mutantdetector.service;

/**
 * 
 * @author cesar_contreras
 *
 * @param <T>
 */
public interface DnaService <T> {
	
	void save(T entity);
	public void bulkSave();

}

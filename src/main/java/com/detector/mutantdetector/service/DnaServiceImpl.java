package com.detector.mutantdetector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.detector.mutantdetector.Data;
import com.detector.mutantdetector.entiry.Dna;
import com.detector.mutantdetector.repository.DnaRepository;

/**
 * Manage the data to the repository
 * @author cesar_contreras
 *
 */
@Service
public class DnaServiceImpl implements DnaService<Dna>{
	
	@Autowired
	DnaRepository dnaRepository;

	/**
	 * Save an ADN entity object to DN
	 */
	@Override	
	public void save(Dna entity) {
		dnaRepository.save(entity);
	}
	
	/**
	 * Execute the theads to save data from safe list
	 */
	@Async("executorRepository")
	public void bulkSave() {
		while(Data.getListDna().size()>0) {
			Dna dna = Data.remove(0);
			this.save(dna);
		}
	}

}

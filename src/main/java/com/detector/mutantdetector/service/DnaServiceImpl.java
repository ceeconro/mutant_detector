package com.detector.mutantdetector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.detector.mutantdetector.entiry.Dna;
import com.detector.mutantdetector.repository.DnaRepository;

@Service
public class DnaServiceImpl implements DnaService<Dna>{
	
	@Autowired
	DnaRepository dnaRepository;

	@Override
	@Async("executorRepository")
	public void save(Dna entity) {
		// TODO Auto-generated method stub
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println("**************************Executing Save Thread*********************************");
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		dnaRepository.save(entity);
		
	}

}

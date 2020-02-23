package com.detector.mutantdetector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.detector.mutantdetector.entiry.Dna;

/**
 * dna data persistent
 * @author cesar_contreras
 *
 */
@Repository
public interface DnaRepository  extends MongoRepository<Dna, Integer>{
	
	long countByIsMutant(boolean isMutant);

}

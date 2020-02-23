package com.detector.mutantdetector.entiry;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "dna_data")
public class Dna{
	
    String _id;
	private String dna;
	private boolean isMutant;
}

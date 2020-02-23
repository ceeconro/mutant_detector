package com.detector.mutantdetector.entiry;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Dna entity persistent
 * @author cesar_contreras
 *
 */
@Document(collection = "dna_data")
public class Dna{
	
    String _id;
	private String dna;
	private boolean isMutant;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
	
}

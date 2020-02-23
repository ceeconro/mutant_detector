package com.detector.mutantdetector.entiry;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Manage the stats response data
 * 
 * @author cesar_contreras
 *
 */
public class DnaStatsResp {

	@JsonProperty("count_mutant_dna")
	private Long countMutantDna;

	@JsonProperty("count_human_dna")
	private Long countHumanDna;

	private Double ratio;

	public DnaStatsResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnaStatsResp(Long countMutantDna, Long countHumanDna, Double ratio) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}

	public Long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public Long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

}

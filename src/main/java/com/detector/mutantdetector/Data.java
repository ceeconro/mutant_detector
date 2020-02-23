package com.detector.mutantdetector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.detector.mutantdetector.entiry.Dna;

/**
 * Store the safe data list of DNA that will be persisted in DB
 * @author cesar_contreras
 *
 */
public abstract class Data {
	
	private static List<Dna> safeList = Collections.synchronizedList(new ArrayList<Dna>());
	
	
	public static List<Dna> getListDna() {
		return safeList;
	}
	
	public static void add(Dna dna) {
		safeList.add(dna);
	}
	
	public static Dna remove(int index) {
		return safeList.remove(index);
	}

}

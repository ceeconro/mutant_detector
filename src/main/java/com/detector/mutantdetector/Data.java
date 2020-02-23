package com.detector.mutantdetector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.detector.mutantdetector.entiry.Dna;

public class Data {
	
	private List<Dna> safeList = Collections.synchronizedList(new ArrayList<Dna>());
	
	
	public void test() {
		safeList.remove(0);
	}

}

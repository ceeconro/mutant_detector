package com.detector.mutantdetector.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author cesar_contreras
 *
 */
class ValidatorBusinessTest {

//	private List<Object[]> dataHorizontal = Arrays.asList(
//			new Object[][] { { true, new String[] { "TATTTT", "CACCTA", "TAAAAG", "TATTGT", "CAGTGC", "ATGCGA" } }, // Horizontal
//																													// 2
//					{ true, new String[] { "TATGTT", "CTTTTA", "TAGCAG", "TATTGT", "CAGTGC", "AGGGGA" } }, // Horizontal
//																											// 2
//					{ false, new String[] { "TACGTT", "CTAGTA", "TAGCAG", "TGTTGT", "TAGTGC", "TGCCGA" } }, // Vertical
//																											// 1
//					{ false, new String[] { "TACGTA", "CTAGTA", "TATCAC", "AGTTGA", "TAGTGC", "TGCCGA" } }, // Oblicua 1
//					{ true, new String[] { "TACGTA", "CTAGTA", "TCCAAC", "AGCTAA", "TAGCGC", "TGCCGA" } }, // Oblicua 2
//																											// con
//																											// reversa
//					{ false, new String[] { "TACGTA", "CTAGTA", "TCCCAC", "AGCTGA", "TAGCGC", "TGCCGA" } }, // Oblicua
//																											// reversa 1
//					{ true, new String[] { "TACGTA", "CTAGTA", "TAGCAA", "TGTTGA", "TAGTGC", "TGCCGA" } }, // Vertical
//																											// 2
//					{ false, new String[] { "TACGTT", "CTAGTA", "TAGCAG", "TGTTGT", "CAGTGC", "AGCCGA" } } // Nada
//			});

//	@Test
//	void testIsMutant() {
//
//		ValidatorBusiness vb = new ValidatorBusiness();
//		for (Object[] data : dataHorizontal) {
//			if ((Boolean) data[0])
//				assertTrue(vb.isMutant((String[]) data[1]));
//			else
//				assertFalse(vb.isMutant((String[]) data[1]));
//		}
//	}

	@Test
	void testIsMutantFalse() {
		ValidatorBusiness vb = new ValidatorBusiness();

		assertFalse(vb.isMutant(new String[] { "TACGTT", "CTAGTA", "TAGCAG", "TGTTGT", "CAGTGC", "AGCCGA" }));
		assertFalse(vb.isMutant(new String[] { "TACGTA", "CTAGTA", "TCCCAC", "AGCTGA", "TAGCGC", "TGCCGA" }));
		assertFalse(vb.isMutant(new String[] { "TACGTA", "CTAGTA", "TATCAC", "AGTTGA", "TAGTGC", "TGCCGA" }));
	}

	@Test
	void testIsMutantHorizontal() {
		ValidatorBusiness vb = new ValidatorBusiness();

		assertTrue(vb.isMutant(new String[] { "TATTTT", "CACCTA", "TAAAAG", "TATTGT", "CAGTGC", "ATGCGA" }));
		assertTrue(vb.isMutant(new String[] { "TATGTT", "CTTTTA", "TAGCAG", "TATTGT", "CAGTGC", "AGGGGA" }));
	}

	@Test
	void testIsMutantVertical() {
		ValidatorBusiness vb = new ValidatorBusiness();

		assertTrue(vb.isMutant(new String[] { "TACGTA", "CTAGTA", "TAGCAA", "TGTTGA", "TAGTGC", "TGCCGA" }));
		assertTrue(vb.isMutant(new String[] { "TACGTC", "CGAGTA", "TGGCAA", "TGTTGA", "TGGTGC", "TGCCGA" }));
	}

	@Test
	void testIsMutantOblique() {
		ValidatorBusiness vb = new ValidatorBusiness();

		assertTrue(vb.isMutant(new String[] { "TACGTA", "CTAGTA", "TCCAAC", "AGCTAA", "TAGCGC", "TGCCGA" }));
		assertTrue(vb.isMutant(new String[] { "TAAGTC", "GATAAG", "TGGCAA", "GTTTAA", "TGTTGC", "TGCTGA" }));
		assertTrue(vb.isMutant(new String[] { "TAAGTC", "GATAAG", "TGGCCA", "GTGCAA", "TCCGCt", "CCCTGA" }));
		assertTrue(vb.isMutant(new String[] { "TGTGTC", "GAGTAG", "TGGGTA", "GTACGT", "TCCGCt", "CCCTGA" }));
	}

	@Test
	void testIsMutantMix() {
		ValidatorBusiness vb = new ValidatorBusiness();

		assertTrue(vb.isMutant(new String[] { "TGTGTC", "GGGGAG", "TGGGTA", "GTACGT", "TCCGCt", "CCCTGA" }));
		assertTrue(vb.isMutant(new String[] { "TGTGTC", "GAGGAG", "TAGGTA", "GAACGT", "TACGCt", "CCCTGA" }));
	}

}

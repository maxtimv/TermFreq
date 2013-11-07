/**
 * 
 */
package com.maxtimv.termfreq;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Maxim Timofeev
 * 
 */
public class TermExtractorAcronymTest {

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermExtractorAcronym#normalize(java.lang.String)}
	 * .
	 */
	@Test
	public void testNormalize() {
		System.out.println("* TermExtractorAcronymTest: testNormalize()");
		assertEquals("CAT", new TermExtractorAcronym().normalize("CAT"));
		assertEquals("cat", new TermExtractorAcronym().normalize("Cat"));
		assertEquals("cat", new TermExtractorAcronym().normalize("cat"));
	}

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermExtractorAcronym#isAcronym(java.lang.String)}
	 * .
	 */
	@Test
	public void testIsAcronym() {
		System.out.println("* TermExtractorAcronymTest: testIsAcronym()");
		assertTrue(new TermExtractorAcronym().isAcronym("CAT"));
		assertFalse(new TermExtractorAcronym().isAcronym("Cat"));
		assertFalse(new TermExtractorAcronym().isAcronym("cat"));
	}

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermExtractor#extract(java.lang.String)}.
	 */
	@Test
	public void testExtract() {
		System.out.println("* TermExtractorAcronymTest: testExtract()");
		assertArrayEquals(
				new Term[] { new Term("cat", 2), new Term("CAT", 1) },
				new TermExtractorAcronym().extract("  cat  CAT   Cat ").toArray(new Term[0]));
	}
}

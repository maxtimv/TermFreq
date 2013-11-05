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
public class TermExtractorTest {

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermExtractor#extract(java.lang.String)}.
	 */
	@Test
	public void testExtract() {
		System.out.println("* TermExtractorTest: testExtract()");
		assertArrayEquals(new Term[] { new Term("cat") },
				new TermExtractor().extract("Cat"));

		assertArrayEquals(new Term[] { new Term("cat", 2) },
				new TermExtractor().extract("  cat  Cat "));

		assertArrayEquals(new Term[] { new Term("don't") },
				new TermExtractor().extract("don't"));

		assertArrayEquals(new Term[] { new Term("1.2") },
				new TermExtractor().extract("1.2"));

		assertArrayEquals(new Term[] { new Term("cat", 1),
				new Term("don't", 1), new Term("1.2", 1) },
				new TermExtractor().extract("Cat...  don't  1.2"));

		assertArrayEquals(new Term[] { new Term("cat", 2), new Term("and", 2),
				new Term("dog", 1), new Term("one", 1), new Term("more", 1) },
				new TermExtractor()
						.extract("Cat and dog 'and' one more '''''cat"));
	}

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermExtractor#normalize(java.lang.String)}.
	 */
	@Test
	public void testNormalize() {
		System.out.println("* TermExtractorTest: testNormalize()");
		assertEquals("cat", new TermExtractor().normalize("Cat"));
		assertEquals("cat", new TermExtractor().normalize("CAT"));
		assertEquals("cat", new TermExtractor().normalize("cAt"));
	}
}

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
public class TermComparatorATest {

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermComparatorA#compare(com.maxtimv.termfreq.Term, com.maxtimv.termfreq.Term)}
	 * .
	 */
	@Test
	public void testCompare() {
		System.out.println("* TermComparatorATest: testCompare()");
		assertTrue(new TermComparatorA().compare(new Term("cat", 1), new Term(
				"cat", 1)) == 0);
		assertTrue(new TermComparatorA().compare(new Term("cat", 1), new Term(
				"cat", 2)) > 0);
		assertTrue(new TermComparatorA().compare(new Term("cat", 1), new Term(
				"dog", 2)) > 0);
		assertTrue(new TermComparatorA().compare(new Term("cat", 1), new Term(
				"dog", 1)) < 0);
	}
}

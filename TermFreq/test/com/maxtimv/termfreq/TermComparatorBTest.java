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
public class TermComparatorBTest {

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.TermComparatorB#compare(com.maxtimv.termfreq.Term, com.maxtimv.termfreq.Term)}
	 * .
	 */
	@Test
	public void testCompare() {
		System.out.println("* TermComparatorBTest: testCompare()");
		assertTrue(new TermComparatorB().compare(new Term("cat", 1), new Term(
				"cat", 1)) == 0);
		assertTrue(new TermComparatorB().compare(new Term("cat", 1), new Term(
				"cat", 2)) == 0);
		assertTrue(new TermComparatorB().compare(new Term("cat", 1), new Term(
				"dog", 2)) < 0);
		assertTrue(new TermComparatorB().compare(new Term("cat", 1), new Term(
				"dog", 1)) < 0);
	}
}

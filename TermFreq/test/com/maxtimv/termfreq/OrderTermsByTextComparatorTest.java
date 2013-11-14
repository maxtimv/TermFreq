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
public class OrderTermsByTextComparatorTest {

	/**
	 * Test method for
	 * {@link com.maxtimv.termfreq.OrderTermsByTextComparator#compare(com.maxtimv.termfreq.Term, com.maxtimv.termfreq.Term)}
	 * .
	 */
	@Test
	public void testCompare() {
		System.out.println("* OrderTermsByTextComparatorTest: testCompare()");
		assertTrue(new OrderTermsByTextComparator().compare(new Term("cat", 1),
				new Term("cat", 1)) == 0);
		assertTrue(new OrderTermsByTextComparator().compare(new Term("cat", 1),
				new Term("cat", 2)) == 0);
		assertTrue(new OrderTermsByTextComparator().compare(new Term("cat", 1),
				new Term("dog", 2)) < 0);
		assertTrue(new OrderTermsByTextComparator().compare(new Term("cat", 1),
				new Term("dog", 1)) < 0);
	}
}

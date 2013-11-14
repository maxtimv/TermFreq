/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Comparator;

/**
 * A Comparator that orders {@link Term} objects by descending frequency with a
 * secondary sort of ascending alphabetical term.
 * 
 * @author Maxim Timofeev
 * 
 */
public class OrderTermsByFrequencyComparator implements Comparator<Term> {

	/**
	 * Compares two {@link Term} objects for order.
	 */
	@Override
	public int compare(Term t1, Term t2) {
		// First, use descending order on term frequency
		int res = t2.getFrequency() - t1.getFrequency();
		// The same frequencies?
		if (res == 0) {
			// OK, then use ascending order on term text
			res = t1.getText().compareTo(t2.getText());
		}
		return res;
	}
}

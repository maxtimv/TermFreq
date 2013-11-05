/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Comparator;

/**
 * A Comparator that orders <code>Term</code> objects by descending frequency
 * with a secondary sort of ascending alphabetical term.
 * 
 * @author Maxim Timofeev
 * 
 */
public class TermComparatorA implements Comparator<Term> {

	/**
	 * Compares two <code>Term</code> objects for order.
	 */
	@Override
	public int compare(Term t1, Term t2) {
		// First, use descending order on term frequency
		int res = t2.getFrequency() - t1.getFrequency();
		// The same frequencies?
		if (res == 0) {
			// OK, then use ascending order on term text
			res = t1.getText().compareToIgnoreCase(t2.getText());
		}
		return res;
	}
}

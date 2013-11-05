/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Comparator;

/**
 * A Comparator that orders <code>Term</code> objects by ascending alphabetical
 * term.
 * 
 * @author Maxim Timofeev
 * 
 */
public class TermComparatorB implements Comparator<Term> {

	/**
	 * Compares two <code>Term</code> objects for order.
	 */
	@Override
	public int compare(Term t1, Term t2) {
		// Use ascending order on term text
		return t1.getText().compareToIgnoreCase(t2.getText());
	}
}

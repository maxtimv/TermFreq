/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Comparator;

/**
 * A Comparator that orders {@link Term} objects by ascending alphabetical term.
 * 
 * @author Maxim Timofeev
 * 
 */
public class OrderTermsByTextComparator implements Comparator<Term> {

	/**
	 * Compares two {@link Term} objects for order.
	 */
	@Override
	public int compare(Term t1, Term t2) {
		// Use ascending order on term text
		return t1.getText().compareTo(t2.getText());
	}
}

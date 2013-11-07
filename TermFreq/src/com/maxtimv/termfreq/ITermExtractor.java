/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Set;

/**
 * Any TermExtractor class has to implement this interface.
 * 
 * @author Maxim Timofeev
 * 
 */
public interface ITermExtractor {

	/**
	 * Extracts terms from the text.
	 * 
	 * @param text
	 *            the text to extract terms from
	 * @return a {@link Set} of {@link Term} objects
	 */
	public Set<Term> extract(String text);
}

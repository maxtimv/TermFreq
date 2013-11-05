/**
 * 
 */
package com.maxtimv.termfreq;

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
	 * @return an array of Term objects
	 */
	public Term[] extract(String text);
}

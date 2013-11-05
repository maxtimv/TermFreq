/**
 * 
 */
package com.maxtimv.termfreq;

/**
 * This class extends functionality of TermExtractor class. It overrides
 * implementation of normalize function to preserve terms that appear to be
 * acronyms.
 * 
 * @author Maxim Timofeev
 * 
 */
public class TermExtractorAcronym extends TermExtractor {

	/**
	 * Normalizes a token. This implementation preserves acronyms.
	 * 
	 * @param token
	 *            the token to normalize
	 * @return a normalized form of the token
	 */
	@Override
	protected String normalize(String token) {
		return isAcronym(token) ? token : super.normalize(token);
	}

	/**
	 * Indicates whether the token is acronym.
	 * 
	 * @param token
	 *            the token to test
	 * @return true if the token is acronym; false otherwise.
	 */
	protected boolean isAcronym(String token) {
		return (token.length() > 1) && token.equals(token.toUpperCase());
	}
}

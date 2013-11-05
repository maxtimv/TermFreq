/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This implementation of ITermExtractor interface extracts terms from the input
 * text, normalizes them, and returns an array of Term objects in order they
 * appeared in the text.
 * 
 * @author Maxim Timofeev
 * 
 */
public class TermExtractor implements ITermExtractor {

	/**
	 * Extracts terms from the text. Each term is normalized and is provided
	 * with its frequency. This implementation returns an array of Term objects
	 * in order they appeared in the text.
	 * 
	 * @param text
	 *            the text to extract terms from
	 * @return an array of Term objects
	 */
	@Override
	public Term[] extract(String text) {
		// Tokenize the input text
		final String tokens[] = text.split("[^A-Za-z0-9\\.']");
		// Use Map to collect the terms
		Map<String, Term> map = new LinkedHashMap<String, Term>(tokens.length);
		for (String token : tokens) {
			// Ignore empty tokens
			if (token.length() == 0) {
				continue;
			}
			// Remove unwanted characters from the token
			while (token.startsWith("'") || token.startsWith(".")) {
				token = token.substring(1);
			}
			while (token.endsWith("'") || token.endsWith(".")) {
				token = token.substring(0, token.length() - 1);
			}
			// Ignore empty tokens
			if (token.length() == 0) {
				continue;
			}
			// Normalize the token
			final String key = normalize(token);
			// Find term in the Map and increment its frequency
			// Create one if not found
			Term term = map.get(key);
			if (term == null) {
				term = new Term(key);
				map.put(key, term);
			} else {
				term.incFrequency();
			}
		}
		// Return an array of terms
		Collection<Term> terms = map.values();
		return terms.toArray(new Term[0]);
	}

	/**
	 * Normalizes a token. This implementation converts a token to lowercase.
	 * 
	 * @param token
	 *            the token to normalize
	 * @return a normalized form of the token
	 */
	protected String normalize(String token) {
		return token.toLowerCase();
	}
}

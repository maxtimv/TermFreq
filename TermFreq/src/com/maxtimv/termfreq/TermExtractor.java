/**
 * 
 */
package com.maxtimv.termfreq;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This implementation of ITermExtractor interface extracts terms from the input
 * text, normalizes them, and returns a {@link Set} of {@link Term} objects in
 * order they appeared in the text.
 * 
 * @author Maxim Timofeev
 * 
 */
public class TermExtractor implements ITermExtractor {

	/**
	 * Extracts terms from the text. Each term is normalized and is provided
	 * with its frequency. This implementation returns a {@link Set} of
	 * {@link Term} objects in order they appeared in the text.
	 * 
	 * @param text
	 *            the text to extract terms from
	 * @return a {@link Set} of {@link Term} objects
	 */
	@Override
	public Set<Term> extract(String text) {
		// Tokenize the input text
		final String tokens[] = text.split("[^A-Za-z0-9\\.']");
		// Use Map to collect the terms
		Map<String, Term> map = new LinkedHashMap<>(tokens.length);
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
		// Return a set of terms
		return new LinkedHashSet<Term>(map.values());
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

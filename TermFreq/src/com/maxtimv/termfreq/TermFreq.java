/**
 * 
 */
package com.maxtimv.termfreq;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Maxim Timofeev
 * 
 */
public class TermFreq {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		// Set defaults
		ITermExtractor extractor = new TermExtractor();
		Comparator<Term> comparator = null;
		String fileName = null;

		// Process arguments
		for (String arg : args) {
			if ("-acronym".equalsIgnoreCase(arg)
					|| "-acr".equalsIgnoreCase(arg)) {
				extractor = new TermExtractorAcronym();
			} else if ("-sortf".equalsIgnoreCase(arg)
					|| "-sf".equalsIgnoreCase(arg)) {
				comparator = new OrderTermsByFrequencyComparator();
			} else if ("-sortt".equalsIgnoreCase(arg)
					|| "-st".equalsIgnoreCase(arg)) {
				comparator = new OrderTermsByTextComparator();
			} else {
				fileName = arg;
			}
		}

		// No input file?
		if (fileName == null) {
			usage();
			return;
		}

		// Load the file and extract terms
		String text = loadFile(fileName);
		Set<Term> terms = extractor.extract(text);

		// Sort the terms if asked
		if (comparator != null) {
			Set<Term> termsOrdered = new TreeSet<Term>(comparator);
			termsOrdered.addAll(terms);
			terms = termsOrdered;
		}

		// Print results
		System.out.println("Total terms: " + terms.size());
		for (Term t : terms) {
			System.out.println(t);
		}
	}

	/**
	 * Loads the content of the file into a String.
	 */
	private static String loadFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		for (String line = reader.readLine(); line != null; line = reader
				.readLine()) {
			sb.append(line).append(' ');
		}
		reader.close();
		return sb.toString();
	}

	/**
	 * Prints usage instructions
	 */
	public static void usage() {
		System.out.println("Usage: TermFreq [-options] inputFile");
		System.out
				.println("   (lists all terms found in <inputFile> with their frequency)");
		System.out.println();
		System.out.println("where options include:");
		System.out.println("   -acronym | -acr    preserves acronyms");
		System.out.println("   -sortf | -sf       uses sort by frequency");
		System.out.println("   -sortt | -st       uses sort by text");
	}
}

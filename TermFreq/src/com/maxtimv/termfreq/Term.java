/**
 * 
 */
package com.maxtimv.termfreq;

/**
 * @author Maxim Timofeev
 * 
 */
public class Term {

	protected String text;
	protected int frequency;

	/**
	 * Creates a new instance of Term
	 */
	public Term() {
	}

	/**
	 * Creates a new instance of Term with specified text and frequency equal 1
	 * 
	 * @param text
	 *            the value of text
	 */
	public Term(String text) {
		this.text = text;
		frequency = 1;
	}

	/**
	 * Creates a new instance of Term
	 * 
	 * @param text
	 *            the value of text
	 * @param frequency
	 *            the value of frequency
	 */
	public Term(String text, int frequency) {
		this.text = text;
		this.frequency = frequency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Term other = (Term) obj;
		if ((this.text == null) ? (other.text != null) : !this.text
				.equals(other.text)) {
			return false;
		}
		if (this.frequency != other.frequency) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + (this.text != null ? this.text.hashCode() : 0);
		hash = 97 * hash + this.frequency;
		return hash;
	}

	/**
	 * Returns a string representation of the Term object which is a
	 * concatenation of text and frequency
	 * 
	 * @return a string representation of the Term object
	 */
	@Override
	public String toString() {
		return text + "\t" + frequency;
	}

	/**
	 * Increments the value of frequency
	 */
	public void incFrequency() {
		++frequency;
	}

	/**
	 * Get the value of frequency
	 * 
	 * @return the value of frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * Set the value of frequency
	 * 
	 * @param frequency
	 *            new value of frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * Get the value of text
	 * 
	 * @return the value of text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the value of text
	 * 
	 * @param text
	 *            new value of text
	 */
	public void setText(String text) {
		this.text = text;
	}
}

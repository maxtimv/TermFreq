package com.maxtimv.termfreq;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Maxim Timofeev
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ OrderTermsByFrequencyComparatorTest.class,
		OrderTermsByTextComparatorTest.class, TermExtractorAcronymTest.class,
		TermExtractorTest.class })
public class AllTests {

}

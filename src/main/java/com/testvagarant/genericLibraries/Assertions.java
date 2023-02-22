package com.testvagarant.genericLibraries;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions extends Base {
	
	public static void assertequals(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public static void softassert(String actual,String expected) {
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actual, expected);
		sf.assertAll();
	}

}

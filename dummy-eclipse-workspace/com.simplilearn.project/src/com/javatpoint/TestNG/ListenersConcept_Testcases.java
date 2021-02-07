package com.javatpoint.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenersConcept_Testcases {
	
	@Test
	public void testMeantToPass() {
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void testMeantToFail() {
		Assert.assertFalse(true);
		
	}
	
}

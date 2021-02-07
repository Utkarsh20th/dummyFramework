package com.simplelearn.Selenium;

import org.testng.annotations.Test;

public class MultipleProgramsInSameClass_byUsingTestNG_Testannotation {
	
	@Test
	public void displayClassName() {
		System.out.println("******** Output of Class : MultipleProgramsInSameClass_byUsingTestNG_Testannotation ********");
		
	}
	
	@Test
	public void test1() {
		System.out.println("\"Output from method test1()\"");
		
	}
	
	@Test
	public void test2() {
		System.out.println("\"Output from method test2()\"");
		
	}
	

}

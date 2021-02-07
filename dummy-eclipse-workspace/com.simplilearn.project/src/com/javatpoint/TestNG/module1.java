package com.javatpoint.TestNG;

import org.testng.annotations.Test;

public class module1 {
	
	@Test (priority=-1, alwaysRun=true)
	public void displayClassName() {
		System.out.println("******** Output of Class : module1 ********");
		
	}
	
	@Test
	public void test1() {
		System.out.println("test1() output:      Hello JavaTPoint!!!");
		
	}
	
	@Test(enabled=false)
	public void test2() {
		System.out.println("test2() output:      JTP Travels");
		
	}

}

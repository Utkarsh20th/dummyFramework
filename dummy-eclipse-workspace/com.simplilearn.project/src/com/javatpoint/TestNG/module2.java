package com.javatpoint.TestNG;

import org.testng.annotations.Test;

public class module2 {
	
	@Test (priority=-1, alwaysRun=true)
	public void displayClassName() {
		System.out.println("******** Output of Class : module2 ********");
		
	}
	
	@Test
	public void test3() {
		System.out.println("test3() output:      hindi100songs");
		
	}

}

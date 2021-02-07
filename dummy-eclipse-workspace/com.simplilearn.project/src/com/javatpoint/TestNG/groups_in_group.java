package com.javatpoint.TestNG;

import org.testng.annotations.Test;

public class groups_in_group {
	
	@Test //(priority=-1, alwaysRun=true, groups = {"Smoke", "Regression", "Others"})
	public void displayClassName() {
		System.out.println("******** Output of Class : groups_in_group ********");
		
	}
	
	@Test (dependsOnMethods = {"B", "C"}) //(dependsOnMethods = {"Smoke"}, description="This is a description")
	public void A() {
		System.out.println("Output from \t : \t A() -- Smoke Group");
		
	}
	
	@Test //(groups = {"Regression"})
	public void B() {
		System.out.println("Output from \t : \t B() -- Regression Group");
		
	}
	
	@Test //(groups = {"Others"})
	public void C() {
		System.out.println("Output from \t : \t C() -- Others Group");
		
	}

}

package com.javatpoint.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Vegetables {
	
	@Test
	@Parameters ("vinput1")
	public void vegetable1(String m) {
		System.out.println("Vegetable 1 name is \t : \t "+m);
		
	}
	
	@Test
	@Parameters ("vinput2")
	public void vegetable2(String n) {
		System.out.println("Vegetable 2 name is \t : \t "+n);
		
	}
	
}

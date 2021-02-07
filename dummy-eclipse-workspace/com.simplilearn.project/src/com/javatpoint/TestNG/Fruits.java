package com.javatpoint.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Fruits {
	
	@Test
	@Parameters ({"finput1", "finput2"})
	public void fruit1(String a, String b) {
		System.out.println("Fruit 1s name are \t : \t "+a+" & "+b);
		
	}
	@Test
	@Parameters ("finput3")
	public void fruit2(String c) {
		System.out.println("Fruit 2 name is \t : \t "+c);
		
	}
	
}

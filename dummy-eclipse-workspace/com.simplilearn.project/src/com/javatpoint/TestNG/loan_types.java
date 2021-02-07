package com.javatpoint.TestNG;

import org.testng.annotations.Test;

public class loan_types {
	
	@Test (priority=-1, alwaysRun=true)
	public void displayClassName() {
		System.out.println("******** Output of Class : loan_types ********");
		
	}
	
	@Test
	public void Web_Login_CarLoan() {
		System.out.println("Web_Login_CarLoan() output     :     Website for Car loan");
		
	}
	
	@Test
	public void Mobile_Login_CarLoan() {
		System.out.println("Mobile_Login_CarLoan() output     :     Mobile for Car loan");
		
	}
	
	@Test
	public void Mobile_Login_PersonalLoan() {
		System.out.println("Mobile_Login_PersonalLoan() output     :     Mobile for Personal loan");
		
	}
	
	@Test
	public void Mobile_Login_HomeLoan() {
		System.out.println("Mobile_Login_HomeLoan() output     :     Mobile for Home loan");
		
	}
	
	@Test
	public void API_Login_CarLoan() {
		System.out.println("API_Login_CarLoan() output     :     API for Car loan");
		
	}

}

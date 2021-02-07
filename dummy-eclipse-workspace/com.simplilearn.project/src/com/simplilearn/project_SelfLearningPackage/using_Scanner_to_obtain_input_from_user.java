package com.simplilearn.project_SelfLearningPackage;

import java.util.Scanner;

public class using_Scanner_to_obtain_input_from_user {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter name:");
		String acceptName = inp.next();
		
		int a=0;
		System.out.println(a);
		
		System.out.println("User has entered name: "+acceptName);

	}

}

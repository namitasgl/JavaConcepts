/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

package General;

public class staticVariableScenario {
	
	/*
	 * static variable can be accessed from class reference whether the class has been instantiated
	 * or not
	 */
	static String Name = "Namita";
	String surName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staticVariableScenario object = null;
		
		/*
		 * when user use the static variable from object reference a warning is generated
		 */
		System.out.println(object.Name);
		
		/*
		 * surName is object variable, when object is not instantiated, 
		 * the object variables are not created in the memory and they are not initialized 
		 * Hence if user tries to access object variable before instantiation 
		 * this will lead to null pointer exception
		 * 
		 * For implementation, uncomment the below statement
		 */
		
		System.out.println(object.surName);
	}

}

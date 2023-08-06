/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

/**
 * 
 */
package General;

/**
 * @author engin
 *
 */
public class finallywithReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		finallywithReturn object = new finallywithReturn();
		System.out.println("***************Finally scenario with Return scenario*****************************");
		System.out.println("Result from block :" +object.getResult());
		System.out.println("***************Finally scenario with system.exit() scenario****************************");
		System.out.println("Result from block :" +object.getResultInSystemExit());
	}
	
	/*
	 * Finally block always execute whether we do anything in catch block exception in 2 cases :
	 * Error , system.exit() 
	 */
	String getResult() {
		try {
			int result = 10/0; // results in arithmetic exception
			return "result";
		} catch ( ArithmeticException exp 
				) {
			System.out.println("inside Arithemtic Exception");
			return "catch block";
		}finally {
			/*
			 * Finally block always execute except error and memory out exception
			 */
			System.out.println("inside Finally block");
			return "finally block";
		}
	}
	
	/*
	 * Finally block will not execute when user manually exit the system in catch block.
	 */
	String getResultInSystemExit() {
		try {
			int result = 10/0; // results in arithmetic exception
			return "result";
		} catch ( ArithmeticException exp 
				) {
			System.out.println("inside Arithemtic Exception");
			// exit scenario
			System.exit(0);
			return "catch block";
		}finally {
			/*
			 * Finally block always execute except error and memory out exception
			 */
			System.out.println("inside Finally block");
			return "finally block";
		}
	}

}

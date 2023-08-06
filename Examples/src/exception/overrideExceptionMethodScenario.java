/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

package exception;

/**
 * @author engin
 *
 */
import java.io.FileNotFoundException;
import java.io.IOException;

public class overrideExceptionMethodScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		secondClassStudentInfo namitaSehgal = new secondClassStudentInfo();
		namitaSehgal.name();
	}

}

class student {
	protected void name() throws FileNotFoundException {
		
	}
	
	void rollNumber() throws IOException {
		
	}
}

class secondClassStudentInfo extends student {
	/**
	 * While overriding the method the child class can remove exception at all 
	 * 2nd we can not reduce the visibility of method in child class
	 * Although we can increase the visibility such as private > protected > public
	 */
	public void name() throws NullPointerException {
		
	}
	
	/**
	 * When user override the method user can change the exception with its subclass 
	 * or same type i.e Checked Exception with Checked Exception 
	 * if user change the exception with its parent class exception or other Exception type 
	 * Then the change is in compatible
	 * 
	 * Uncomment the below method for compile time error
	 */
	
	/*
	 * void rollNumber() throws Exception {
	 * 
	 * }
	 */
}

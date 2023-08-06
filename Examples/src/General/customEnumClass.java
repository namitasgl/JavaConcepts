/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */
package General;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author engin
 *
 */
public class customEnumClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Car brand name :"+car.Hundai);
		car MarutiCarInfo = car.valueOf("Maruti");
		System.out.println("Car brand name :"+MarutiCarInfo);
		ArrayList<String> MarutiCarList = MarutiCarInfo.carName;
		System.out.println(" Maruti Cars :"+MarutiCarList);
		
		// print all the cars of MAruti via stream
		MarutiCarList.stream().forEach(name -> System.out.println(name));
		
		//count number of cars
		System.out.println("Number of Maruti Cars :" +MarutiCarList.stream().filter(name -> !name.isEmpty()).count());
		
	}

}

enum car {
	Hundai(new ArrayList<String>(Arrays.asList("I10","Magna","I20","Creta"))),
	Maruti(new ArrayList<String>(Arrays.asList("Alto","Swift","Desire"))),
	Tata(new ArrayList<String>(Arrays.asList("Nexo","Indigo")));
	
	public ArrayList<String> carName;
	
	car(ArrayList<String> name) {
		carName = name;
	}
}

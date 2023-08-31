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
package Java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author engin
 *
 */
public class programming1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String separator = "-----------------------------------------------------------------------------------------";
		int limit = 5;
		/*
		 *  print fibonacci series 
		 */
		System.out.println(" Print fibonacci series via Stream ?");
		Stream.iterate(new Integer[] {0,1}, first -> new Integer[] {first[1], first[0]+first[1]}).limit(limit).mapToInt(val -> val[0]).forEach( System.out::print);
		System.out.println("\n"+separator);
		
		/*
		 * print even numbers
		 */
		System.out.println(" Print even numbers via stream i");
		Stream.iterate(0, n -> n+2).limit(limit).forEach(System.out::print);
		System.out.println("\n"+separator);
		
		/*
		 * sort the list in parallel with stream ?
		 */
		System.out.println("sort the list parallel thread?");
		int input[] = {1,9,45,23,4,0,-78,5,11,6};
		// Arrays util for parallel sort
		Arrays.parallelSort(input);
		Arrays.stream(input).forEach(value ->System.out.print(" "+value +" "));
		System.out.println("\n"+separator);
		
		//other way
		System.out.println("sort the list in parallel with stream ?");
		int input1[] = {1,9,45,23,4,0,-78,5,11,6};
		Arrays.stream(input1).parallel().sorted().forEachOrdered(value ->System.out.print(" "+value +" "));
		System.out.println("\n"+separator);
	}

}
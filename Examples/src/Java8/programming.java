/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class programming {

	public static void main(String[] args) {
		
		String separator = "-----------------------------------------------------------------------------------------";
		
		/*
		 * Given a list of integers, 
		 * find out all the even numbers that exist in the list using Stream functions?
		 */
		
		ArrayList<Integer> listofInt = new ArrayList<>(Arrays.asList(3,8,7,90,78,56,34,12));
		System.out.println("find out all the even numbers that exist in the list using Stream functions");
		System.out.println(listofInt);
		ArrayList<Integer> evenNumberList = (ArrayList<Integer>)listofInt.stream().filter( value -> value%2 == 0).collect(Collectors.toList());
		//evenNumberList.stream().forEach(System.out::println);
		System.out.println("Result : "+evenNumberList);
		System.out.println(separator);
		
		/*
		 * Given a list of integers,
		 * find out all the numbers starting with 1 using Stream functions?
		 * 
		 */
		
		ArrayList<Integer> listofInt1 = new ArrayList<>(Arrays.asList(3,18,7,90,78,56,34,12,22,1,91,34,55));
		System.out.println("find out all the numbers starting with 1 using Stream functions ");
		System.out.println(listofInt1);
		Predicate<String> matcher = value -> value.startsWith("1");
		ArrayList<String> listVdMatch = (ArrayList<String>) listofInt1.stream().map(value -> value+ "").filter(matcher).collect(Collectors.toList());;
		//listVdMatch.stream().forEach(System.out::println);
		System.out.println("Result :"+listVdMatch);
		System.out.println(separator);
		
		
		/*
		 *  How to find duplicate elements in a given integers list 
		 *  in java using Stream functions?
		 */
		ArrayList<Integer> listofInt2 = new ArrayList<>(Arrays.asList(34,18,7,90,78,18,12,22,1,34,34,55));
		System.out.println("How to find duplicate elements in a given integers list in java using Stream functions? ");
		System.out.println(listofInt2);
		HashSet<Integer> duplicateValues = new HashSet<>();
		ArrayList<Integer> listofDuplicate = (ArrayList<Integer>) listofInt2.stream().filter(value -> !duplicateValues.add(value)).distinct().collect(Collectors.toList());
		listofDuplicate.stream().forEach(System.out::println);
		//System.out.println("Result :"+listofDuplicate);
		System.out.println(separator);
		
		/*
		 * Given the list of integers, 
		 * find the first element of the list using Stream functions?
		 */
		ArrayList<Integer> listofInt3 = new ArrayList<>(Arrays.asList(34,18,7,90,78,18,12,22,1,34,34,55));
		System.out.println("find the first element of the list using Stream functions? ");
		System.out.println(listofInt3);   
		Optional<Integer> data = listofInt3.stream().findFirst();
		/*
		 * if(data.isPresent()) { System.out.println("Value Present :"+ data.get()); }
		 */
		 data.ifPresent(System.out :: println);
		 System.out.println(separator);
		 
		 
		 /*
		  * Given a list of integers, 
		  * find the total number of elements present in the list using Stream functions?
		  */
		 ArrayList<Integer> listofInt4 = new ArrayList<>(Arrays.asList(34,18,7,90,78,18,12,22,1,34,34,55));
			System.out.println("find the total number of elements present in the list using Stream functions? ");
			System.out.println(listofInt);
			long totalCount = listofInt4.stream().count();
			System.out.println(totalCount);
			System.out.println(separator);
			
			/*
			 * Given a list of integers, 
			 * find the maximum value element present in it using Stream functions?
			 */
			ArrayList<Integer> listofIntVal = new ArrayList<>(Arrays.asList(34,18,7,-98098,90,78,18,12,22,1,34,34,555));
			System.out.println("find the maximum value element present in it using Stream functions? ");
			System.out.println(listofIntVal);
			/*
			 *  orElse - when in optional null value is expected this help to set default data in null case
			 */
			int maxValue = listofIntVal.stream().max(Integer::compare).orElse(0); 
			int maxValue1 = listofIntVal.stream().max(Comparator.reverseOrder()).orElse(0);
			System.out.println("maxValue :"+maxValue + " maxValue reverse order :"+ maxValue1);
			System.out.println(separator);
			
			
			/*
			 * Given a String, 
			 * find the first non-repeated character in it using Stream functions?
			 */
			System.out.println("find the first non-repeated character in it using Stream functions? ");			
			String input = "Java articles are Awesome";
			System.out.println(input);
			HashMap<Character, Long> data1 = (HashMap<Character,Long>)input.chars().mapToObj(val -> Character.toLowerCase(Character.valueOf((char)val))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			data1.entrySet().stream().forEach(System.out::println);
			Optional result =data1.entrySet().stream().filter(val -> val.getValue()==1).map(val -> val.getKey()).findFirst();
			if(result.isPresent()) {
				System.out.println("Result :"+result.get());
			}
			System.out.println(separator);
			
			
			/*
			 * Given a String, 
			 * find the all non-repeated character in it using Stream functions?
			 */
			System.out.println("find the all non-repeated character in it using Stream functions");			
			System.out.println(input);
			ArrayList resultAll =(ArrayList)data1.entrySet().stream().filter(val -> val.getValue()==1).map(val -> val.getKey()).collect(Collectors.toList());
			System.out.println("Result :"+resultAll);			
			System.out.println(separator);
			
			/*
			 * Given a String, 
			 * find the first repeated character in it using Stream functions?
			 */
			System.out.println("find the first repeated character in it using Stream functions");			
			System.out.println(input);
			Optional<Character> resultFirstRepeated =data1.entrySet().stream().filter(val -> val.getValue()!=1).map(val -> val.getKey()).findFirst();
			System.out.println("Result :"+resultFirstRepeated);			
			System.out.println(separator);
			
			
			/*
			 * Given a String, 
			 * find the all repeated character in it using Stream functions?
			 */
			System.out.println("find the all repeated character in it using Stream functions");			
			System.out.println(input);
			ArrayList resultAllRepeated =(ArrayList)data1.entrySet().stream().filter(val -> val.getValue()!=1).map(val -> val.getKey()).collect(Collectors.toList());
			System.out.println("Result :"+resultAllRepeated);			
			System.out.println(separator);
			
			/*
			 * Given a String, 
			 * find the max word in a sentence using Stream functions?
			 */
			String input1 ="Hello mysel1f Namita Sehgal myself";
			System.out.println("find the max word in a sentence using Stream functions?");
			System.out.println(input1);
			List<String> inputOfString = Arrays.asList(input1.split(" "));
			System.out.println(inputOfString);
			// 2 ways to fetch the max word
			// ist way
			HashMap<String, Integer> resultofString = (HashMap)inputOfString.stream().collect(Collectors.toMap(Function.identity(),value -> ((String) value).length(), (first,second )-> first));
			/*
			 * Function.Identity() - return what comes as an input
			 *  to avoid duplicate key - provide merge function - how the duplicate should be handled. in this scenario it is handled by taking first
			 */
			Optional resultofString1 = resultofString.entrySet().stream().map( value -> value.getValue()).max(Integer::compare);
			resultofString1.ifPresent( val -> System.out.println (" word :"+ val));
			// 2nd way
			Optional value1=    inputOfString.stream().distinct().max(Comparator.comparingInt(value -> value.length()));
			value1.ifPresent(val -> System.out.println(" value :"+ value1.get() +" length :" +((String)value1.get()).length()));
			
	}

}

/**
 * Copyright Namita Sehgal 2024
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

package General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class interviewCodingProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Array list will be given find the max Consecutive index whose sum is 20");
		/* Array list will be given find the max Consecutive index whose sum is given 
		*	Array = {4, 5, 7, 11, 9, 13, 8, 12}
		* Sum = 20 
		**/
		
		int list[]= {4,5,11,9,13,8,12};
		int Sum = 20;
		for (int i=0 ; i< list.length; i++) {
			//int[] entry = new int[list.length];
			ArrayList<Integer> entry= new ArrayList<Integer>();
	       // int count =0;
	        int entrySum=0;
	        for(int j=i; j< list.length && entrySum <= Sum;j++){
	            entrySum = entrySum+ list[j];
	           // entry[count] = j;	            
	           entry.add(j);
	            if( entrySum == Sum){
	                System.out.println(" Consecutive indexes whose sum is 20 : " +entry);               
	                break;
	            }
	        }	        
	    }
		
		/* Array list will be given find the max Consecutive index whose sum is given 
		*	Array = {15,-2,2,-8,1,7,10,23};
		* Sum = 0 
		**/
		
		System.out.println("Array list will be given find the max Consecutive index whose sum is 0 ");	
int A[] = {15,-2,2,-8,1,7,10,23};
		
		
		for(int i = 0 ; i< A.length; i++) {
			int sum=0;
			List indexes = new ArrayList<Integer>();
			for(int j = i; j <A.length; j++) {
				sum = sum + A[j];
				//System.out.println(sum);
				indexes.add(j);
				if(sum == 0) {
					System.out.println("Consecutive index whose sum is 0 :"+indexes);
					//break;
				}
			}
		}
		
		/*
		 * 2 Strings are given find the common character and the total occurance of the character
		 */
	
	
	System.out.println("2 Strings are given find the common character and the total occurance of the character");
	String first = "namita";
	String second = "akshay";
	
	/*
	 * Count the total occurance of common character in both strings e.g a =4
	 * 
	 */
	
	Map<String, Integer> firstOccurance = occuranceOfName(first);
	Map<String, Integer> secondOccurance = occuranceOfName(second);
	
	
	int lengthOfFirstOccurance = firstOccurance.size();
	int lengthOfSecondOccurance = secondOccurance.size();
	if(lengthOfFirstOccurance >= lengthOfSecondOccurance) {
		displaymatchingCharacter(firstOccurance,secondOccurance );
		
	}
	else {
		displaymatchingCharacter(secondOccurance, firstOccurance);
		
	}
	
	
	
}
static void displaymatchingCharacter(Map<String, Integer> firstOccurance, Map<String, Integer> secondOccurance) {
	
	
	for(Map.Entry<String,Integer> entryset:   secondOccurance.entrySet()) {
		String key =entryset.getKey();
		if (firstOccurance.containsKey(key))
		{
			int count = secondOccurance.get(key);
			count = count + firstOccurance.get(key);
			System.out.println(" Common character :"+ key + " Count :"+ count);
		}
		
	}
}

static Map<String, Integer> occuranceOfName(String name) {
Map<String, Integer> firstOccurnace = new HashMap<>();
	
	for(int i=0 ; i<  name.length();i++) {
		if(firstOccurnace.containsKey(String.valueOf(name.charAt(i)))) {
			int count = firstOccurnace.get(String.valueOf(name.charAt(i)));
			firstOccurnace.put(String.valueOf(name.charAt(i)), count+1);
		}
		else
			firstOccurnace.put( String.valueOf(name.charAt(i)), 1);
	}		
	return firstOccurnace;
}
}



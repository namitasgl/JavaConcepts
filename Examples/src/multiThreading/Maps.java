/**
 * Copyright Namita Sehgal 2024
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

package multiThreading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*
 * Understanding of Fail safe vs Fail fast with the implementation of Data structure
 */
public class Maps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Concurrent HashMap is fail safe - No exception is observed when user update the map while iterating over it.
		Map<String,String> myMap = new ConcurrentHashMap<>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: "+myMap);
		Iterator<String> it = myMap.keySet().iterator();
		myMap.put("namita", "1");
		while(it.hasNext()){
			String key = it.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
			if(key.equals("1")) myMap.put(key, "new1");
		}
		System.out.println("ConcurrentHashMap after iterator: "+myMap);

		//HashMap is fail fast- Modification exception when user update the map while iterating over it.
		myMap = new HashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("HashMap before iterator: "+myMap);
		Iterator<String> it1 = myMap.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			//if(key.equals("3")) myMap.put(key+"new", "new3");  // Uncomment this line for modification exception issue
		}
		System.out.println("HashMap after iterator: "+myMap);
		
		/*
		 * Modification exception is trigger - We have taken the set of keys from HashMap and then iterating over it. HashMap contains 
		 * a variable to count the number of modifications and iterator use it when you call its next() function to get the next entry.
		 * When the count has changed it raised the Modification exception.
		 * To avoid the modification exception in the HashMap, Once the new element is added break the statement after the put call 
		*/
		
		Iterator<String> it2 = myMap.keySet().iterator();
		while(it2.hasNext()){
			String key = it2.next();
			if(key.equals("3")) {
				myMap.put(key+"new", "new3");
			break;
			}
		}
		System.out.println("HashMap after adding new key in the iterator: "+myMap);
		
		/*
		 * While iterating the hashmap when user update the existing key value then no modification exception is triggered, 
		 * because the count has not changed.
		 */
		Iterator<String> it3 = myMap.keySet().iterator();
		while(it3.hasNext()){
			String key = it3.next();
			if(key.equals("6")) {
				myMap.put(key, "new3");
						}
		}
		System.out.println("HashMap after updating the value in existing map in the iterator: "+myMap);
		
	}

}

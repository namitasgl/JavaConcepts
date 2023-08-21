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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author engin
 *
 */
public class serializableScenarion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pending
		System.out.println("hello");
	}
}

/*
 * When class is used as a reference variable
 * It must implement the serializable markup class, 
 * when user try to serialize all reference variable of object ,
 * It will be break on non serialized class. Hence NotSerializableException is thrown
 */
class location implements Serializable 
{
	String cityName;
	String state;
	
	public location(String cityName, String state) {
		super();
		this.cityName = cityName;
		this.state = state;
	}

	@Override
	public String toString() {
		return "location [cityName=" + cityName + ", state=" + state + "]";
	}	
}

/*
 * Class with non serialized marker
 */
class demo implements Serializable
{
	public demo() {
		System.out.println("Default Constructor demo");
	}
}


/*
 * When class is used as parent with Serializable marker and 
 * child class is created without serializable marker, the child inherit the same mechanism
 * and serialize and deserialze the object
 * When class is used as parent without serializable marker and child has serializable marker,
 * The child class data is serialized and from parent calss the default constructor is initiated for object creation
 */
class blueprint extends demo //implements Serializable 
{
	int walls;
	int windows;
	
	public blueprint(int walls, int windows) {
		super();
		this.walls = walls;
		this.windows = windows;
	}

	@Override
	public String toString() {
		return "blueprint [walls=" + walls + ", windows=" + windows + "]";
	}

	public blueprint() {
		System.out.println(" Default blueprint constructor");
	}	
}


/*
 * When class is used as a reference variable 
 * It must implement the serializable when the class implements Serializable
 * When object try to serialize the object and all reference variables, It will break at non serializable reference variable.
 * Hence NOTSeriablizableException is thrown
 */
class house1 extends blueprint implements Serializable {
	/*
	 * static variable does not serialized and persist
	 * When user try to deserialized the variable,
	 * The current static variable value will be assigned to static variable
	 */
	static String street;
	
	/*
	 * transient variable does not serialized and persist
	 * When user try to deserialized the variable,
	 * as per variable data type the default value is assigned 
	 */
	transient int houseNumber;
	/*
	 * reference variable must be serialized
	 * else NOTSerializableException is thrown
	 */
	location loc;
	
	public house1(int walls, int windows, int houseNumber, location loc, String street) {
		super(walls, windows);
		this.street = street;
		this.houseNumber = houseNumber;
		this.loc = loc;
	}

	public house1() {
		System.out.println("House1 Default constructor");
	}

	@Override
	public String toString() {
		return "house1 [houseNumber=" + houseNumber + ", loc=" + loc + "]";
	}
	
	
	/*
	 * customize serialization can be done by creating
	 * writeObject and readObjcet method
	 * JVM will use these methods for serialization process
	 * 
	 * usage - for validation after deserialization
	 * 			for some pre-post processing after default serialization
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		System.out.println("writting the object");
		 
		stream.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
		System.out.println("reading the object");
		
		stream.defaultReadObject();

	}
	
}


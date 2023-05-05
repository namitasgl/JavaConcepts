package General;

public class cloneableInterfaceScenario {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		address address = new address(123, "Nangal");
		address address2 = new address(867, "Delhi");
		
		house NamitaHouse = new house("Namita", 1989, address);
		System.out.println(NamitaHouse);
		
		house GaganHouse = new house("Gagan", 1987, address2);
		System.out.println(GaganHouse);
		
		house AravHouse = (house) NamitaHouse.clone();
		System.out.println("Arav House :"+ AravHouse);
		
		AravHouse.getAdd().setHouseNo(999);
		AravHouse.getAdd().setStreetNo("Delhi");
		
		System.out.println("Arav House after update :"+ AravHouse);
		System.out.println("Namita House after cloning :"+ NamitaHouse);		 
		
	}
}


class address {
	int houseNo;
	String streetNo;
	
	public address( address addressObj) {
		this.houseNo = addressObj.houseNo;
		this.streetNo = addressObj.streetNo;
	}
	
	public address(int houseNo, String streetNo) {
		super();
		this.houseNo = houseNo;
		this.streetNo = streetNo;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	@Override
	public String toString() {
		return "address [houseNo=" + houseNo + ", streetNo=" + streetNo + "]";
	}
		
}

/**
 * 
 * Cloneable is a marker interface
 * No method is given inside the interface
 * This interface indicate to compiler at runtime to handle it differently
 * In below scenario it will copy the object
 * 
 */
class house implements Cloneable {
	String name;
	int year;
	
	/**
	 * Object cloning is different:
	 * In default mechanism it gives the reference of the class variables.
	 * The immutable variables cannot be modified but mutable variables 
	 * can be modified when reference is given in the default cloning.
	 * Which results in data corruption
	 */
	address add;

	public house(String name, int year, address add) {
		super();
		this.name = name;
		this.year = year;
		this.add = add;
	}

	public address getAdd() {
		return add;
	}

	public void setAdd(address add) {
		this.add = add;
	}
	
	/**
	 * 
	 * Solution of cloning mutable object is to create copy of the mutable objects
	 * Pass the copied object in cloning
	 * 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object obj = super.clone();
		house houseObj = (house) obj;
		address addressCopyObj = new address(houseObj.getAdd());
		houseObj.setAdd(addressCopyObj);
		return (Object) houseObj;
	}

	@Override
	public String toString() {
		return "house [name=" + name + ", year=" + year + ", add=" + add + "]";
	}
	
	
}


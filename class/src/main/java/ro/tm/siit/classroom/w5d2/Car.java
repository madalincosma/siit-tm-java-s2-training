package ro.tm.siit.classroom.w5d2;

/**
 * It creates a Car abstraction with relevant data and operation.
 * 
 * @author mco
 *
 */
public class Car {

	/**
	 * keeps fuel level
	 */
	public int fuelLevel;

	/**
	 * flag that sets car open
	 */
	public boolean open;

	/**
	 * the key that opens the car
	 */
	public String realKey = "abcd";

	/**
	 * starts the car
	 */
	public void start() {

		System.out.println("//start by turn key");

		while (fuelLevel > 0) {
			// do something
			fuelLevel--;

		}

	}

	/**
	 * opens the car if the car key is valid
	 * 
	 * @param carKey
	 *            the car key
	 */
	public void open(String carKey) {

		System.out.println("open car");
		if (realKey.equals(carKey)) {
			open = true;
		}
	}

}

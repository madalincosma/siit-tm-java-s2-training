package ro.tm.siit.classroom.w4d2.carperson2;

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
	public String realKey;

	/**
	 * starts the car
	 */
	public void start() {

		while (fuelLevel > 0) {
			// do something
			fuelLevel--;

		}

	}

	/**
	 * opens a car with supplied key
	 * @param carKey the key
	 */
	public void open(String carKey) {
		if (realKey.equals(carKey)) {
			open = true;
		}
	}

}

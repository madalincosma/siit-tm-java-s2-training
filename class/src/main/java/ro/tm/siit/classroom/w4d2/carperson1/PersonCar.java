package ro.tm.siit.classroom.w4d2.carperson1;

/**
 * PersonCar class models a person with a car. If offers both behavior from a
 * person and from a car.
 * 
 * @author mco
 *
 */
public class PersonCar {

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
	 * the name of the car; used as identifier also
	 */
	public String name;

	/**
	 * the cra key owned by the person
	 */
	public String carKey;

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
	 * opens the car
	 * 
	 * @param data
	 *            the car to be opened
	 */
	public void open() {
		if (realKey.equals(carKey)) {
			open = true;
		}
	}

	/**
	 * opens the car
	 * 
	 */
	public void openCar() {
		open();
	}

	/**
	 * @return a String containing the name of the person
	 */
	public String getName() {
		return name;
	}

}

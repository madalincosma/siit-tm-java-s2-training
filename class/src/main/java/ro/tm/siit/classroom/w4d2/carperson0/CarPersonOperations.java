package ro.tm.siit.classroom.w4d2.carperson0;

/**
 * CarPerson data class exposes operations to help model a person with a car.
 * 
 * @author mco
 *
 */
public class CarPersonOperations {

	/**
	 * starts a car contained in supplied parameter
	 * 
	 * @param data
	 *            the car to be started
	 */
	public void start(CarPersonData data) {
		while (data.fuelLevel > 0) {
			// do something
			data.fuelLevel--;

		}
	}

	/**
	 * opens a car contained in supplied parameter
	 * 
	 * @param data
	 *            the car to be opened
	 */
	public void open(CarPersonData data) {
		if (data.realKey.equals(data.carKey)) {
			data.open = true;
		}
	}

	/**
	 * opens a car contained in supplied parameter
	 * 
	 * @param data
	 *            the car to be opened
	 */
	public void openCar(CarPersonData data) {
		open(data);
	}

	/**
	 * returns the name of the person contained in supplied parameter
	 * 
	 * @param data
	 *            the person
	 * @return a String containing the name of the person
	 */
	public String getName(CarPersonData data) {
		return data.name;
	}

}

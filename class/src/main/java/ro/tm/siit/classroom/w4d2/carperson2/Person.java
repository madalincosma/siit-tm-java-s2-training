package ro.tm.siit.classroom.w4d2.carperson2;

/**
 * It creates a Person abstraction with relevant data and operation.
 * 
 * @author mco
 *
 */
public class Person {

	/**
	 * the name of the person
	 */
	private String name;

	/**
	 * the car key that he holds
	 */
	private String carKey;

	/**
	 * the car he owns
	 */
	private Car car;

	/**
	 * this person opens his car
	 * 
	 */
	public void openCar() {
		car.open(carKey);
	}

	/**
	 * @return a String containing the name of the person
	 */
	public String getName() {
		return name;
	}

}

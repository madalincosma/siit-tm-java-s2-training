package ro.tm.siit.classroom.w5d2;

import java.util.List;

/**
 * Person abstraction.
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
	 * the list of children he has
	 */
	private List<Person> children;

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
	
	/**
	 * the method allows a person to buy a car.
	 * @param newCar the acquired car
	 */
	public void buyCar(Car newCar) {
		this.car = newCar;
	}
	
	/**
	 *
	 * @return the children as a list of Persons
	 */
	public List<Person> getChildren() {
		return children;
	}
	
	/**
	 * tells if the person has children
	 * @return
	 */
	public boolean hasChildren() {
		return children.size() > 0;
	}

}

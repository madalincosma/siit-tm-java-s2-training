package ro.tm.siit.classroom.w7d1.person2initorder;

/**
 * The Person class models a person having an age.
 * 
 * @author mco
 *
 */
public class Person {

	/**
	 * default age for a person
	 */
	private int age = 23;

	/**
	 * default constructor for class Person
	 */
	// needs explicit implementation due to another constructor existence
	public Person() {
	}

	/**
	 * Constructor for Person class that allows person age.
	 * @param age the age of the person to be created
	 */
	public Person(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.age + "";
	}

	/**
	 * sets the persons age
	 * 
	 * @param age
	 *            the age
	 */
	public void setAge(int age) {
		this.age = age;
	}

}

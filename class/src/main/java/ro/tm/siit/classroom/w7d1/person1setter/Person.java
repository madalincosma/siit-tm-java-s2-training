package ro.tm.siit.classroom.w7d1.person1setter;

/**
 * The Person class models a person having an age.
 * @author mco
 *
 */
public class Person {
	
	/**
	 * default age for a person
	 */
	private int age = 23;

	@Override
	public String toString() {		
		return this.age + ""; 
	}
	
	/**
	 * sets the persons age
	 * @param age the age
	 */
	public void setAge(int age) {
		this.age = age;
	}

}

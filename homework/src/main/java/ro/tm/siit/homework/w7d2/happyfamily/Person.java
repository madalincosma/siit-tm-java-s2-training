package ro.tm.siit.homework.w7d2.happyfamily;

/**
 * The Person class models a person.
 * 
 * @author mco
 *
 */
public class Person {

	/**
	 * person's name
	 */
	private String name;

	/**
	 * person's age
	 */
	private int age;

	/**
	 * relationship status of person
	 */
	protected boolean coupled;

	/**
	 * marital status of person
	 */
	protected boolean married;
	
	/**
	 * the last grade got in school
	 */
	private byte lastGrade; 

	/**
	 * Constructor for Person class that allows person name and age.
	 * 
	 * @param name
	 *            the name of the person to be created
	 * @param age
	 *            the age of the person to be created
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * check if person is happy
	 * 
	 * @return false
	 */
	public boolean isHappy() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.getName() + " happy: " + isHappy() + " at " + getAge();
	}
	
	/**
	 * add a new grade
	 * @param grade the grade
	 */
	public void addGrade(byte grade) {
		this.lastGrade = grade;
	}

	/**
	 * get person's name
	 * 
	 * @return person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get person's age
	 * 
	 * @return person's age
	 */
	protected int getAge() {
		return age;
	}
	
	/**
	 * this person gets married.
	 */
	public void marry() {
		this.coupled = true;
		this.married = true;
	}
	
	/**
	 * this person makes a girlfriend; not implemented
	 */
	public void makeGirlfriend() {	
	}

	/**
	 * checks if the last grade is higher than 7
	 * @return true if it has good grades
	 */
	protected boolean hasGoodGrades() {
		return lastGrade > 7;
	}

	public boolean isSingle() {
		return age > 18 && married;
	}
}
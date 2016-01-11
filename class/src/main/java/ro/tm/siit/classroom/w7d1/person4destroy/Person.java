package ro.tm.siit.classroom.w7d1.person4destroy;

/**
 * The Person class models a person having an age and a name; it also use
 * finalize() hook to display info about the destroyed object.
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
	 * the name of the person
	 */
	private String name;

	/**
	 * default constructor for class Person; sets the name to anonymous and age
	 * to 23
	 */
	// needs explicit implementation due to another constructor existence
	public Person() {
		this("anonymous");
	}

	/**
	 * Constructor for Person class that creates persons with a name and age 23
	 * 
	 * @param name
	 *            the name of the person
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Constructor for Person class that allows person age; it also sets the
	 * name to anonymous
	 * 
	 * @param age
	 *            the age of the person to be created
	 */
	public Person(int age) {
		this();
		this.age = age;
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

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("destroying" + this);
	}

	@Override
	public String toString() {
		return this.age + " " + name;
	}

}

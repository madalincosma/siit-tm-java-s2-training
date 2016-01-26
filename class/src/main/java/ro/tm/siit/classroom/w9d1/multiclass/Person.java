package ro.tm.siit.classroom.w9d1.multiclass;

/**
 * The Person class is modeling a human.
 * @author mco
 *
 */
public class Person {

	/**
	 * the name of the person
	 */
	private String name;
	
	/**
	 * The constructor for Person allowing to set a name
	 * @param name the name
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * people talking
	 */
	public void talk() {
	}
	
	/**
	 * creates a man with name
	 * @param name the name
	 * @return a Person object
	 */
	public static Person createMan(String name) {
		return new Man(name);
	}
	
	/**
	 * creates a woman with name
	 * @param name the name
	 * @return a Person object
	 */
	public static Person createWoman(String name) {
		return new Man(name);
	}
	
	@Override
	public String toString() {
		return "My name is " + name;
	}

}

/**
 * The Woman class extends Person class to implement a woman.
 * @author mco
 *
 */
class Woman extends Person {

	/**
	 * The constructor for Woman allowing to set a name
	 * @param name the name
	 */
	public Woman(String name) {
		super(name);
	}
	
	@Override
	public void talk() {
		System.out.println("blablabla");
	}
	
}

/**
 * The Woman class extends Person class to implement a man.
 * @author mco
 *
 */
class Man extends Person {

	/**
	 * The constructor for Man allowing to set a name
	 * @param name the name
	 */
	public Man(String name) {
		super(name);
	}
	
	@Override
	public void talk() {
		System.out.println("bla");
	}
	
}

/**
 * The Familiy class model a family of persons with husband, wife and children
 * @author mco
 *
 */
class Family {
	
	/**
	 * the husband
	 */
	private Man husband;
	
	/**
	 * the wife
	 */
	private Woman wife;
	
	/**
	 * the kids
	 */
	private Person[] kids;
}

package ro.tm.siit.classroom.w7d1.person1setter;

/**
 * The PersonApp class demonstrates using Person objects how java objects can be
 * constructed with default constructor and initialized using a setter (an
 * instance method that sets a value); it also demonstrates the toString() method use
 * 
 * @author mco
 *
 */
public class PersonsApp {

	/**
	 * the starting point in a java application; it demonstrates object creation
	 * and toString() method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(12);

		String string = p.toString();
		System.out.println(string);
		System.out.println(p);

	}

}

package ro.tm.siit.classroom.w7d1.person4destroy;

/**
 * The PersonApp class demonstrates using Person objects how java objects can be
 * be created and then uncontrolled how they are destroyed by JVM by creating a
 * large number of objects to trigger garbage collection mechanism.
 * 
 * @author mco
 *
 */
public class PersonsApp {

	/**
	 * the starting point in a java application; it demonstrates object creation
	 * and destruction hook when objects are garbage collected.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			Person p = new Person("name" + i);
			System.out.println(p);
		}
		System.out.println("program ended");

	}

}

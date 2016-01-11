package ro.tm.siit.classroom.w7d1.person3multiconstructor;

/**
 * The PersonApp class demonstrates using Person objects how java objects can be
 * constructed with constructors and how this affects its values;
 * 
 * @author mco
 *
 */
public class PersonsApp {

	/**
	 * the starting point in a java application; it demonstrates object creation
	 * with different constructors how age gets affected
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person(11);
		System.out.println(p);
		p.setAge(12);
		System.out.println(p);
		
		Person p2 = new Person("john");
		System.out.println(p2);
		p2.setAge(25);
		System.out.println(p2);
		
	}

}

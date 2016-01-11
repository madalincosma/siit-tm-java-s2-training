package ro.tm.siit.classroom.w7d1.person2initorder;

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
		
		Person p2 = new Person();
		System.out.println(p);
		
	}

}

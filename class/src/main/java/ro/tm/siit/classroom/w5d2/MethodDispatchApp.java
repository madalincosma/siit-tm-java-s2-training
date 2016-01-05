package ro.tm.siit.classroom.w5d2;

/**
 * The class shows how a Person can work with any car or a specific type of car,
 * Ford.
 * 
 * @author mco
 *
 */
public class MethodDispatchApp {

	/**
	 * the starting point in a java application; it exposes how dynamic dispatch
	 * works for instance methods.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Person person = new Person();
		Car genericCar = new Ford();
		Ford myCar = new Ford();

		person.buyCar(genericCar);
		person.openCar();

		person.buyCar(myCar);
		person.openCar();

		System.out.println(person.hasChildren()); // promotes encapsulation
		System.out.println(person.getChildren().size() > 0); // exposes
																// internals not
																// needed

	}
}

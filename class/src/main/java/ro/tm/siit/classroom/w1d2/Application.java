package ro.tm.siit.classroom.w1d2;

/**
 * First example of a Java program containing multiple classes. Every java
 * program needs to have at least one class with one method (the main method).
 * 
 * The application prints a message which differs based on if a command line
 * argument has been supplied or not.
 * 
 * @author mco
 *
 */
public class Application {

	/**
	 * the starting point in a java application; it contains the logic of this
	 * app.
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {
		String variable = " by George";
		if (args.length == 1) {
			System.out.println("primul meu program by " + args[0]);
			MyClass c = new MyClass();
			c.printMe(args[0]);
		} else {
			System.out.println("primul meu program anonim " + variable);
		}
	}
}
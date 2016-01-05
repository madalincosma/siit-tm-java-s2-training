package ro.tm.siit.classroom.w1d1;

/**
 * Our first app printing to console a message ending with a text supplied by
 * the user when runs the program via command line arguments.
 * 
 * @author mco
 *
 */
public class FirstApplication {

	/**
	 * the starting point in a java application; it prints Hello and something
	 * else what user wants.
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Hello " + args[0]);
	}
}
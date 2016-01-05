package ro.tm.siit.classroom.w2d2;

/**
 * The program accepts a number from command line and it determines if the day
 * is a day or a working day. zi necunoscuta ... -1, 0, 8 ... zi lucratoare 1 5
 * zi recunoscuta 6 7
 * 
 * If exhibits working with control flow statement if.
 * 
 * Execution examples:
 * java ro.tm.siit.Days 1 
 * java ro.tm.siit.Days 2
 * 
 * @author mco
 *
 */
public class Days {

	/**
	 * the starting point in a java application
	 * 
	 * @param args the user supplied command line arguments
	 */
	public static void main(String[] arguments) {
		if (arguments.length > 0) {
			int dayNumber = Integer.parseInt(arguments[0]);
			if (dayNumber <= 5 && dayNumber > 0) {
				System.out.println("zi lucratoare");
			} else if (dayNumber <= 7 && dayNumber > 0) {
				System.out.println("zi recunoscuta");
			} else {
				System.out.println("zi necunoscuta");
			}
		}
	}
}
package ro.tm.siit.classroom.w2d2;

/**
 * The program accepts a number from command line and it determines if the day
 * is a day or a working day. zi necunoscuta ... -1, 0, 8 ... zi lucratoare 1 5
 * zi recunoscuta 6 7
 * 
 * If exhibits working with control flow statement switch.
 * 
 * Execution examples: 
 * java ro.tm.siit.Days 1 
 * java ro.tm.siit.Days 2
 * 
 * @author mco
 *
 */
public class DaysSwitch {

	/**
	 * the starting point in a java application
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] arguments) {
		if (arguments.length > 0) {
			int dayNumber = Integer.parseInt(arguments[0]);
			switch (dayNumber) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("zi lucratoare");
				break;
			case 6:
			case 7:
				System.out.println("zi recunoscuta");
				break;
			default:
				System.out.println("zi necunoscuta");
			}
		}
	}
}
/**
 * 
 */
package ro.tm.siit.classroom.w11d1.friendly;

/**
 * The java program performs arithmetic operations using FriendlyCalculator
 * implementation.
 * 
 * @author mco
 *
 */
public class FriendlyCalculatorApp {

	/**
	 * the starting point in a java application; performs to distinct operations
	 * 4+3 
	 * (4+4)*5 
	 * using a FriendlyCalculator object which allows easy usage to
	 * perform arithmetic operations.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {

		// (4+3)
		FriendlyCalculator calculator = new FriendlyCalculator();
		calculator.add(4).add(3);
		System.out.println(calculator.getResult());

		// (4+4)*5
		calculator.clear().add(4).add(4).multiply(5);
		System.out.println(calculator.getResult());

	}

}

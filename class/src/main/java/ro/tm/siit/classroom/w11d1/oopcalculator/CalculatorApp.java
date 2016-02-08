/**
 * 
 */
package ro.tm.siit.classroom.w11d1.oopcalculator;

/**
 * The java program performs arithmetic operations using Calculator
 * implementation.
 * 
 * @author mco
 *
 */
public class CalculatorApp {

	/**
	 * the starting point in a java application; performs to distinct operations
	 * 4+3
	 * (4+4)*5
	 * using a Calculator object
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {

		// (4+3)
		Calculator calculator = new Calculator();
		int result = calculator.add(4, 3);

		System.out.println(result);

		// (4+4)*5
		result = calculator.add(4, 4);
		result = calculator.multiply(result, 5);
		System.out.println(result);

	}

}

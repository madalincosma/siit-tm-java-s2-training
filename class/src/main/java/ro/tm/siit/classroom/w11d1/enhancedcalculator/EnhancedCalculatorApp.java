/**
 * 
 */
package ro.tm.siit.classroom.w11d1.enhancedcalculator;

/**
 * The java program performs arithmetic operations using EnhancedCalculator
 * implementation.
 * 
 * @author mco
 *
 */
public class EnhancedCalculatorApp {

	/**
	 * the starting point in a java application; performs to distinct operations
	 * 4+3
	 * (4+4)*5
	 * using a EnhancedCalculator object
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {

		// (4+3)
		EnhancedCalculator calculator = new EnhancedCalculator();
		calculator.add(4);
		calculator.add(3);
		System.out.println(calculator.getResult());
		
		// (4+4)*5
		calculator.clear();
		calculator.add(4);
		calculator.add(4);
		calculator.multiply(5);
		System.out.println(calculator.getResult());

	}

}

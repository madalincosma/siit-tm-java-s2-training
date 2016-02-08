package ro.tm.siit.classroom.w11d1.staticcalculator;

/**
 * The java program performs arithmetic operations using StaticCalculator static
 * methods.
 * 
 * @author mco
 *
 */
public class StaticCalculatorApp {

	/**
	 * the starting point in a java application; it performs an arithmetic
	 * operation , 5*7.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {
		String operator = "*";
		Integer left = 5;
		Integer right = 7;

		int outcome = calculate(operator, left, right);
		System.out.println("the result is:" + outcome);
	}

	/**
	 * Performs arithmetic operations with int values
	 * 
	 * @param operation
	 *            support onlz =,-,*,/,%
	 * @param values
	 *            expects (at least) two integer values
	 * @return an int value
	 */
	public static Integer calculate(String operation, Integer... values) {
		int result = 0;
		switch (operation) {
		case "+":
			result = StaticCalculator.add(values);
			break;
		case "-":
			result = StaticCalculator.substract(values);
			break;
		case "x":
			result = StaticCalculator.multiply(values);
			break;
		case "/":
			result = StaticCalculator.division(values);
			break;
		case "%":
			result = StaticCalculator.modulo(values);
			break;
		}
		return result;
	}
}
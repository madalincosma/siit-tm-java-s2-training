package ro.tm.siit.classroom.w11d1.basic;

/**
 * The java program performs arithmetic operations using BasicCalculator
 * implementation.
 * 
 * @author mco
 *
 */
public class BasicCalculatorApp {

	/**
	 * the starting point in a java application; it performs an arithmetic
	 * operation , 5*7.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {

		BasicCalculator basic = new BasicCalculator();
		// 1. get operator & operands
		String operator = "*";
		Integer left = 5;
		Integer right = 7;

		// 2. perform
		int outcome = calculate(basic, operator, left, right);
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
	public static Integer calculate(BasicCalculator basic, String operation, Integer... values) {
		int result = 0;
		switch (operation) {
		case "+":
			result = basic.add(values);
			break;
		case "-":
			result = basic.substract(values);
			break;
		case "x":
			result = basic.multiply(values);
			break;
		case "/":
			result = basic.division(values);
			break;
		case "%":
			result = basic.modulo(values);
			break;
		}
		return result;
	}
}
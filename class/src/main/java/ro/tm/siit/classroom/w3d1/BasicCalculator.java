package ro.tm.siit.classroom.w3d1;

/**
 * The java program performs arithmetic operation on user supplied operator and
 * two operands via command line arguments.
 * 
 * @author mco
 *
 */
public class BasicCalculator {

	/**
	 * the starting point in a java application; it performs an arithmetic
	 * operation based on supplied operands and operator.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {
		// 1. get operator & operands
		String operator = args[1];
		Integer left = Integer.valueOf(args[0]);
		Integer right = Integer.valueOf(args[2]);

		// 2. perform
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
			result = values[0] + values[1];
			break;
		case "-":
			result = values[0] - values[1];
			break;
		case "x":
			result = values[0] * values[1];
			break;
		case "/":
			result = values[0] / values[1];
			break;
		case "%":
			result = values[0] % values[1];
			break;
		}
		return result;
	}
}
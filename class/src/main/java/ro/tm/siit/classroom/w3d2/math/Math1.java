package ro.tm.siit.classroom.w3d2.math;


/**
 * The class supports with arithmetic operations for two operands.
 * 
 * @author mco
 *
 */
public class Math1 {

	/**
	 * Performs arithmetic operations with int values
	 * 
	 * @param operation
	 *            support only +,-,%,/,x (x is used instead of *)
	 * @param values
	 *            expects (at least) two integer values
	 * @return an int value
	 */
	public static Integer calculate(String operation, String... values) {
		if (values.length == 0) {
			return 0;
		}
		int result = 0;
		if ("x".equals(operation)) {
			result = 1;
		}
		for (String value : values) {
			Integer number = Integer.valueOf(value);
			switch (operation) {
			case "+":
				result += number;
				break;
			case "-":
				result -= number;
				break;
			case "x":
				result *= number;
				break;
			case "/":
				result /= number;
				break;
			case "%":
				result %= number;
				break;
			}
		}
		return result;
	}
}
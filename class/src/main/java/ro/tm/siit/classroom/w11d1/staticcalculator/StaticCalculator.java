package ro.tm.siit.classroom.w11d1.staticcalculator;

/**
 * StaticCalculator class implements arithmetic operations using static methods.
 * 
 * @author mco
 *
 */
public class StaticCalculator {

	public static int modulo(Integer... values) {
		return values[0] % values[1];
	}

	public static int division(Integer... values) {
		return values[0] / values[1];
	}

	public static int multiply(Integer... values) {
		return values[0] * values[1];
	}

	public static int substract(Integer... values) {
		return values[0] - values[1];
	}

	public static int add(Integer... values) {
		return values[0] + values[1];
	}

}

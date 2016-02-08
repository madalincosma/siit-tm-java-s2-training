package ro.tm.siit.classroom.w11d1.oopcalculator;

/**
 * Calculator class implements arithmetic operations using instance methods
 * using some level of degree of encapsulation, because result cannot be
 * accessed outside arithmetic operations.
 * 
 * @author mco
 *
 */
public class Calculator {

	private int result;

	public int modulo(Integer... values) {
		result = values[0] % values[1];
		return result;

	}

	public int division(Integer... values) {
		result = values[0] / values[1];
		return result;
	}

	public int multiply(Integer... values) {
		result = values[0] * values[1];
		return result;
	}

	public int substract(Integer... values) {
		result = values[0] - values[1];
		return result;
	}

	public int add(Integer... values) {
		result = values[0] + values[1];
		return result;
	}

}

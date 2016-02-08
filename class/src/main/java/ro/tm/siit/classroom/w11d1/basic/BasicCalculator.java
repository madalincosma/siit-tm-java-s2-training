package ro.tm.siit.classroom.w11d1.basic;

/**
 * BasicCalculator class implements arithmetic operations using instance
 * methods, but without any having encapsulation.
 * 
 * @author mco
 *
 */
public class BasicCalculator {

	public int modulo(Integer... values) {
		return values[0] % values[1];
	}

	public int division(Integer... values) {
		return values[0] / values[1];
	}

	public int multiply(Integer... values) {
		return values[0] * values[1];
	}

	public int substract(Integer... values) {
		return values[0] - values[1];
	}

	public int add(Integer... values) {
		return values[0] + values[1];
	}

}

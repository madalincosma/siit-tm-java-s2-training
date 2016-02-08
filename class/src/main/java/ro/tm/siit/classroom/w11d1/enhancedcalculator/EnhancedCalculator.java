package ro.tm.siit.classroom.w11d1.enhancedcalculator;

/**
 * EnhancedCalculator class implements arithmetic operations using instance
 * methods applying encapsulation which models realistically real-life
 * calculators.
 * 
 * @author mco
 *
 */
public class EnhancedCalculator {

	private int result;

	public int getResult() {

		return result;
	}

	public void clear() {
		result = 0;
	}

	public void modulo(Integer value) {
		result %= value;

	}

	public void division(Integer value) {
		result /= value;

	}

	public void multiply(Integer value) {
		result *= value;

	}

	public void substract(Integer value) {
		result -= value;

	}

	public void add(Integer value) {
		result += value;

	}

}

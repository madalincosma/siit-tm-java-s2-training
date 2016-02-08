package ro.tm.siit.classroom.w11d1.friendly;

/**
 * FriendlyCalculator class implements arithmetic operations using instance
 * methods applying encapsulation which models realistically real-life
 * calculators. Additionally it offers a fluent interface/API which allows easy
 * usage.
 * 
 * @author mco
 *
 */
public class FriendlyCalculator {

	private int result;

	public int getResult() {

		return result;
	}

	public FriendlyCalculator clear() {
		result = 0;
		return this;
	}

	public FriendlyCalculator modulo(Integer value) {
		result %= value;
		return this;

	}

	public FriendlyCalculator division(Integer value) {
		result /= value;
		return this;
	}

	public FriendlyCalculator multiply(Integer value) {
		result *= value;
		return this;
	}

	public FriendlyCalculator substract(Integer value) {
		result -= value;
		return this;
	}

	public FriendlyCalculator add(Integer value) {
		result += value;

		return this;
	}

}

package ro.tm.siit.classroom.w11d2.friendly;

/**
 * EncapsulatedFriendlyCalculator class implements arithmetic operations using instance
 * methods applying encapsulation which models realistically real-life
 * calculators. Additionally it offers a fluent interface/API which allows easy
 * usage.
 * 
 * @author mco
 *
 */
public class EncapsulatedFriendlyCalculator {

	private int result;

	@Override
	public String toString() {
		return result + "";
	}

	public EncapsulatedFriendlyCalculator clear() {
		result = 0;
		return this;
	}

	public EncapsulatedFriendlyCalculator modulo(Integer value) {
		result %= value;
		return this;

	}

	public EncapsulatedFriendlyCalculator division(Integer value) {
		result /= value;
		return this;
	}

	public EncapsulatedFriendlyCalculator multiply(Integer value) {
		result *= value;
		return this;
	}

	public EncapsulatedFriendlyCalculator substract(Integer value) {
		result -= value;
		return this;
	}

	public EncapsulatedFriendlyCalculator add(Integer value) {
		result += value;

		return this;
	}

}

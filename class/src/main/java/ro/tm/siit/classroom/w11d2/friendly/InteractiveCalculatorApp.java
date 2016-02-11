/**
 * 
 */
package ro.tm.siit.classroom.w11d2.friendly;

import java.util.Scanner;

/**
 * The java program performs arithmetic operations using
 * EncapsulatedFriendlyCalculator implementation based on user entered
 * operations. The program does not end due to a infinite while loop. A forced
 * is required to stop it.
 * 
 * @author mco
 *
 */
public class InteractiveCalculatorApp {

	/**
	 * the starting point in a java application; performs to distinct operations
	 * 4+3 (4+4)*5 using a EncapsulatedFriendlyCalculator object which allows
	 * easy usage to perform arithmetic operations. The user is asked to
	 * introduce an operation for which the calculator will calculate the final
	 * value.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {

		// (4+3)
		EncapsulatedFriendlyCalculator calculator = new EncapsulatedFriendlyCalculator();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Please enter operation - please use space between numbers and operators:");
			String line = input.nextLine();

			String[] tokens = line.split(" ");

			calculator.add(Integer.valueOf(tokens[0]));
			for (int i = 1; i < tokens.length; i = i + 2) {
				String token = tokens[i];

				Integer value = Integer.valueOf(tokens[i + 1]);
				perform(calculator, token, value);
			}
			System.out.println(calculator);
			calculator.clear();
		}

	}

	/**
	 * performs an arithmetic operation as specified in parameters between
	 * current calculator result and the supplied value.
	 * 
	 * @param calculator the calculator
	 * @param operation the arithmetic operation +,-,%,/,*
	 * @param value the 2nd operand involved 
	 */
	private static void perform(EncapsulatedFriendlyCalculator calculator, String operation, Integer value) {
		switch (operation) {
		case "+":
			calculator.add(value);
			break;
		case "-":
			calculator.substract(value);
			break;
		case "*":
			calculator.multiply(value);
			break;
		case "/":
			calculator.division(value);
			break;
		case "%":
			calculator.modulo(value);
			break;
		}
	}

}

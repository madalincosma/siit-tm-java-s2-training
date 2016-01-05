package ro.tm.siit.classroom.w3d1.calculator;

import java.util.Arrays;


/**
 * The java program performs arithmetic operations on user supplied operator and
 * any number of operands via command line arguments.
 * 
 * @author mco
 *
 */
public class Calculator {

	/**
	 * the starting point in a java application; it performs an arithmetic
	 * operation based on supplied operands and operator.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {

		// 1. get operator & operands
		String operator = args[0];
		String[] values = Arrays.copyOfRange(args, 1, args.length);

		// 2. perform;
		int outcome = Math1.calculate(operator, values);
		System.out.println("the result is: " + outcome);

	}
}
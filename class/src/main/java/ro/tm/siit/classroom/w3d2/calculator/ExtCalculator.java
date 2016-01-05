package ro.tm.siit.classroom.w3d2.calculator;

import ro.tm.siit.classroom.w3d2.math.Math1;

/**
 * The examples shows same calculator, but when program is composed of classes
 * from packages with no common base.
 * 
 * The java program performs arithmetic operations on user supplied operator and
 * any number of operands via command line arguments.
 * 
 * @author mco
 *
 */
public class ExtCalculator {

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

		// 2. perform
		int outcome = Math1.calculate(operator, args[0], args[2]);
		System.out.println("the result is:" + outcome);
	}
}
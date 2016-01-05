package ro.tm.siit.classroom.w3d1;

import java.util.Scanner;

/**
 * The program shows that the sum of first n numbers can be calculated different
 * ways. Presented calculus using formula, iteration and recursion.
 * 
 * The user is asked to enter in console via keyboard number(N) to be considered
 * for the sum of first N numbers until enters exit.
 * 
 * @author mco
 *
 */
public class Sum {

	/**
	 * the starting point in a java application; it performs calculation on the nth
	 * fibonacci number supplied by the user via command line arguments.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {

		Scanner input = new Scanner(System.in);
		String line = null;
		do {
			System.out.println("please insert a number to calculate the sum");
			line = input.nextLine();
			if (!"exit".equals(line)) {
				Integer maxNumber = Integer.valueOf(line);

				sumWithFormula(maxNumber);
				int sum = sumWithLoop(maxNumber);
				System.out.println("sum of first " + maxNumber + " is " + sum);
				int recSum = sumWithRecursive(maxNumber);
				System.out.println("sum of first " + maxNumber + " is " + recSum);
			}
			System.out.println(line);
		} while (!"exit".equals(line));
	}

	/**
	 * the function calculates the sum of first n numbers using a formula and
	 * prints the result to console.
	 * 
	 * @param n
	 *            the nth number
	 */
	static void sumWithFormula(Integer n) {
		int sum = n * (n + 1) / 2;
		System.out.println("sum of first " + n + " is " + sum);
	}

	/**
	 * the function calculates the sum of first n numbers using a for loop
	 * 
	 * @param n
	 *            the nth number
	 * @return the sum as int
	 */
	static int sumWithLoop(Integer n) {
		int sum = 0;
		for (int i = n; i > 0; i--) {
			// System.out.println(i);
			sum += i;
		}
		return sum;
	}

	/**
	 * the function calculates the sum of first n numbers using recursion
	 * 
	 * @param n
	 *            the nth number
	 * @return the sum as int
	 */
	static int sumWithRecursive(Integer n) {
		// System.out.println(n);
		if (n == 1) {
			return 1;
		}
		return n + sumWithRecursive(n - 1);
	}
}
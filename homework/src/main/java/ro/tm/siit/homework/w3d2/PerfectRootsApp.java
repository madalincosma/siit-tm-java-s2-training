package ro.tm.siit.homework.w3d2;
//Read an array from the standard input and display all the elements which are perfect roots (e.g. 25 is 52, 36 is 62)

//allow user to enter numbers in multiple sessions
//user can enter multiple number at once separated by space/' '
//allow user to exit    
//before exit display the min, max perfect roots, and the sum of all perfect roots entered by the user
//calculate a percentage of user guessing perfect roots/ or noOfPerfectRoots/noOfEnteredNumbers
//calculate an advaced percentage of user guessing for perfect roots higer than 100!!
//tip: Math.sqrt() ... tipp: System.console() ... tipp: study java.lang.Console to see if you can read int directly

import java.util.Scanner;

/**
 * The PerfectRootsApp class is an application which allows a user to input
 * numbers via keyboard in order to check which are perfect roots. At the end
 * when exiting via "exit" command the see a statistics regarding its guessing.
 * 
 * @author mco
 *
 */
public class PerfectRootsApp {

	static Integer min = Integer.MAX_VALUE;
	static Integer max = Integer.MIN_VALUE;
	static Integer sum = 0;
	static Integer totalElements = 0;
	static Integer nrElements = 0;
	static Integer nrElements100 = 0;
	static Integer percentage = 0;
	static Integer advancedPercentage = 0;

	/**
	 * the starting point in a java application; it asks user to input numbers
	 * via keyboard and checks for perfect roots numbers; user can enter as many
	 * numbers per line and is also allowed to enter multiple lines.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {

		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("Perfect Roots program");
		System.out.println("---insert multiple numbers at once separeted by space --- ");
		System.out.println("---you can enter multiple sessions---");
		System.out.println("---write 'exit' to stop---");
		System.out.println();

		do {
			System.out.print("Please insert elements: ");
			String line = input.nextLine();
			if ("exit".equals(line)) {
				displayStatistics();
				break;
			} else {
				processLine(line);
			}

		} while (true);
		input.close();

	}

	/**
	 * displays statistics such as sum/min/max for perfect roots and percentages
	 * of user guessing
	 */
	private static void displayStatistics() {
		percentage = (int) percentage(totalElements, nrElements);
		advancedPercentage = (int) percentage(totalElements, nrElements100);

		System.out.println("SUM of perfect roots elements: " + sum);
		System.out.println("MIN perfect roots: " + min);
		System.out.println("MAX perfect roots: " + max);
		System.out.println("Percentage of user guessing perfect roots: " + percentage + "%");
		System.out.println(
				"advaced percentage of user guessing for perfect roots higer than 100: " + advancedPercentage + "%");
	}

	/**
	 * processes current line of numbers to detect perfect roots
	 * 
	 * @param line
	 *            a string containing numbers separated by space ' '
	 */
	private static void processLine(String line) {
		String[] elements = line.split(" ");
		for (String i : elements) {
			totalElements++;
			Integer number = Integer.valueOf(i);
			boolean isPerfectRoot = isPerfectRoot(number);
			if (isPerfectRoot) {
				nrElements++;
				if (Integer.valueOf(i) < min)
					min = Integer.valueOf(i);
				if (Integer.valueOf(i) > max)
					max = Integer.valueOf(i);
				sum = sum + Integer.valueOf(i);
				if (Integer.valueOf(i) > 100)
					nrElements100++;
			}
		}
	}

	/**
	 * checks if the number is a perfect root, eg. 1, 4, 9, 16, 25, 36, 49... 
	 * @param number a number
	 * @return true if perfect root
	 */
	private static boolean isPerfectRoot(Integer number) {
		double root = (int) Math.sqrt(number);
		double square = root * root;
		return square == (double) number;
	}

	/**
	 * calculates the percentage of amount in total
	 * 
	 * @param amount the divided
	 * @param total the divisor
	 * @return return an integer value between 0 and 100
	 */
	public static int percentage(int amount, int total) {
		return (int) (total / amount) * 100;
	}

}

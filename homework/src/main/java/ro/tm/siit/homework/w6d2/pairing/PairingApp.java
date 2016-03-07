/**
 * 
 */
package ro.tm.siit.homework.w6d2.pairing;

import java.util.Scanner;

/**
 * @author mcosma
 *
 */
public class PairingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Classroom fifthA = new Classroom("5A", "math", "info");
		fifthA.addStudents("dan", "cristi", "gigel", "alex");

		Scanner input = new Scanner(System.in);
		addGrades("math", fifthA, input);
//		fifthA.addGrade("math", "dan", 10);
//		fifthA.addGrade("math", "alex", 8);
//		fifthA.addGrade("math", "gigel", 4);
//		fifthA.addGrade("math", "cristi", 6);
		fifthA.printStatus("math");
		
		fifthA.doPairing("math");
		addGrades("math", fifthA, input);
//		fifthA.addGrade("math", "dan", 10);
//		fifthA.addGrade("math", "alex", 9);
//		fifthA.addGrade("math", "gigel", 6);
//		fifthA.addGrade("math", "cristi", 7);
		fifthA.printStatus("math");
		fifthA.doPairing("math");

	}

	private static void addGrades(String course, Classroom fifthA, Scanner input) {
		String quit = "nu";
		do {
			System.out.println("introduceti nume:");
			String name = input.nextLine();
			System.out.println("introduceti nota:");
			String grade = input.nextLine();
			fifthA.addGrade(course, name, Integer.parseInt(grade));
			System.out.println("continuati? da/nu");
			quit = input.nextLine();
		} while ("nu".equals(quit));
	}

}

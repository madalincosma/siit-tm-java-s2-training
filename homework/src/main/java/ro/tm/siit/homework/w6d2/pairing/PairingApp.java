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
//		fifthA.addGrade("info", "dan", 10);
//		fifthA.addGrade("info", "alex", 9);
//		fifthA.addGrade("info", "gigel", 7);
//		fifthA.addGrade("info", "cristi", 9);
		fifthA.printStatus("math");
		
		fifthA.doPairing("math");
//		fifthA.doPairing("info");
//		addGrades("math", fifthA, input);
//		fifthA.addGrade("math", "dan", 10);
//		fifthA.addGrade("math", "alex", 9);
//		fifthA.addGrade("math", "gigel", 6);
//		fifthA.addGrade("math", "cristi", 7);
//		fifthA.addGrade("info", "dan", 10);
//		fifthA.addGrade("info", "alex", 10);
//		fifthA.addGrade("info", "gigel", 9);
//		fifthA.addGrade("info", "cristi", 8);
		fifthA.printStatus("math");
//		fifthA.printStatus("info");
//		fifthA.doPairing("math");
		
		System.out.println();
		fifthA.printStatus();

	}

	private static void addGrades(String course, Classroom classroom, Scanner input) {
		String quit = "nu";
		do {
			System.out.println("introduceti nume:");
			String name = input.nextLine();
			System.out.println("introduceti nota:");
			String grade = input.nextLine();
			classroom.addGrade(course, name, Integer.parseInt(grade));
			System.out.println("continuati? da/nu");
			quit = input.nextLine();
		} while ("nu".equals(quit));
	}

}

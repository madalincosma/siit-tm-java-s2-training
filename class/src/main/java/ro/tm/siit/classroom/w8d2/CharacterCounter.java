package ro.tm.siit.classroom.w8d2;

import java.util.Scanner;

/**
 * CharacterCounter class allows counting chars in a text read from input.
 * 
 * @author mco
 *
 */
public class CharacterCounter {

	/**
	 * the starting point in a java application; it reads a text and a char from
	 * keyboard and then counts that char in the text and prints the result.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// read string
		Scanner input = new Scanner(System.in);
		String phrase = readString(input);

		// read char
		char f = selectChar(input);

		// count char
		int letterCount = countChar(phrase, f);
		System.out.println(letterCount);
		input.close();

	}// end of main

	public static String readString(Scanner input) {
		System.out.println("Insert text: ");
		String text = input.nextLine();
		return text;
	}

	public static char selectChar(Scanner input) {
		System.out.println("Choose a character: ");
		String letterChosen = input.nextLine();
		if (letterChosen.length() > 0) {
			return letterChosen.charAt(0);
		} else {
			return 'x';
		}
	}

	public static int countChar(String text, char character) {
		int counter = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == character) {
				counter++;
			}
		}
		return counter;
	}
}

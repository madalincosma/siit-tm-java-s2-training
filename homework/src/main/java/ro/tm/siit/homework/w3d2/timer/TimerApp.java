package ro.tm.siit.homework.w3d2.timer;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * The TimerApp class is a application that allows a user to count/book a
 * specific time using commands entered via keyboard. Multiple times interval
 * are summed together and the final result is sent to user email in form of an
 * email containing the time booked/duration in hh:mm:ss format.
 * 
 * @author mco
 *
 */
public class TimerApp {

	/**
	 * the starting point in a java application; it allows a user to book time
	 * using command like start/stop, pause/resume which are entered by the user
	 * via keyboard.
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String... args) {
		String command = "";
		String lastCommand = "";
		boolean exit = true;
		long finalTime = 0;
		long startTime = 0;

		Scanner entry = new Scanner(System.in);
		while (!exit) {
			command = getNextCommand(lastCommand, entry);

			switch (command) {
			case "start":
				startTime = System.currentTimeMillis();
				System.out.println("starts work at " + LocalTime.now());
				break;
			case "stop":
				finalTime = finalTime + (System.currentTimeMillis() - startTime);
				System.out.println("stops work at " + LocalTime.now());
				break;
			case "pause":
				finalTime = finalTime + (System.currentTimeMillis() - startTime);
				System.out.println("work is in pause at " + LocalTime.now());
				break;
			case "continue":
				startTime = System.currentTimeMillis();
				System.out.println("continues work at " + LocalTime.now());
				break;
			case "exit":
				System.out.println("The user exits at " + LocalTime.now());
				exit = true;
				break;
			}
			lastCommand = command;
		}

		String formattedTime = getDuration(finalTime);
		System.out.println("please enter your email : ");
		String to = entry.nextLine();
		MailSender.sendMail(to, formattedTime);
		entry.close();
	}

	/**
	 * extract next valid command from user
	 * 
	 * @param lastCommand
	 *            last valid command
	 * @param input
	 *            the input where gives the command
	 * @return a String represent a valid command
	 */
	private static String getNextCommand(String lastCommand, Scanner input) {
		String command;
		boolean validCommand = false;
		do {
			System.out.println("please insert the command : ");
			command = input.nextLine();
			validCommand = verifyCommand(lastCommand, command);
		} while (!validCommand);
		return command;
	}

	/**
	 * creates a user friendly duration in format hh:mm:ss using a supplied
	 * duration in milliseconds
	 * 
	 * @param finalTime
	 *            the duration in milliseconds
	 * @return a String containing the formatted duration
	 */
	private static String getDuration(long finalTime) {
		long h = (finalTime / 1000) / 3600;
		long m = ((finalTime / 1000) / 60) % 60;
		long s = (finalTime / 1000) % 60;
		String formattedTime = h + ":" + m + ":" + s;
		return formattedTime;
	}

	/**
	 * Check the validity of user input from the keyboard. After start can be
	 * pause or stop, after stop can be start or exit, after pause can be
	 * continue, after continue can be stop and, exit is the command who ends
	 * the activity of the current day.
	 */

	static boolean verifyCommand(String lastInput, String input) {
		boolean valid = false;

		switch (lastInput) {
		case "start":
			if (input.equals("stop") || input.equals("pause")) {
				valid = true;
			} else {
				System.out.println("Incorrect command ! Please enter stop or pause !");
			}
			break;
		case "stop":
			if (input.equals("start") || input.equals("exit")) {
				valid = true;
			} else {
				System.out.println("Incorrect command ! Please enter start or exit !");
			}
			break;
		case "pause":
			if (input.equals("continue")) {
				valid = true;
			} else {
				System.out.println("Incorrect command ! Please enter continue !");
			}
			break;
		case "continue":
			if (input.equals("stop") || input.equals("pause")) {
				valid = true;
			} else {
				System.out.println("Incorrect command ! Please enter stop or pause !");
			}
			break;
		default:
			if (input.equals("start")) {
				valid = true;
			} else {
				System.out.println("Incorrect command ! Please enter start !");
			}
			break;
		}
		return valid;
	}
}

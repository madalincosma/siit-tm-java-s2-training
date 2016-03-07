package ro.tm.siit.classroom.w15d1.calculator;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * CalculatorApp class creates an application to model a Calculator where user
 * calculus is received via input.
 * 
 * @author mco
 *
 */
public class CalculatorApp {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getLogger(CalculatorApp.class.getName());

	/**
	 * entry point in application; it reads from keyboard user calculus and
	 * performs operations to obtain a result. If special cases, the situation
	 * it is logged.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CalculatorApp.configure(LOGGER);

		Scanner input = new Scanner(System.in);
		System.out.println("Please insert an operation");
		String line = input.nextLine();
		// String line = "7 - 3 + 9";
		Calculator calculator = new Calculator();
		try {
			int result = calculator.calculate(line);
			LOGGER.log(Level.INFO, result + "");
		} catch (NumberFormatException e) {
			LOGGER.log(Level.SEVERE, "Incorrect number " + e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			LOGGER.log(Level.SEVERE, "Incorrect operator " + e.getMessage(), e);
		}

	}

	/**
	 * configures logging system to write also in abc.log file, logging
	 * everything
	 * 
	 * @param log
	 *            the logger to be configured
	 */
	private static void configure(Logger log) {
		log.setLevel(Level.ALL);
		FileHandler handler;
		try {
			handler = new FileHandler("abc.log");
			handler.setFormatter(new SimpleFormatter());
			log.addHandler(handler);
		} catch (SecurityException | IOException e) {
			LOGGER.log(Level.SEVERE, "cannot init file logger");
		}
	}

}

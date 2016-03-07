package ro.tm.siit.classroom.w15d1.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Calculator class implements an arithmetic calculator using Operations
 * enum to specify which operations it supports and exceptions to have special cases.
 * 
 * @author mco
 *
 */
public class Calculator {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

	/**
	 * calculates the result
	 * @param line the calculus
	 * @return an int as outcome
	 * @throws NumberFormatException if operands are not numbers
	 * @throws IllegalArgumentException if operator are not supported
	 */
	public int calculate(String line) {
		String[] tokens = line.split(" ");
		int result = Integer.parseInt(tokens[0]);
		for (int i = 0; i < tokens.length; i++) {
			if (i % 2 != 0) {
				int b = Integer.parseInt(tokens[i + 1]);
				Operation operator = Operation.valueOfSymbol(tokens[i]);
				switch (operator) {
				case ADD:
					result += b;
					break;
				case SUB:
					result -= b;
					break;
				case MUL:
					result *= b;
					break;
				case DIV:
					result /= b;
					break;
				}
				LOGGER.log(Level.INFO, "logged operation " + operator);
			}
		}
		return result;
	}

}

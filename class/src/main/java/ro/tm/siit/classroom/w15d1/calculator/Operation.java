package ro.tm.siit.classroom.w15d1.calculator;

import java.util.logging.Level;

/**
 * Operations enum defines arithmetic operations for addition, subtraction,
 * multiply and divide.
 * 
 * @author mco
 *
 */
public enum Operation {

	// + - / *
	ADD("+"), SUB("-"), MUL("*"), DIV("/");

	private String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * uses to supplied symbol to look up a Operation enum value.
	 * @param symbol the symbol of the operation
	 * @return an Operation enum value
	 * @throws IllegalArgumentException if enum value not found
	 */
	public static Operation valueOfSymbol(String symbol) {
		for (Operation operation : values()) {
			if (operation.symbol.equals(symbol)) {
				return operation;
			}
		}
		CalculatorApp.LOGGER.log(Level.WARNING, "no operation found for symbol" + symbol);
		throw new IllegalArgumentException(symbol + " is not suported");
	}
}

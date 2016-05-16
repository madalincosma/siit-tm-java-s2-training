/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * The ExpenseFactory class is a factory for Expense type objects allowing
 * client code to work only with base class and not pollute the rest.
 * 
 * @author mco
 *
 */
public class ExpenseFactory {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * factory method
	 * @param type the type
	 * @param name the name
	 * @param value the value
	 * @param date the date
	 * @return an Expense object
	 * @throws IllegalArgumentException if the type is not supported or null
	 */
	public static Expense createExpense(ExpenseType type, String name, float value, LocalDate date) {
		LOGGER.fine("creating expense from " + name + type + value + date);
		switch (type) {
		case Daily:
			return new DailyExpense(name, value, date);
		case Weekly:
			return new WeeklyExpense(name, value, date);
		case Monthly:
			return new MonthlyExpense(name, value, date);
		case OneOff:
			return new OneOffExpense(name, value, date);
		}
		LOGGER.severe(type + " is not a supported expense type");
		throw new IllegalArgumentException(type + " is not a supported expense type");
	}
}

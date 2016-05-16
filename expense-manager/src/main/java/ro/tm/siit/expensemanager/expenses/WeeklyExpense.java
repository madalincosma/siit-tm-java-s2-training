/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * WeeklyExpense class extends Expense for daily expenses using ExpenseType.Weekly
 * as type.
 * 
 * @author mco
 *
 */
public class WeeklyExpense extends Expense {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * constructor for WeeklyExpense class
	 * @param name the name
	 * @param value the value
	 * @param date the date
	 */
	public WeeklyExpense(String name, float value, LocalDate date) {
		super(ExpenseType.Weekly, name, value, date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.expensemanager.expenses.Expense#getDayValue(java.time.
	 * LocalDate)
	 */
	/**
	 * @return the value if same day of the month between expense date and
	 *         supplied date; otherwise returns 0
	 */
	@Override
	public float getDayValue(LocalDate date) {
		LOGGER.fine("calculating day-value for date " + date);
		if (date.getDayOfWeek() == this.date.getDayOfWeek()) {
			LOGGER.info("day-value for " + date + " is " + getValue());
			return getValue();
		}
		LOGGER.info("day-value for " + date + " is 0");
		return 0;
	}

}

/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * MonthlyExpense class extends Expense for daily expenses using
 * ExpenseType.Monthly as type.
 * 
 * @author mco
 *
 */
public class MonthlyExpense extends Expense {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * constructor for MonthlyExpense class
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param date
	 *            the date
	 */
	public MonthlyExpense(String name, float value, LocalDate date) {
		super(ExpenseType.Monthly, name, value, date);
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
		if (date.getDayOfMonth() == this.date.getDayOfMonth()) {
			LOGGER.info("day-value for " + date + " is " + getValue());
			return getValue();
		}
		LOGGER.info("day-value for " + date + " is 0");
		return 0;
	}

}

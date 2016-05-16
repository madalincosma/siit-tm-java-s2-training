/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * OneOffExpense class extends Expense for daily expenses using ExpenseType.OneOff
 * as type.
 * 
 * @author mco
 *
 */
public class OneOffExpense extends Expense {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	/**
	 * constructor for OneOffExpense class
	 * @param name the name
	 * @param value the value
	 * @param date the date
	 */
	public OneOffExpense(String name, float value, LocalDate date) {
		super(ExpenseType.OneOff, name, value, date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.expensemanager.expenses.Expense#getMonthValue(java.time.
	 * YearMonth)
	 */
	@Override
	/**
	 * @return the value if same month between expense date and
	 *         supplied date; otherwise returns 0
	 */
	public float getMonthValue(YearMonth month) {
		LOGGER.fine("calculating month-value for date " + month);
		YearMonth yearMonth = YearMonth.from(date);
		if (yearMonth.equals(month)) {
			return ExpenseType.OneOff.getMonthMultiply() * getValue();
		} else {
			return 0;
		}
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
		if (this.date.equals(date)) {
			LOGGER.info("day-value for " + date + " is " + getValue());
			return getValue();
		}
		LOGGER.info("day-value for " + date + " is 0");
		return 0;
	}

}

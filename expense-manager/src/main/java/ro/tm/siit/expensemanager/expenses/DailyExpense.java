/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * DailyExpense class extends Expense for daily expenses using ExpenseType.Daily
 * as type.
 * 
 * @author mco
 *
 */
public class DailyExpense extends Expense {

	/**
	 * constructor for DailyExpense class
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param date
	 *            the date
	 */
	public DailyExpense(String name, float value, LocalDate date) {
		super(ExpenseType.Daily, name, value, date);
	}

}

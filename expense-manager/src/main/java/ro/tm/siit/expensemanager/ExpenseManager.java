/**
 * 
 */
package ro.tm.siit.expensemanager;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.expenses.Expense;
import ro.tm.siit.expensemanager.expenses.ExpenseFactory;

/**
 * The ExpenseManager class implements the logic for all major features of the
 * application (adding expenses, lookup, setting a budget limit, forecast and
 * statistics). It also allows loading and saving of expenses.
 * 
 * @author mco
 *
 */
public class ExpenseManager {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();

	List<Expense> expenses = new ArrayList<>();

	int budgetLimit;

	Storage storage = new Storage();

	public void load() {
		storage.load(this);
	}

	public void store() {
		storage.store(this);
	}

	/**
	 * @param budgetLimit
	 *            the budgetLimit to set
	 */
	public void setBudgetLimit(int budgetLimit) {
		this.budgetLimit = budgetLimit;
	}

	/**
	 * @return the budgetLimit
	 */
	public int getBudgetLimit() {
		return budgetLimit;
	}

	/**
	 * adds a new expense
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @param date
	 * @throws BudgetLimitException
	 *             if the level of expense is above limit, but still adds the
	 *             expense.
	 */
	public void addExpense(String name, ExpenseType type, float value, LocalDate date) throws BudgetLimitException {
		LOGGER.fine("adding expense " + name + type + value + date);
		Expense exp = ExpenseFactory.createExpense(type, name, value, date);
		expenses.add(exp);
		LOGGER.info("added expense " + exp);
		Year year = Year.from(date);
		float total = getExpenses(year);
		if (total > budgetLimit) {
			LOGGER.warning("budget exceeded; " + total + " is greater then " + budgetLimit);
			throw new BudgetLimitException(total + " is greater then " + budgetLimit);
		}
	}

	/**
	 * computes forecast of budget for supplied year
	 * 
	 * @param year
	 *            the year
	 * @return a float value
	 */
	public float yearForecast(Year year) {
		LOGGER.fine("calculating forecast for " + year);
		Year lastYear = year.minusYears(1);
		float sum = getExpenses(lastYear);
		float forecast = sum * 1.05f;
		LOGGER.info("forecast for " + year + " is " + forecast);
		return forecast;
	}

	/**
	 * computes forecast of budget for supplied month of year
	 * 
	 * @param month
	 *            the month
	 * @return a float value
	 */
	public float monthForecast(YearMonth month) {
		LOGGER.fine("calculating forecast for " + month);
		float sum = 0;
		YearMonth lastMonth = month.minusMonths(1);
		Year year = Year.from(lastMonth);
		for (Expense expense : expenses) {
			if (expense.isActive(year)) {
				sum += expense.getMonthValue(lastMonth);
			}
		}
		float forecast = sum * 1.05f;
		LOGGER.info("forecast month " + month + " is " + forecast);
		return forecast;
	}

	/**
	 * 
	 * @param year
	 * @return all distinct expenses for the year
	 */
	private float getExpenses(Year year) {
		LOGGER.fine("calculating expenses for " + year);
		float sum = 0;
		for (Expense expense : expenses) {
			if (expense.isActive(year)) {
				sum += expense.getYearValue();
			}
		}
		LOGGER.info("total expenses for " + year + " is " + sum);
		return sum;
	}

	/**
	 * returns a list of expenses of year and type 
	 * @param type the type
	 * @param year the year
	 * @return a List<Expense> for matching expenses
	 */
	public List<Expense> getExpenses(ExpenseType type, Year year) {
		LOGGER.fine("retrieving expenses for " + year + " and " + type);
		List<Expense> list = new ArrayList<>();
		for (Expense expense : expenses) {
			if (expense.isActive(year) && (type == null || type == expense.getType())) {
				list.add(expense);
			}
		}
		LOGGER.fine("found expenses for " + year + " and " + type + " are " + list);
		LOGGER.info("found expenses for " + year + " and " + type + " : " + list.size());
		return list;
	}

	/**
	 * returns a list of expenses of year-month and type 
	 * @param type the type
	 * @param ym the year-month
	 * @return a List<Expense> for matching expenses
	 */
	public List<Expense> getExpenses(ExpenseType type, YearMonth ym) {
		LOGGER.fine("retrieving expenses for " + ym + " and " + type);
		List<Expense> list = new ArrayList<>();
		Year year = Year.from(ym);
		for (Expense expense : expenses) {
			if (expense.isActive(year) && (type == null || type == expense.getType())
					&& 0 != expense.getMonthValue(ym)) {
				list.add(expense);
			}
		}
		LOGGER.fine("found expenses for " + ym + " and " + type + " are " + list);
		LOGGER.info("found expenses for " + ym + " and " + type + " : " + list.size());
		return list;

	}

	/**
	 * returns a list of expenses of exact date and type 
	 * @param type the type
	 * @param date the date
	 * @return a List<Expense> for matching expenses
	 */
	public List<Expense> getExpenses(ExpenseType type, LocalDate date) {
		LOGGER.fine("retrieving expenses for " + date + " and " + type);
		List<Expense> list = new ArrayList<>();
		Year year = Year.from(date);
		for (Expense expense : expenses) {
			if (expense.isActive(year) && (type == null || type == expense.getType())
					&& 0 != expense.getDayValue(date)) {
				list.add(expense);
			}
		}
		LOGGER.fine("found expenses for " + date + " and " + type + " are " + list);
		LOGGER.info("found expenses for " + date + " and " + type + " : " + list.size());
		return list;
	}

	/**
	 * returns the biggest expense in the year
	 * @param year the year
	 * @return an Expense
	 * @throws IllegalStateException if none found
	 */
	public Expense biggestExpense(Year year) {
		LOGGER.fine("looking up biggest expense for " + year);
		Expense expense = null;
		for (Expense currentExpense : expenses) {
			if (currentExpense.isActive(year)) {
				if (expense == null) {
					expense = currentExpense;
				} else if (expense.getYearValue() < currentExpense.getYearValue()) {
					expense = currentExpense;
				}
			}
		}
		if (null == expense) {
			LOGGER.info("no expense found for " + year);
			throw new IllegalStateException("no expense found for " + year);
		}
		LOGGER.info("biggest expense for " + year + " is " + expense);
		return expense;
	}

	/**
	 * returns the biggest expense in the month
	 * @param ym the year month
	 * @return an Expense
	 * @throws IllegalStateException if none found
	 */
	public Expense biggestExpense(YearMonth ym) {
		LOGGER.fine("looking up biggest expense for " + ym);
		Expense expense = null;
		Year year = Year.from(ym);
		for (Expense currentExpense : expenses) {
			if (currentExpense.isActive(year)) {
				if (expense == null) {
					expense = currentExpense;
				} else if (expense.getMonthValue(ym) < currentExpense.getMonthValue(ym)) {
					expense = currentExpense;
				}
			}
		}
		if (null == expense) {
			LOGGER.info("no expense found for " + ym);
			throw new IllegalStateException("no expense found for " + ym);
		}
		LOGGER.info("biggest expense for " + ym + " is " + expense);
		return expense;
	}

}

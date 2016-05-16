/**
 * 
 */
package ro.tm.siit.expensemanager.expenses;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import ro.tm.siit.expensemanager.ExpenseType;

/**
 * The Expense class is the base class for supported expenses.
 * @author mco
 *
 */
public abstract class Expense {

	/**
	 * logger for this class
	 */
	public static final Logger LOGGER = Logger.getGlobal();
	
	public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	protected final ExpenseType type;
	private final String name;
	private final float value;
	protected final LocalDate date;

	/**
	 * constructor for Expense class
	 * @param type
	 * @param name
	 * @param value
	 * @param date
	 */
	public Expense(ExpenseType type, String name, float value, LocalDate date) {
		super();
		this.type = type;
		this.name = name;
		this.value = value;
		this.date = date;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type
	 */
	public ExpenseType getType() {
		return type;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * returns the yearly value
	 * @return yearly value of the expense based on its type
	 */
	public float getYearValue() {
		return type.getYearMultiply() * getValue();
	}

	/**
	 * returns the monthly value
	 * @param month the specific month
	 * @return monthly value of the expense based on its type
	 */
	public float getMonthValue(YearMonth month) {
		return type.getMonthMultiply() * getValue();
	}

	/**
	 * returns the daily value
	 * @param date the specific date
	 * @return the value as set
	 */
	public float getDayValue(LocalDate date) {
		return getValue();
	}

	/**
	 * 
	 * @param year the supplied year
	 * @return true if the year of the expense is same with supplied year
	 */
	public boolean isActive(Year year) {
		Year expenseYear = Year.from(date);
		return expenseYear.equals(year);
	}

	/**
	 * 
	 * @return a String as formatted date of the expense
	 */
	public String getDate() {
		return date.format(FORMATTER);
	}

	/**
	 * 
	 * @return a String as export format for an expense
	 */
	public String toStream() {
		return name + ":" + type.name() + ":" + value + ":" + date.format(FORMATTER);
	}

	/**
	 * creates Expenses out of a String; reverse to toStream()
	 * @param text the string format of the expense
	 * @return an Expense object
	 * @throws IllegalArgumentException if type is supported
	 * @throws NumberFormatException if the value is not a number
	 * @throws DateTimeParseException if the date is not valid
	 */
	public static Expense fromStream(String text) {
		LOGGER.fine("creating expense from " + text);
		String[] tokens = text.split(":");
		ExpenseType type = ExpenseType.valueOf(tokens[1]);
		float value = Float.parseFloat(tokens[2]);
		LocalDate date = LocalDate.parse(tokens[3], FORMATTER);
		Expense expense = ExpenseFactory.createExpense(type, tokens[0], value, date);
		LOGGER.fine("created expense " + expense + " from " + text);
		return expense;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expense [type=" + type + ", name=" + name + ", value=" + value + ", date=" + date + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + Float.floatToIntBits(value);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}

}

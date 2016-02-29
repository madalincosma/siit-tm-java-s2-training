package ro.tm.siit.classroom.w14d1.enums;

/**
 * The Employee class models an employee with name, salary, position, paidLeave,
 * gender and benefits, offering information like salary or hourly rate in
 * supported currencies, taking vacation.
 * 
 * @author mco
 *
 */
public class Employee {

	/**
	 * Currency enum models currencies. Supported values are USD, EUR and RON
	 * with attached exchange rate.
	 * 
	 * @author mco
	 *
	 */
	public enum Currency {
		USD(4), EUR(4.4), RON(1);

		/**
		 * expressed in rate to 1 RON
		 */
		private double rate;

		private Currency(double rate) {
			this.rate = rate;
		}

		/**
		 * gets reference exchange rate for this current.
		 * @return a double value representing the exchange rate to 1 RON
		 */
		public double getRate() {
			return rate;
		}
	}

	/**
	 * Day enum models days of week.
	 * @author mco
	 *
	 */
	public enum Day {
		Mon, Tue, Wed, Thu, Fri, Sat, Sun;
	}

	/**
	 * Gender enum models person gender, male or female.
	 * @author mco
	 *
	 */
	public enum Gender {
		M, F;
	}

	/**
	 * Job enum models positions available in a IT company
	 * @author mco
	 *
	 */
	public enum Job {
		Manager, Developer, QA, Architect, BA, SysAdmin, Sales, HR;

		/**
		 * The method prints all available job/enum values.
		 */
		public static void printAvailablePositions() {
			for (Job job : values()) {
				System.out.print(job + " ");
			}
			System.out.println();
		}
	}

	private static final int WEEKS_PER_MONTH = 4;
	private static final int HOURS_PER_DAY = 8;

	private String name;
	private Job position;
	private int salary;
	private Currency currency;
	private String benefits;
	private Gender gender;
	private int paidDaysOff;
	private Day[] workDays;

	/**
	 * Constructor for Employee class allowing to set name, salary, currency, paid leave and working days
	 * @param name the name
	 * @param salary the salary
	 * @param currency the salary currency
	 * @param paidDaysOff the number of paid days
	 * @param workDays the owrking days in a week
	 */
	public Employee(String name, int salary, Currency currency, int paidDaysOff, Day... workDays) {
		super();
		this.name = name;
		this.salary = salary;
		this.currency = currency;
		this.paidDaysOff = paidDaysOff;
		this.workDays = workDays;
	}

	/**
	 * allows a employee to take vacation for a number of days
	 * @param days the days subtracted from current number of days off.
	 */
	public void takeVacation(int days) {
		if (paidDaysOff >= days) {
			paidDaysOff = paidDaysOff - days;
		}
	}

	/**
	 * calculates the salary in specified currency per month
	 * @param currency the currency in which to express the salary
	 * @return an int value for employee salary in specified currency
	 */
	public int getSalary(Currency currency) {
		// this.salary / currency.getRate() * this.currency.getRate();
		return (int) (this.salary / (currency.getRate() / this.currency.getRate()));
	}

	/**
	 * calculates the salary in specified currency per hour
	 * @param currency the currency in which to express the salary
	 * @return an int value for employee hourly rate in specified currency
	 */
	public int getHourlyRate(Currency currency) {
		return getSalary(currency) / getWorkingHoursPerMonth();
	}

	/**
	 * calculates average hours of work per month considering working days, 8h/day and 4w/1m
	 * @return an int value represnting the number of hours.
	 */
	private int getWorkingHoursPerMonth() {
		return workDays.length * HOURS_PER_DAY * WEEKS_PER_MONTH;
	}

	/**
	 * checks if the employee works during weekend
	 * @return true if the employee works in w/e otherwise false
	 */
	public boolean isWorkingInWeekend() {
		for (Day day : workDays) {
			// if (day.equals(Day.Sat) || day.equals(Day.Sun)) {
			// return true;
			// }
			if (day.ordinal() >= 5) {
				return true;
			}
		}
		return false;
	}

	/**
	 * prints the employee working days
	 */
	public void printWorkingDays() {
		for (Day day : workDays) {
			System.out.print(day.name() + " ");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", currency=" + currency + ", paidDaysOff="
				+ paidDaysOff + "]";
	}

}

/**
 * 
 */
package ro.tm.siit.classroom.w14d1.enums;

/**
 * 
 * The EmployeesApp class creates a java program to handle employees and
 * exercise usage of enums.
 * 
 * @author mco
 *
 */
public class EmployeesApp {

	/**
	 * the entry point in the app; it creates employees and prints their hourly
	 * rates in RON, workingdays, taking vacation or if they work during
	 * weekend.
	 * 
	 * @param args
	 *            not processed
	 */
	public static void main(String[] args) {
		Employee.Job.printAvailablePositions();

		Employee radu = new Employee("radu", 1100, Employee.Currency.EUR, 25, Employee.Day.Mon, Employee.Day.Tue);
		Employee florin = new Employee("florin", 1000, Employee.Currency.EUR, 21, Employee.Day.Mon, Employee.Day.Tue,
				Employee.Day.Wed, Employee.Day.Sat);
		Employee madalin = new Employee("madalin", 1500, Employee.Currency.EUR, 25, Employee.Day.Mon, Employee.Day.Wed);

		System.out.println(radu.getHourlyRate(Employee.Currency.RON) + "" + Employee.Currency.RON);
		System.out.println(florin.getHourlyRate(Employee.Currency.RON) + "" + Employee.Currency.RON);
		System.out.println(madalin.getHourlyRate(Employee.Currency.RON) + "" + Employee.Currency.RON);
		madalin.printWorkingDays();

		System.out.println(radu);
		radu.takeVacation(10);
		System.out.println(radu);
		System.out.println(madalin);
		System.out.println(radu.isWorkingInWeekend());
		System.out.println(florin.isWorkingInWeekend());

	}

}

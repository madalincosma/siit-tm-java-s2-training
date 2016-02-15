package ro.tm.siit.classroom.w12d1.contest;

/**
 * Company class extends SuccessfulEntity class to model a company from
 * successfulness point of view.
 * 
 * @author mco
 *
 */
public class Company extends SuccessfulEntity {

	private Employee[] employees = new Employee[10];
	private int employeeCount = 0;

	/**
	 * Constructor for Company class
	 * 
	 * @param name
	 * @param employees
	 */
	public Company(String name, Employee... employees) {
		super(name);
		this.employees = employees;
		this.employeeCount = employees.length;
	}

	// public void addEmployee(Employee e) {
	// this.employees[employeeCount++] = e;
	// }

	/**
	 * implemented as ratio of average of employee success index; index is
	 * increased 10% is more than 3 employees.o
	 */
	@Override
	public float getSuccessIndex() {
		float index = 0f;
		for (int i = 0; i < employeeCount; i++) {
			index += employees[i].getSuccessIndex();
		}
		if (index > 0) {
			index = index / employeeCount;
		}
		if (employeeCount >= 3) {
			index *= 1.1f;
		}
		return index;
	}

}

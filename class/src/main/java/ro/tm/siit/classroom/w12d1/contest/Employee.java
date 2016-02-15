package ro.tm.siit.classroom.w12d1.contest;

/**
 * The Employee class extends Person class to model a special kind of person,
 * the employee, from the successfulness point of view.
 * 
 * @author mco
 *
 */
public class Employee extends Person {

	/**
	 * Constructor for Employee class
	 * 
	 * @param name
	 *            the name
	 * @param earnings
	 *            in eur
	 * @param experience
	 *            in years
	 */
	public Employee(String name, int earnings, int experience) {
		super(name, earnings, experience);
	}

	/**
	 * implemented as a ratio earnings/experience without ratio
	 */
	@Override
	public float getSuccessIndex() {
		return super.getSuccessIndex() / 1.5f;
	}

}

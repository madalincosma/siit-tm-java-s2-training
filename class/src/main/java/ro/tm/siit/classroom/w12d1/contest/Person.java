package ro.tm.siit.classroom.w12d1.contest;

/**
 * The Person class extends SuccessfulEntity class to model humans from
 * successfulness point of view.
 * 
 * @author mco
 *
 */
public class Person extends SuccessfulEntity {

	private static final float ENTREPRENEUR_PREMIUM = 1.5f;

	// in eur
	private int earnings;

	// in years
	private int experience;

	/**
	 * Constructor for Person class
	 * 
	 * @param name
	 *            the name
	 * @param earnings
	 *            income in euro
	 * @param experience
	 *            in number of years
	 */
	public Person(String name, int earnings, int experience) {
		super(name);
		this.experience = experience;
		this.earnings = earnings;
	}

	/**
	 * implemented as a ratio of earnings/experience with a premium of 50% for
	 * working alone.
	 */
	@Override
	public float getSuccessIndex() {
		return ENTREPRENEUR_PREMIUM * ((float) earnings) / experience;
	}

}

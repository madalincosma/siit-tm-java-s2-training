package ro.tm.siit.classroom.w12d1.contest;

/**
 * SuccessfulEntity class is base abstraction for successful entities.
 * 
 * @author mco
 *
 */
public abstract class SuccessfulEntity {

	private String name;

	public SuccessfulEntity(String name) {
		super();
		this.name = name;
	}

	/**
	 * returns the success level 
	 * @return a float value
	 */
	public abstract float getSuccessIndex();

	@Override
	public String toString() {
		return name + " : " + getSuccessIndex();
	}

}

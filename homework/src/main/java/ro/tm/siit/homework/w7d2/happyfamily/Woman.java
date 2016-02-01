package ro.tm.siit.homework.w7d2.happyfamily;

/**
 * The Woman class models a woman
 * 
 * @author mco
 *
 */
public class Woman extends Person {

	/**
	 * keeps status of having a good career or not
	 */
	private boolean hasCareer;

	/**
	 * number of kids person has
	 */
	private boolean hasKids;
	
	private boolean hasGirlfriends;

	/**
	 * Constructor for Woman class that allows woman name and age.
	 * 
	 * @param name
	 *            the name of the woman to be created
	 * @param age
	 *            the age of the woman to be created
	 */
	public Woman(String name, int age) {
		super(name, age);
	}

	/**
	 * check if woman is happy
	 * 
	 * @return true or false
	 */
	@Override
	public boolean isHappy() {
		boolean happiness;
		if (getAge() < 18) {
			return hasGoodGrades() && hasGirlfriends;			
		} else if (getAge() < 30) {
			if (isCoupled() && hasCareer) {
				happiness = true;
			} else {
				happiness = false;
			}
		} else {
			if (married && hasKids) {
				happiness = true;
			} else {
				happiness = false;
			}
		}
		return happiness;
	}
	
	public void makeGirlfriend() {
		this.hasGirlfriends = true;
	}
	
	/**
	 * changes woman status to coupled
	 */
	public void makeBoyfriend() {
		this.coupled = true;
	}

	/**
	 * makes woman with a good career
	 */
	public void withCareer() {
		this.hasCareer = true;
	}

	/**
	 * getter for coupled
	 * 
	 * @return current relationship status of the person
	 */
	public boolean isCoupled() {
		return coupled;
	}
	
	public void newKid() {
		this.hasKids = true;
	}

}

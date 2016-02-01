package ro.tm.siit.homework.w7d2.happyfamily;

/**
 * The Man class models a man.
 * 
 * @author mco
 *
 */
public class Man extends Person {

	/**
	 * keeps status of having gadgets or not
	 */
	private String[] gadgets = new String[5];
	
	/**
	 * keeps number of gadgets
	 */
	private int gadgetCount = 0;

	/**
	 * Constructor for Man class that allows man name and age.
	 * 
	 * @param name
	 *            the name of the man to be created
	 * @param age
	 *            the age of the man to be created
	 */
	public Man(String name, int age) {
		super(name, age);
	}

	/**
	 * check if man is happy
	 * 
	 * @return true or false
	 */
	@Override
	public boolean isHappy() {
		boolean happiness;
		if (getAge() < 18) {
			return hasGoodGrades() && hasPlayStation();			
		} else {
			if (gadgetCount > 0 && this.coupled) {
				happiness = true;
			} else {
				happiness = false;
			}
		}
		return happiness;
	}

	/**
	 * adds a new gadget
	 * @param gadget the name of the gadget
	 */
	public void addGadget(String gadget) {
		gadgets[gadgetCount++] = gadget;
	}

	/**
	 * the man is making a girlfriend
	 */
	public void makeGirlfriend() {
		this.coupled = true;
	}

	/**
	 * checks if has a playstation
	 * @return true if has playstation
	 */
	private boolean hasPlayStation() {
		for (String gadget : gadgets) {
			if("play-station".equals(gadget)) {
				return true;
			}
		}
		return false;
	}
}
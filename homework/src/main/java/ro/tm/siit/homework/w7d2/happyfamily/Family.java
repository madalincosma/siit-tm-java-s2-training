package ro.tm.siit.homework.w7d2.happyfamily;

/**
 * The Family class models a family with husband, wife and kids.
 * 
 * @author mco
 *
 */
public class Family {

	/**
	 * family id
	 */
	private String name;

	/**
	 * man of the house
	 */
	private Man husband;

	/**
	 * woman of the house
	 */
	private Woman wife;

	/**
	 * all kids of family
	 */
	private Person[] kids = new Person[5];

	/**
	 * number of kids in the family
	 */
	private int kidCount;

	/**
	 * Constructor for Family class that allows a husband and a wife
	 * 
	 * @param husband
	 *            man of the family to be created
	 * @param wife
	 *            woman of the family to be created
	 */
	public Family(Man husband, Woman wife) {
		this.name = husband.getName() + " & " + wife.getName();
		this.husband = husband;
		this.wife = wife;
		this.husband.marry();
		this.wife.marry();
	}

	/**
	 * adds a child to the family
	 */
	public void addKid(Person kid) {
		this.kids[kidCount++] = kid;
		this.wife.newKid();
	}

	/**
	 * check if all family members are happy
	 */
	public boolean isHappy() {
		boolean happiness;
		if (husband.isHappy() && wife.isHappy() && this.areKidsHappy()) {
			happiness = true;
		} else {
			happiness = false;
		}
		return happiness;
	}
	
	@Override
	public String toString() {
		return name + " is a family with " + kidCount + " kids";
	}

	/**
	 * check if all kids are happy
	 */
	private boolean areKidsHappy() {
		for (Person k : kids) {
			if (k != null) {
				if (!k.isHappy()) {
					return false;
				}
			}
		}
		return true;
	}
}

package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The Fountain class models a water fountain.
 * 
 * @author mco
 *
 */
public class Fountain {

	/**
	 * the water in the fountain
	 */
	private Water water = null;

	/**
	 * the physical size of the fountain
	 */
	private Size size;

	// initialization block
	{
		size = Size.createSize(3, 4, 11);
	}

	/**
	 * Constructor for Fountain class that allows setting the water supply
	 * 
	 * @param water the water that fountain uses
	 */
	protected Fountain(Water water) {
		this.water = water;
	}

	/**
	 * it supplies 1 liter of water if it has
	 * @return a Water object or null if no water available
	 */
	public Water supplyWater() {
		return water.get(1);
	}

	/**
	 * 
	 * @param quantity the desired number of liters
	 * @return a Water object if enough drinkable water or null otherwise
	 */
	public Water supplyDrinkableWater(byte quantity) {
		if (water.isDrinkable()) {
			return water.get(quantity);
		}
		return null;
	}

	/**
	 * 
	 * @return the water reference attached to this fountain 
	 */
	protected Water getWater() {
		return water;
	}

}

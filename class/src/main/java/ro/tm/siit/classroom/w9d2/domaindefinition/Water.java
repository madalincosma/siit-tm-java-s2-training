package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The Water class models a water supply.
 * 
 * @author mco
 *
 */
public class Water {

	private static Water lastWater;

	/**
	 * flag is true if water is drinkable
	 */
	private boolean isDrinkable;

	/**
	 * the source of the water, GROUND or PUBLIC SYSTEM
	 */
	private String source;

	/**
	 * the initial volume of the supply
	 */
	private long volume;

	/**
	 * Constructor for Water class which allows setting if water is drinkable,
	 * the source and the volume O
	 * 
	 * @param isDrinkable 
	 * @param source
	 * @param volume
	 */
	private Water(boolean isDrinkable, String source, long volume) {
		super();
		this.isDrinkable = isDrinkable;
		this.source = source;
		this.volume = volume;
	}

	/**
	 * returns a volume of water if available or null
	 * @param liters the required volume
	 * @return Water object if enough water or null
	 */
	public Water get(long liters) {
		if (volume < liters) {
			return null;
		}

		Water water = new Water(this.isDrinkable, this.source, liters);
		volume -= liters;

		return water;
	}
	
	/**
	 *  returns an available water supply
	 * @return a Water object or null if no supply available
	 */
	public static Water getWater() {
		return Water.lastWater;
	}
	
	/**
	 * creates a new water supply with supplied params
	 * @param isDrinkable
	 * @param source
	 * @param volume
	 * @return a Water object 
	 */
	static Water getWater(boolean isDrinkable, String source, long volume) {
		Water water = new Water(isDrinkable, source, volume);
		Water.lastWater = water;
		return water;
	}

	/**
	 * 
	 * @return true if water supply is drinkable
	 */
	boolean isDrinkable() {
		return isDrinkable;
	}

	/**
	 * return the source of the water
	 * @return a String object 
	 */
	String getSource() {
		return source;
	}

}

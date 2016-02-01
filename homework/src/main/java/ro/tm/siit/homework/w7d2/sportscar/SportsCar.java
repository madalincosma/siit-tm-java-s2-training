package ro.tm.siit.homework.w7d2.sportscar;

/**
 * The SportsCar class models a Sport Car. It contains relevant information
 * about a sports car model, type, horse power and top speed.
 * 
 * @author mco
 * @version 1.0
 */
public class SportsCar {

	private String modelName;
	private String type;
	private int horsepower;
	private int topSpeed;

	/**
	 * Constructor for class SportsCar
	 * 
	 * @param modelName
	 * @param type
	 * @param horsepower
	 * @param topSpeed
	 */
	public SportsCar(String modelName, String type, int horsepower, int topSpeed) {

		this.modelName = modelName;
		this.type = type;
		this.horsepower = horsepower;
		this.topSpeed = topSpeed;
	}

	/**
	 * 
	 * @return param modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @return param type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return param horsepower
	 */
	public int getHorsepower() {
		return horsepower;
	}

	/**
	 * 
	 * @return param topSpeed
	 */
	public int getTopSpeed() {
		return topSpeed;
	}

	/**
	 * Checks equality on modelName and horsepower and topSpeed
	 * 
	 * @param another
	 *            of type SportsCar
	 * @return true on equality
	 */
	public boolean equals(SportsCar another) {
		if (another.getModelName().equals(this.getModelName()) && another.getHorsepower() == this.getHorsepower()
				&& another.getTopSpeed() == this.getTopSpeed())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Model: " + getModelName() + "\n" + "Horse power: " + getHorsepower() + "\n" + "Top speed: "
				+ getTopSpeed();
	}

}
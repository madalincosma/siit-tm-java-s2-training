package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The PoweredFountain class extends Fountain class to simulate a powered fountain
 * where a person needs no effort to get the water out.
 * 
 * @author mco
 *
 */
public class PoweredFountain extends Fountain {
	
	/**
	 * reference to its power source
	 */
	private PowerSupply power;
	
	/**
	 * Constructor for PoweredFountain class allowing to set water and power supply
	 * @param water the water supply
	 * @param power the power supply
	 */
	public PoweredFountain(Water water, PowerSupply power) {
		super(water);
		this.power = power;
	}

	/**
	 * turns on the fountain
	 */
	public void turnOn() {
		//power.consume();
	}
	
	/**
	 * turns off the fountain
	 */
	public void turnOff() {
		
	}
}

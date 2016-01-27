package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The ArtesianFountain class extends PoweredFountain class to simulate a
 * special kind of fountain that can be found in cities. It can have even music
 * or lights.
 * 
 * @author mco
 *
 */
public class ArtesianFountain extends PoweredFountain {

	/**
	 * the audio system if any
	 */
	private Object music;
	
	/**
	 * the light system if any
	 */
	private Object light;

	/**
	 * Constructor for ArtesianFountain class allowing to set water and power supply
	 * @param water the water supply
	 * @param power the power supply
	 * @param music the audio system
	 * @param light the lights system
	 */
	public ArtesianFountain(Water water, PowerSupply power, Object music, Object light) {
		super(water, power);
		this.music = music;
		this.light = light;
	}

	@Override
	public void turnOn() {
		super.turnOn();
		// music.on()
		// light.on()
		// supply in a loop water
		while (supplyWater() != null) {
		}
	}

}

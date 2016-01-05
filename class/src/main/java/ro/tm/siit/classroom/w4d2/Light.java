package ro.tm.siit.classroom.w4d2;

/**
 * A abstraction for a light ball/switch that allows turning on, off or
 * brighten/dim the light.
 * 
 * @author mco
 *
 */
public class Light {

	/**
	 * keeps the light level as int; 0 means light is off
	 */
	private int lightLevel;

	/**
	 * turns on the light to max level
	 */
	public void on() {
		lightLevel = 30;
	}

	/**
	 * turns off the light
	 */
	public void off() {
		lightLevel = 0;
	}

	/**
	 * brighten the light if not at max level
	 */
	public void brighten() {
		if (lightLevel == 30) {
			return;
		}
		lightLevel++;
	}

	/**
	 * dims the light if not already closed
	 */
	public void dim() {
		if (lightLevel == 0) {
			return;
		}
		lightLevel--;
	}

}

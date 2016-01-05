package ro.tm.siit.classroom.w4d2;

/**
 * A simple abstraction for a light ball.
 * 
 * @author mco
 *
 */
public class SimpleLight {

	/**
	 * a flag to keep status: on/true and off/false
	 */
	private boolean light;

	/**
	 * turns on the light
	 */
	public void on() {
		light = true;
	}

	/**
	 * turns off the light
	 */
	public void off() {
		light = false;
	}

	/**
	 * turns the light ball brighter
	 */
	public void brighten() {
	}

	/**
	 * turns the light ball darker
	 */
	public void dim() {
	}

}

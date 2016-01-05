package ro.tm.siit.classroom.w2d1.multipackageapp.switcher;

/**
 * The class simulates a light switch that lights multiple lights. It offers
 * also the option to check if any light is no.
 * 
 * The class shows how variables, instance variables (name, flag), class variables (lights)
 * and parameters (name) can be used in java code
 * 
 * @author mco
 *
 */
public class Switcher {

	/**
	 * it counts how many lights are on
	 */
	static int lights = 0;
	
	/**
	 * it tells if this switcher/light is on (true)
	 */
	boolean flag = false;
	
	/**
	 * the name of the switcher to be used as ID
	 */
	String name;

	/**
	 * default constructor
	 */
	public Switcher() {
	}

	/**
	 * constructor that sets an name to the switch
	 * @param name
	 */
	public Switcher(String name) {
		this.name = name;
	}

	/**
	 * tries to turn on a light
	 */
	public void turnOn() {
		if (flag) {
			System.out.println(name + " already turned on");
		} else {
			System.out.println(name + " turned on");
			flag = true;
			lights = lights + 1;
		}
	}

	/**
	 * tries to turn off a light
	 */
	public void turnOff() {
		if (!flag) {
			System.out.println(name + " already turned off");
		} else {
			System.out.println(name + " turned off");
			flag = false;
			lights = lights - 1;
		}
	}

	/**
	 * prints to console if this switcher/light is on
	 */
	public void isTurnedOn() {
		System.out.println(name + " turned on " + flag);
	}

	/**
	 * prints to console the status of all controlled lights.
	 */
	public static void isLight() {
		if (lights > 0) {
			System.out.println("at least one light on");
		}
		System.out.println("no light");
	}
}
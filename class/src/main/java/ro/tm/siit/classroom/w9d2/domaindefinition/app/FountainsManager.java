package ro.tm.siit.classroom.w9d2.domaindefinition.app;

import ro.tm.siit.classroom.w9d2.domaindefinition.ArtesianFountain;
import ro.tm.siit.classroom.w9d2.domaindefinition.Fountain;
import ro.tm.siit.classroom.w9d2.domaindefinition.ManualFountain;
import ro.tm.siit.classroom.w9d2.domaindefinition.PowerSupply;
//import ro.tm.siit.classroom.w9d2.domaindefinition.Size;
import ro.tm.siit.classroom.w9d2.domaindefinition.Water;

/**
 * The FountainsManager class creates a program while trying to show how access
 * control works in java both a class level and member level.
 * 
 * @author mco
 *
 */
public class FountainsManager {

	/**
	 * the starting point in a java application; it demonstrates access control
	 * while playing with fountains.O
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Fountain myFountain = new ManualFountain();
		
		// Size.createSize(3, 4, 11); // package-private class not available
		// outside its package
		Water originalWater = Water.getWater();
		PowerSupply power = new PowerSupply();
		ArtesianFountain af = new ArtesianFountain(originalWater, power, null, null);
		Water water = af.supplyDrinkableWater((byte) 3); // available via
															// inheritance of a
															// public method in
															// Fountain
		af.turnOn(); // available in ArtesianFountain as public class
		af.turnOff();// available via inheritance of a public method in
						// PoweredFountain

		// water.getSource(); //not avail because is protected and in another
		// package
		// water.isDrinkable; // not avail because package private and another
		// package

		Water limitedWater = water.get(3);

		// new Fountain(limitedWater);// not available due to protected and
		// other package
	}

}

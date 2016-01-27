package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The ManualFountain class extends Fountain class to simulate a manual fountain
 * where a person needs to work to get the water out.
 * 
 * @author mco
 *
 */
public class ManualFountain extends Fountain {

	/**
	 * the depth from which the water is taken
	 */
	private float depth;

	/**
	 * the size of the bucket (in liters) that is used to bring the water up.O
	 */
	private byte bucketSize;

	/**
	 * Constructor for ManualFountain class that attaches a water supply that is
	 * drinkable coming the ground and having a 2000 liter valume.
	 */
	public ManualFountain() {
		super(Water.getWater(true, "Ground", 2000));
	}

	/**
	 * returns a bucket of water
	 * @return a Water object with required amount or null
	 */
	@Override
	public Water supplyWater() {
		return getWater().get(bucketSize);
	}
}

package ro.tm.siit.classroom.w5d2;

/**
 * It creates a special kind of Car named Ford. It inherits structure and
 * behavior from Car class overriding existing functionality and exhibiting new
 * behavior/functionality.
 * 
 * @author mco
 *
 */
public class Ford extends Car {

	/**
	 * the method exhibits a special feature of Ford cars - self check for problems
	 */
	public void selfDiagnose() {
		this.open("service-key");
		this.start();
		/// check engine
	}

	@Override
	public void start() {
		System.out.println("//start by pressing a button");
	}

	@Override
	public void open(String carKey) {
		System.out.println("open ford");
		if (isValidKey(carKey)) {
			super.open(carKey);
		}
	}

	/**
	 * special procedure for validating a key; it also checks online for auto theft
	 * @param carKey the car key for which car it checks online
	 * @return true if valid key
	 */
	private boolean isValidKey(String carKey) {
		// check online if the car was not marked stolen
		//....
		return true;
	}

}

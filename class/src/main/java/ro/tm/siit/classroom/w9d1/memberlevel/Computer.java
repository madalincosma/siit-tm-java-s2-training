package ro.tm.siit.classroom.w9d1.memberlevel;

/**
 * The Computer class model a generic computer machine having properties like
 * cpu, amount of RAM, weight and some basic behavior like starting/stopping.
 * It allows to add ram only if off. It does not allow to change display.
 * 
 * @author mco
 */
public class Computer {

	/**
	 * the name of the cpu
	 */
	protected String cpu;

	/**
	 * the amount of ram memory
	 */
	protected short ram; // in GB

	/**
	 * the weight of the machine
	 */
	private float weight;

	/**
	 * if true says that computer is turned off.
	 */
	private boolean off = false;

	/**
	 * the name of the display used
	 */
	protected String display;

	/**
	 * does not change the display and display the name of the current displayO
	 * 
	 * @param another
	 *            the name of the new display
	 */
	public void changeDisplay(String another) {
		System.out.println("current display is " + this.display);
	}

	/**
	 * starts the computer via boot and OS load
	 */
	public void start() {
		off = false;
		boolean working = boot();
		if (working) {
			loadOs();
		}
	}

	/**
	 * stops the computer via OS shutdown and powerOff
	 */
	public void stop() {
		shutdownOs();
		powerOff();
		setOff(true);
	}

	/**
	 * allows to add ram memory is computer is turned off.
	 * 
	 * @param ram
	 *            the amount of ram to add
	 */
	public void addRam(short ram) {
		if (off) {
			Utils utils = new Utils();
			this.ram = (short) utils.add(this.ram, ram);
			// this.ram = (short) (this.ram + ram);
		}
	}

	/**
	 * exposes if the computer is turned off
	 * 
	 * @return true is off
	 */
	protected boolean isOff() {
		return this.off;
	}

	/**
	 * allows setting the amount of ram
	 * 
	 * @param ramCount
	 *            the amount of ram in short
	 */
	protected void setRam(short ramCount) {
		this.ram = ramCount;
	}

	/**
	 * allows to define power off procedure
	 */
	protected void powerOff() {
		// TODO Auto-generated method stub

	}

	/**
	 * allows to define shutting down procedure
	 */
	protected void shutdownOs() {
		// TODO Auto-generated method stub

	}

	/**
	 * allows to define boot procedure
	 */
	protected boolean boot() {
		return true;
	}

	/**
	 * allows to define loading OS procedure
	 */
	protected void loadOs() {

	}

	/**
	 * allows to set the computer off
	 * 
	 * @param off
	 *            the status
	 */
	private void setOff(boolean off) {
		this.off = off;
	}

}

package ro.tm.siit.classroom.w9d1.memberlevel.oldstuff;

import ro.tm.siit.classroom.w9d1.memberlevel.Computer;
import ro.tm.siit.classroom.w9d1.memberlevel.Utils;

/**
 * The MainFrame class extends Computer class and model a main frame computer. It
 * defines custom boot, loadOS, shutdownOS and powerOff procedure. It allows to add ram even if not off.
 * 
 * @author mco
 *
 */
public class MainFrame extends Computer {

	/**
	 * Constructor class for main frame computers
	 * 
	 * @param cpu
	 *            the cpu name
	 * @param ram
	 *            the amount of RAM in GB
	 */
	public MainFrame(String cpu, short ram) {
		this.cpu = cpu;
		this.setRam(ram);
	}

	/**
	 * the ram can be added without power off !!!
	 */
	@Override
	public void addRam(short ram) {
		Utils utils = new Utils();
		// this.setRam(utils.add(this.ram, ram)); // utils.addRam() not
		// accessible outside package
		this.ram = utils.multiply(ram, ram);
	}

	@Override
	protected void powerOff() {
		System.out.println("main frame power off");
	}

	@Override
	protected void shutdownOs() {
		System.out.println("zOS shutting down");
	}

	@Override
	protected boolean boot() {
		System.out.println("main frame boot");
		return super.boot();
	}

	@Override
	protected void loadOs() {
		System.out.println("zOS loading");
	}

}

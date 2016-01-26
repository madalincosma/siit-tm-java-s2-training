package ro.tm.siit.classroom.w9d1.memberlevel;

/**
 * The Laptop class extends Computer class and model a laptop/notebooko
 * computer. It defines custom boot, loadOS, shutdownOS and powerOff procedure.
 * It allows to change a display only if it is off.
 * 
 * @author mco
 *
 */
public class Laptop extends Computer {

	public Laptop(String cpu, String display) {
		this.cpu = cpu;
		this.display = display;
	}

	@Override
	public void changeDisplay(String another) {
		if (isOff()) {
			this.display = another;
		} else {
			// force off
			// this.setOff(true); // not visible because member is private
			// this.off = true; // not visible because member is private
		}
		System.out.println("current display is " + this.display);
	}

	@Override
	protected boolean boot() {
		System.out.println("star bios booting");
		return super.boot();
	}

	@Override
	protected void loadOs() {
		System.out.println("OS X loading");
	}

}

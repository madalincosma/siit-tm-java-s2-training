package ro.tm.siit.classroom.w9d1.memberlevel;

/**
 * The Desktop class extends Computer class and model a desktop computer. It
 * defines custom boot, loadOS, shutdownOS and powerOff procedure. It allows to change a display.
 * 
 * @author mco
 *
 */
public class Desktop extends Computer {

	@Override
	protected boolean boot() {
		// this.setOff(false); // is private - no access outside its class
		System.out.println("star bios booting");
		return super.boot();
	}

	@Override
	protected void loadOs() {
		System.out.println("winxp loading");
	}

	@Override
	public void changeDisplay(String another) {
		this.display = another;
		System.out.println("current display is " + this.display);
	}

}

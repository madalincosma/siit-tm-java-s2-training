package ro.tm.siit.classroom.w10d1;

/**
 * The FinalApp class is an app showing how final local variables work.
 * @author mco
 *
 */
public class FinalApp {

	/**
	 * shows how final variables can be used
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int a;
		final int b = 5;
		int c = 0;
		{
			int aa =4;
		}
		a=4;
		//a=33;// already init
		//b = 14; // already init
		c = 4;
		c = 7;
		
		//aa = 45; //not avail in this statements block

	}

}

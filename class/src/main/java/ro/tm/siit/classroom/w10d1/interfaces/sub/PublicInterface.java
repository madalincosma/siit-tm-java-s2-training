package ro.tm.siit.classroom.w10d1.interfaces.sub;

/**
 * PublicInterface interface defines operations like run or count
 * @author mco
 *
 */
public interface PublicInterface {

	/**
	 * performs a task
	 */
	public void run();
	
	/**
	 * counts the progress
	 * @return an int value between 0 and 100
	 */
	int count();
}

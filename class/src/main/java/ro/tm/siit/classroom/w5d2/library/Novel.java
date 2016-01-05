package ro.tm.siit.classroom.w5d2.library;

/**
 * It represents a special type of book, a novel. It allows to define the novel
 * type.
 * 
 * @author mco
 *
 */
public class Novel extends Book {

	/**
	 * the tyep of novel
	 */
	private String type = "sf";

	@Override
	public String print() {
		return super.print() + " " + type;
	}

}

package ro.tm.siit.classroom.w5d2.library;

/**
 * Core abstraction in a library; it contains a name and a number of pages.
 * @author mco
 *
 */
public class Book {
	
	/**
	 * the name of the book
	 */
	private String name;
	
	/**
	 * the number of pages
	 */
	private int noOfPages;
	
	/**
	 * sets the book name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the book name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the relevant info for this book
	 * @return
	 */
	public String print() {
		return name + " " + noOfPages;
	}

}

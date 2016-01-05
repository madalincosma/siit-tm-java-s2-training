package ro.tm.siit.classroom.w5d2.library;

/**
 * This is a java application simulating a library.
 * 
 * @author mco
 *
 */
public class LibraryApp {

	/**
	 * the starting point in a java application; it contains core logic
	 * operating a library.o
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		LibraryCatalog catalog = new LibraryCatalog();
		catalog.list();

		Book b = new Book();
		b.setName("book1");
		catalog.add(b);

		Novel novel = new Novel();
		novel.setName("novel");
		catalog.add(novel);

		ArtAlbum art = new ArtAlbum();
		art.setName("arta");
		catalog.add(art);

		catalog.list();

	}

}

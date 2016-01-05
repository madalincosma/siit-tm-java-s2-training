package ro.tm.siit.classroom.w5d2.library;

/**
 * It represents the books available in a library in form of a catalog. Allows
 * to add, remove or to list the books in the catalog.
 * 
 * @author mco
 *
 */
public class LibraryCatalog {

	/**
	 * stores the books from the catalog; limited to 1000 books
	 */
	private Book[] books = new Book[1000];
	
	/**
	 * number of books in the catalog
	 */
	private int index = 0;

	/**
	 * add a book to the catalog
	 * @param book the book to be added
	 */
	public void add(Book book) {
		books[index++] = book;
		return;
	}

	/**
	 * deletes last book
	 * @return true if deleted
	 */
	public boolean deleteLast() {
		index--;
		return true;
	}

	/**
	 * delete a book from the catalog
	 * @param book the book to be removed
	 * @return true if deleted
	 */
	public boolean delete(Book book) {
		int localIndex = 0;
		for (Book crtBook : books) {
			if (crtBook != null && crtBook.equals(book)) {
				books[localIndex] = null;
				return true;
			}
			localIndex++;
		}
		return false;
	}

	/**
	 * prints to console all books in the catalog
	 */
	public void list() {
		for (Book book : books) {
			if (book != null) {
				System.out.println(book.print());
			}
		}
	}

}

package ro.tm.siit.classroom.w9d2.domaindefinition;

/**
 * The Size class model the size of a rectangular 3D object.
 * 
 * @author mco
 *
 */
class Size {

	/**
	 * the length
	 */
	private float lenght;

	/**
	 * the width
	 */
	private float width;

	/**
	 * the height
	 */
	private float height;

	/**
	 * made private to allow construction
	 */
	private Size() {

	}

	/**
	 * creates a Size for a 3D rectangular object
	 * @param lenght the physical length
	 * @param width the physical width
	 * @param height the physical height
	 * @return a Size object
	 */
	static Size createSize(float lenght, float width, float height) {
		Size size = new Size();
		size.lenght = lenght;
		size.width = width;
		size.height = height;

		return size;
	}
}

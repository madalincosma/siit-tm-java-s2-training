package ro.tm.siit.classroom.w11d2;

/**
 * The StringsAndCharsApp class is a program that shows how texts can be
 * represented with String or char[] and what are the subtle differences.
 * 
 * @author mco
 *
 */
public class StringsAndCharsApp {

	/**
	 * it shows how same text can be represented with String or char[], that the
	 * text can be changed in both cases, but for the String it will generated a
	 * new object due to immutable property of String class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "Geo";
		char[] letters = new char[] { 'G', 'e', 'o' };
		System.out.println(name);
		System.out.println(letters);

		letters[0] = 'L';
		String another;
		another = name.replace('G', 'L'); // every operation that affects the value of the string will actually generate a new String object !!!
		System.out.println(name);
		System.out.println(letters);
		System.out.println(another);
	}

}

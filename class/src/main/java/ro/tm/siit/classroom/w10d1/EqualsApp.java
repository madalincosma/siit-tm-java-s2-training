package ro.tm.siit.classroom.w10d1;

/**
 * EqualsApp class is a java app showing how identity and equality tests works.
 * 
 * @author mco
 *
 */
public class EqualsApp {

	/**
	 * checks identity and equality for Strings
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = s1;
		String s3 = new String("abc");

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	}

}

package ro.tm.siit.classroom.w8d3;

/**
 * The PrimitiveVarsApp class primitive type variable declaration and
 * assignment, allowed values.
 * 
 * @author mco
 *
 */
public class PrimitiveVarsApp {

	public static void main(String[] args) {

		byte byteValue;
		short shortValue;
		int intValue;
		long longValue;

		boolean booleanValue;

		char character;

		float floatValue;
		double doubleValue;

		intValue = 23;

		character = '2';
		character = 'q';
		character = 'A';
		character = '$';
		character = '(';
		String x = "e";

		booleanValue = true;
		booleanValue = false;

		floatValue = 1234;
		floatValue = 1.2f;
		longValue = 48l;
		doubleValue = 85.2d;
		shortValue = 54;
		byteValue = 4;

		byteValue = 127;// -128, 127 -->2pow8 -->
		shortValue = 32767; // 2pow16 -2pow15, 2pow15-1

	}

}

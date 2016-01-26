package ro.tm.siit.classroom.w9d1.classlevel.otherpackage;

/**
 * The Person class models a person. The class is availble only in current
 * package.
 * 
 * @author mco
 *
 */
class Person {

	private String name = "john";

	@Override
	public String toString() {
		return name;
	}

}

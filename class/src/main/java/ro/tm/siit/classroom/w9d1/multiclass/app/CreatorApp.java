package ro.tm.siit.classroom.w9d1.multiclass.app;

import ro.tm.siit.classroom.w9d1.multiclass.God;
import ro.tm.siit.classroom.w9d1.multiclass.Person;

/**
 * The CreatorApp class creates a program while trying to show that multiple
 * classes can be defined in a file.O
 * 
 * @author mco
 *
 */
public class CreatorApp {

	/**
	 * the starting point in a java application; it demonstrates that outside of
	 * package where are defined, no one know how man and woman is implemented
	 * (in this case via inheritance)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Person john = Person.createMan("john");

		God god = new God();
		Person henry = god.makeMan("henry");
		Person mary = god.makeWoman("maria");

		System.out.println(henry);
		System.out.println(mary);
		System.out.println(john);

		Person[] persons = { henry, mary, john };
		for (Person person : persons) {
			person.talk();
		}

		// Man man;
	}

}

package ro.tm.siit.classroom.w16d2;

import java.util.Comparator;

/**
 * The PersonComparator class implements Comparator<Person> using
 * person.getName() DESC order logic.
 * 
 * @author mco
 *
 */
public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName()) * -1;
	}

}

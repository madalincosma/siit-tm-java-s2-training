package ro.tm.siit.classroom.w16d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSetWithExternalComparatorApp class exhibits usage of TreeSet objects
 * (creation, adding elements, traversing the collection) with an Comparator
 * defined as top level class. Also a List with same elements is created and then
 * Collections.sort() is invoked to obtain same sorting/end-result.
 * 
 * @author mco
 *
 */
public class TreeSetWithExternalComparatorApp {

	public static void main(String[] args) {
		PersonComparator comparator = new PersonComparator();
		Set<Person> set = new TreeSet<>(comparator);
		set.add(new Person("ion"));
		set.add(new Person("ciprian"));
		set.add(new Person("claudiu"));

		for (Person person : set) {
			System.out.println(person.getName());
		}

		List<Person> list = new ArrayList<>();
		list.add(new Person("ion"));
		list.add(new Person("ciprian"));
		list.add(new Person("claudiu"));

		Collections.sort(list, comparator);

		for (Person person : list) {
			System.out.println(person.getName());
		}

	}

}

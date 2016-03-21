package ro.tm.siit.classroom.w16d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TreeSetWithExternalComparatorsApp class exhibits usage of chained
 * Comparators. A List is created and then Collections.sort() is invoked to
 * obtain same sorting using chained comparators.
 * 
 * @author mco
 *
 */
public class TreeSetWithExternalComparatorsApp {

	public static void main(String[] args) {
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName()) * -1;
			}
		};
		Comparator<Person> otherComparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
			}
		};

		Comparator<Person> chainedComparators = comparator.thenComparing(otherComparator);

		List<Person> list = new ArrayList<>();
		list.add(new Person("ion", 21));
		list.add(new Person("ciprian", 23));
		list.add(new Person("ciprian", 4));
		list.add(new Person("claudiu", 25));

		Collections.sort(list, chainedComparators);

		for (Person person : list) {
			System.out.println(person);
		}

	}

}

package ro.tm.siit.classroom.w16d1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSetPersonsApp class exhibits usage of HashSet objects (creation,
 * adding elements, traversing the collection).
 * 
 * @author mco
 *
 */
public class HashSetPersonsApp {

	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		Person ion = new Person("ion");
		set.add(ion);
		Person ion1 = new Person("ion");
		set.add(ion1);
		System.out.println(ion.equals(ion1));
		set.add(new Employee("ciprian"));
		set.add(new Student("claudiu"));

		for (Person person : set) {
			System.out.println(person.getName());
			// set.remove(person); ConcurrentModificationException
		}

		System.out.println(set.size());

		Iterator<Person> iterator = set.iterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName());
			iterator.remove();
		}

		System.out.println(set.size());

	}

}

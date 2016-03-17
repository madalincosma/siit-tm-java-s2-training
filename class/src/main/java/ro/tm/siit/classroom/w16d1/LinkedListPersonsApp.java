package ro.tm.siit.classroom.w16d1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedListPersonsApp class exhibits usage of LinkedList objects (creation,
 * adding elements, traversing the collection).
 * 
 * @author mco
 *
 */
public class LinkedListPersonsApp {

	public static void main(String[] args) {
		List<Person> list = new LinkedList<>();
		Person ion = new Person("ion");
		list.add(ion);
		list.add(new Employee("ciprian"));
		list.add(new Student("claudiu"));

		for (Person person : list) {
			System.out.println(person.getName());
			// list.remove(person); ConcurrentModificationException
		}

		for (int i = 0; i < list.size(); i++) {
			Person person = list.get(i);
			System.out.println(person.getName());
		}

		System.out.println(list.size());

		Iterator<Person> iterator = list.iterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName());
			iterator.remove();
		}

		System.out.println(list.size());

	}

}

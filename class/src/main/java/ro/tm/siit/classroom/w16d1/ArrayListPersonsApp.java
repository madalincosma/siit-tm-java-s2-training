package ro.tm.siit.classroom.w16d1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayListPersonsApp class exhibits usage of ArrayList objects (creation,
 * adding elements, traversing the collection).
 * 
 * @author mco
 *
 */
public class ArrayListPersonsApp {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("ion"));
		list.add(new Employee("ciprian"));
		list.add(new Student("claudiu"));

		for (Person person : list) {
			System.out.println(person.getName());
			// list.remove(person); ConcurrentModificationException
		}

		Iterator<Person> iterator = list.iterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName());
		}

	}

}

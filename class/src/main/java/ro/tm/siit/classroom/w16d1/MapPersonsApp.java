package ro.tm.siit.classroom.w16d1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * MapPersonsApp class exhibits usage of HashMap objects (creation,
 * putting <K,V> pairs, traversing the collection in multiple ways).
 * 
 * @author mco
 *
 */
public class MapPersonsApp {

	public static void main(String[] args) {
		Map<String, Person> map = new HashMap<>();
		map.put("ionica", new Person("ion"));
		map.put("sacalu", new Employee("ciprian"));
		map.put("dansatoru", new Student("claudiu"));

		for (Person person : map.values()) {
			System.out.println(person.getName());
		}

		for (String nick : map.keySet()) {
			System.out.println(map.get(nick).getName());
			// map.remove(nick); ConcurrentModificationException
		}

		for (Entry<String, Person> entry : map.entrySet()) {
			System.out.println(entry.getValue().getName());
			// map.remove(entry.getKey(), entry.getValue()); ConcurrentModificationException
		}

		Iterator<Person> iterator = map.values().iterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName());
		}

	}

}

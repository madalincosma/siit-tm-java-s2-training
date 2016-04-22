/**
 * 
 */
package ro.tm.siit.classroom.w19d2.persons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author mco
 *
 */
public class PersonsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Persistence storage = new Persistence();
		List<Person> persons = storage.loadPersons();
		if (persons == null) {
			persons = new ArrayList<>();
		}

		String line = null;
		Scanner console = new Scanner(System.in);
		do {
			System.out.println("Choose options by typing:");
			System.out.println("add - add a new person");
			System.out.println("print - to display all persons");
			System.out.println("exit - to exit the app and save the persons into a file");
			line = console.nextLine();
			switch (line) {
			case "add":
				System.out.println("first name:");
				String first = console.nextLine();
				System.out.println("last name");
				String last = console.nextLine();
				System.out.println("sex [M/F]");
				String sexStr = console.nextLine();
				System.out.println("age");
				String ageStr = console.nextLine();

				Person.Sex sex = Person.Sex.valueOf(sexStr);
				if (sex == null) {
					System.out.println("sex is not defined: " + sexStr);
				} else {
					try {
						int age = Integer.valueOf(ageStr);
						Person person = new Person(first, last, sex, age);
						persons.add(person);
					} catch (NumberFormatException e) {
						System.out.println("age is not valid: " + ageStr);
					}
				}
				break;
			case "print":
				Collections.sort(persons, Person.ageComparator());
				for (Person p : persons) {
					System.out.println(p);
				}
				break;
			case "exit":
				break;
			default:
				System.out.println("command is not known: " + line);
			}

		} while (!"exit".equals(line));

		Collections.sort(persons);
		System.out.println();
		System.out.println("saved persons");
		for (Person p : persons) {
			System.out.println(p);
		}
		storage.savePersons(persons);

	}

}

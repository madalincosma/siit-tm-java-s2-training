/**
 * 
 */
package ro.tm.siit.classroom.w19d2.persons;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author mco
 *
 */
public class Person implements Serializable, Comparable {

	public enum Sex {
		M, F
	};

	private String first;
	private String last;
	private Sex sex;
	private int age;

	public Person(String first, String last, Sex sex, int age) {
		super();
		this.first = first;
		this.last = last;
		this.sex = sex;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [first=" + first + ", last=" + last + ", sex=" + sex + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		if (first.compareTo(p.first) == 0) {
			return last.compareTo(p.last);
		}
		return first.compareTo(p.first);
	}

	public static Comparator<Person> ageComparator() {
		return new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return -1 * Integer.valueOf(o1.age).compareTo(o2.age);
			}
		};
	}
}

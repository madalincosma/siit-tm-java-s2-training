package ro.tm.siit.classroom.w12d1.contest;

/**
 * The ContestApp class manages a contest for most successful entites. The
 * participants are Persons and/or Companies.
 * 
 * @author mco
 *
 */
public class ContestApp {

	/**
	 * main entry in a java application; creates persons(entrepreneur) or
	 * employee and companies, prints each of them to display the success index
	 * and then looks up for the most successful person and company.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SuccessfulEntity[] allContenders = new SuccessfulEntity[7];
		Person[] persons = new Person[4];
		Company[] companies = new Company[3];

		Person ionAntre = new Person("ion-antre", 5000, 10);
		persons[0] = ionAntre;
		allContenders[0] = ionAntre;
		Employee gigel = new Employee("gigel", 2000, 5);
		persons[1] = gigel;
		allContenders[1] = gigel;
		Employee marcel = new Employee("marcel", 1500, 3);
		persons[2] = marcel;
		allContenders[2] = marcel;
		Employee sorin = new Employee("sorin", 2200, 5);
		persons[3] = sorin;
		allContenders[3] = sorin;
		Employee dan = new Employee("dan", 2700, 5);
		Employee cristi = new Employee("cristi", 2700, 5);
		allContenders[4] = new Company("abc", dan);
		companies[0] = (Company) allContenders[4];
		allContenders[5] = new Company("xyz sa", gigel, marcel, sorin, cristi);
		companies[1] = (Company) allContenders[5];
		allContenders[6] = new Company("fake company");
		companies[2] = (Company) allContenders[6];

		for (SuccessfulEntity entity : allContenders) {
			System.out.println(entity);
		}

		System.out.println();
		findMostSuccessfulPerson(persons);
		System.out.println();
		findMostSuccessfulCompany(companies);

	}

	/**
	 * prints the most successful company; the one with lowest success index
	 * 
	 * @param companies
	 *            the companies to be processedo
	 */
	private static void findMostSuccessfulCompany(Company[] companies) {
		Company min = companies[0];
		for (Company c : companies) {
			if (min.getSuccessIndex() > c.getSuccessIndex()) {
				min = c;
			}
		}
		System.out.println("best company award: " + min);

	}

	/**
	 * prints the most successful person; the person with highest success indexo
	 * 
	 * @param persons
	 *            the persons to be processed
	 */
	private static void findMostSuccessfulPerson(Person[] persons) {
		Person max = persons[0];
		for (Person c : persons) {
			if (max.getSuccessIndex() < c.getSuccessIndex()) {
				max = c;
			}
		}
		System.out.println("best person award: " + max);
	}

}

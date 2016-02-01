package ro.tm.siit.homework.w7d2.happyfamily;

/**
 * The HappyFamilyApp class is an application which creates persons, families
 * and verifies whether they are happy or not
 * 
 * @author mco
 *
 */
public class HappyFamilyApp {

	/**
	 * the starting point in a java application; it instances persons (men,
	 * women and kids) and then creates families made by these persons and then
	 * verifies if the families are happy or not It also verifies if every adult
	 * person is happy
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Family[] family = new Family[3];

		Man florin = new Man("Florin", 34);
		Woman camelia = new Woman("Camelia", 32);
		Man radu = new Man("Radu", 33);
		Woman andreea = new Woman("Andreea", 25);
		Man john = new Man("john", 12);
		Woman mary = new Woman("mary", 14);
		Man mike = new Man("mike", 24);

		Person[] persons = new Person[] { florin, camelia, radu, andreea, john, mike, mary };

		Man boy = new Man("Andrei", 15);
		boy.addGrade((byte)9);
		boy.addGadget("play-station");
		Woman girl = new Woman("Alexandra", 12);

		florin.addGadget("smart-watch");
		andreea.makeBoyfriend();
		andreea.withCareer();

		family[0] = new Family(florin, camelia);
		family[1] = new Family(radu, andreea);
		family[2] = new Family(john, mary);

		family[0].addKid(boy);
		family[1].addKid(girl);

		for (Family f : family) {
			if (f.isHappy()) {
				System.out.println(f + " is happy");
			} else {
				System.out.println(f + " is not happy");
			}
		}

		for (Person p : persons) {
			if (p.isSingle()) {
				System.out.println(p);
			}
		}
	}
}

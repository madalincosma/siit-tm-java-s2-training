package ro.tm.siit.classroom.w15d2.unittesting;


class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public boolean isYoung() {
		return (age < 35);
	}
}

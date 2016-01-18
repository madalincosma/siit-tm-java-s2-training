package ro.tm.siit.classroom.w8d1;

public class UsefulAutoboxingApp {

	public static void main(String[] args) {
		
		Integer someNumber= new Integer("33");
		Integer someOtherNumber = new Integer("4");
		System.out.println(someNumber * someOtherNumber);
		System.out.println(someNumber + someOtherNumber);
		System.out.println("3" + "4");

	}

}

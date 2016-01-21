package ro.tm.siit.classroom.w8d3;

/**
 * StaticVsInstanceApp class plays with static and instance variables.
 * @author mco
 *
 */
public class StaticVsInstanceApp {
	
	private static int counter = 0;
	
	private String instance;

	public static void main(String[] args) {
		StaticVsInstanceApp  obj = new StaticVsInstanceApp();
		StaticVsInstanceApp.counter++; // static vars allowed
		StaticVsInstanceApp obj1 = new StaticVsInstanceApp();
		StaticVsInstanceApp.counter++;
		
		obj.instance = "asd";
		obj1.instance = "qwer";
		
		//instance = "wer"; // instance field not allowed
		
		//print(); instance method call not allowed
		
		obj.print();

	}
	
	public void print() {
		System.out.println(this.instance); //instance var allowed
		System.out.println(StaticVsInstanceApp.counter); // static var allowed
	}

}

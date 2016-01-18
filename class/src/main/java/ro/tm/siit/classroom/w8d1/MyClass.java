package ro.tm.siit.classroom.w8d1;

public class MyClass {
	
	/**
	 * javadoc comment
	 */
	private int value = 5;
	
	private static int sumOfValues = 0;
	
	{
		// line comment
		value = 25;
	}
	
	static {
		/*
		 * block comment
		 */
		sumOfValues = 0; 
	}
	
	public MyClass(int val) {
		this.value = val;
		sumOfValues += val;//another line comment
	}
	
	public String toString() {
		return "value: " + this.value;
	}
	
	public static int getSumAll() {
		return sumOfValues;
	}	

}

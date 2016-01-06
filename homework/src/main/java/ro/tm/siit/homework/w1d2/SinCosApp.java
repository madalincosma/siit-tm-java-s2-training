package ro.tm.siit.homework.w1d2;

public class SinCosApp {
	
	public static void main(String... args) {
		double x = Double.parseDouble(args[0]);
		double rezultat = Math.pow(Math.sin(x), 2) + Math.pow(Math.cos(x), 2);
		System.out.println(rezultat); // 1 or  0.9999..
	}
}

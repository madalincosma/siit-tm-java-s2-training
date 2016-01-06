package ro.tm.siit.homework.w1d2;

public class TriangleApp {

	public static void main(String... args) {
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		boolean  dreptunghic = false;
		
		if (Math.pow(a, 2)+Math.pow(b, 2) == Math.pow(c, 2))
			dreptunghic = true;
		
		if (Math.pow(b, 2)+Math.pow(c, 2) == Math.pow(a, 2))
			dreptunghic = true;
		
		if (Math.pow(c, 2)+Math.pow(a, 2) == Math.pow(b, 2))
			dreptunghic = true;
		

		if (dreptunghic == true) {
			System.out.println("Triunghiul este dreptunghic");
		} else {
			System.out.println("Triunghiul NU este dreptunghic");
		}	
	}
}

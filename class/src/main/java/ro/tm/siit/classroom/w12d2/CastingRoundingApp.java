package ro.tm.siit.classroom.w11d2;

import ro.tm.siit.classroom.w9d1.multiclass.Person;

public class CastingRoundingApp {

	public static void main(String[] args) {
		int a = (int) 3.3;
		int b = (int) 3.9;
		System.out.println(a + " " + b);
		int e = 5 / 2;
		float f = 5 / 2;
		System.out.println(e + " " + f);
		float h = 5 / 2.0f;
		float g = 5%2;
		float i = 5%2.0f;
		System.out.println(h + " " + g + " " + i);
		
		System.out.println(Math.round(3.3f));
		System.out.println(Math.round(3.1f));
		System.out.println(Math.round(3.9f));
		
		System.out.println(Math.floor(3.3f));
		System.out.println(Math.floor(3.1f));
		System.out.println(Math.floor(3.9f));
		
		System.out.println(Math.ceil(3.3f));
		System.out.println(Math.ceil(3.1f));
		System.out.println(Math.ceil(3.9f));
		
		String s1 = "";
//		Integer i1 = (Integer) s1;// not allowed
		Object o1 = s1;
		Integer i11 = (Integer) o1;
		

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		Person person = new Person("john") {

			@Override
			public void talk() {
				// TODO Auto-generated method stub
				super.talk();
			}
			
		};
		new Thread(runnable).start();
	}

}

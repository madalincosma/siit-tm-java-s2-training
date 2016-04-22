package ro.tm.siit.classroom.w19d2.cars;

import java.util.HashMap;
import java.util.Map;

public class Cars {

	public static void main(String[] args) {

		Map<String, Integer> cars = new HashMap<>();
		
		cars.put("audi a4 b7", 2005);
		cars.put("vw golf 7", 2012);
		
		cars.put("audi a4 b7", 2006);
		
		System.out.println(cars);
		

	}

}

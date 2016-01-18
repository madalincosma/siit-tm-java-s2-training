package ro.tm.siit.classroom.w8d1;

public class AutoboxingApp {

	public static void main(String[] args) {
		int i = 3;
		Integer intObj = i;//
		intObj = new Integer(i);
		intObj = Integer.valueOf(i);
		int k = intObj;
		int sum = i + intObj + k;
		
//		Integer beta = null;
//		k = beta;
//		k  = beta.intValue();

	}

}

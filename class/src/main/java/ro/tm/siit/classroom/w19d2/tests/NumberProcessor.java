package ro.tm.siit.classroom.w19d2.tests;

class NumberProcessor {

	public boolean isEven(int a) {
		if (a < 0) {
			throw new IllegalArgumentException();
		}

		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}

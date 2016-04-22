package ro.tm.siit.classroom.w19d2.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberProcessorTest {

	@Test
	public void testIsEven() {
		NumberProcessor service = new NumberProcessor();
		
		boolean result = service.isEven(4);
		
		assertTrue(result);
	}

	@Test
	public void testIsEvenNot() {
		NumberProcessor service = new NumberProcessor();
		
		boolean result = service.isEven(77);
		
		assertFalse(result);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIsEvenNotPositive() {
		NumberProcessor service = new NumberProcessor();
		
		boolean result = service.isEven(-4);
	}

}

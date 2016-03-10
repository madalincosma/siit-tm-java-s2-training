package ro.tm.siit.classroom.w15d2.unittesting;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.Assert;

public class PersonTest {
	
	@Test
	public void testIsYoungFalse() {
		Person person = new Person("ion", 60);
		
		boolean young = person.isYoung();
		
		assertFalse("expected false", young);
	}
	
	@Test
	public void testIsYoungTrue() {
		Person person = new Person("ionel", 25);
		
		boolean young = person.isYoung();
		
		assertTrue("expected true", young);
	}

}

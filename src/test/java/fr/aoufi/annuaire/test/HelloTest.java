package fr.aoufi.annuaire.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class HelloTest {
	
	@Test
	public void testIfOk() {
		
	//	Assert.fail("Test failure !");
	//	throw new NullPointerException();
		
		assertEquals(3, 5);
		assertFalse(false);
		
		assertTrue(true);
		
	}

}

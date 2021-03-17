package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.*;

import helpers.Jump;

public class JumpTest {
	private static Jump jump = new Jump(3, 7, false, 3);
	
	
	@Test
	public void getStartTest() {
		assertEquals(3, jump.getStart());
	}
	
	@Test
	public void getEndTest() {
		assertEquals(7, jump.getEnd());
	}

	@Test
	public void isMandatoryTest() {
		assertFalse(jump.isMandatory());
	}
	
	@Test
	public void getPriorityTest() {
		assertEquals(3, jump.getPriority());
	}
}

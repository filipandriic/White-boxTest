package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.*;

import helpers.SwitchCases;

public class SwitchCasesTest {
	private static SwitchCases switchCase = new SwitchCases(8);
	
	@BeforeAll
	public static void addCase() {
		switchCase.addCase(1);
	}
	
	@Test
	public void getSwitchIdTest() {
		assertEquals(8, switchCase.getSwitchId());
	}
	
	@Test
	public void containsTest() {
		assertTrue(switchCase.contains(1));
	}
}

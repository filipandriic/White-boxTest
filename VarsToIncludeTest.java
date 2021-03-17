package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import simulator.VarsToInclude;

public class VarsToIncludeTest {
	private static VarsToInclude vars = new VarsToInclude();
	
	@BeforeAll
	public static void before() {
		assertTrue(vars.includeAll());
		vars.scanVars(" ");
		vars.scanVars("Filip Andric 18/273");
	}
	
	@Test
	public void isIncludedTest01() {
		assertTrue(vars.isIncluded("Andric"));
	}
	
	@Test
	public void isIncludedTest02() {
		assertFalse(vars.isIncluded("Nesto"));
	}
	
	@Test
	public void includeAllTest01() {
		assertFalse(vars.includeAll());
	}
	
	@Test
	public void printVarsTest() {
		String s = "Filip\n"
				+ "Andric\n"
				+ "18/273\n";
		assertEquals(s, vars.printVars());
	}
}

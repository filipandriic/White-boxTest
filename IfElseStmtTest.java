package testing;

import helpers.IfElseStmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.*;

public class IfElseStmtTest {
	private static IfElseStmt statement = new IfElseStmt(0);
		
	@BeforeAll
	public static void before() {
		statement.setIfScope(1);
		statement.setElseScope(2);
	}
	
	
	@Test
	public void getIfScopeTest() {
		assertEquals(1, statement.getIfScope());
	}

	@Test
	public void getElseScopeTest() {
		assertEquals(2, statement.getElseScope());
	}

	@Test
	public void getParentIfElseTest() {
		assertEquals(0, statement.getParentIfElse());
	}
	
	@Test
	public void areExclusive01() {
		assertTrue(statement.areExclusive(1, 2));
	}
	
	@Test
	public void areExclusive02() {
		assertTrue(statement.areExclusive(2, 1));
	}
	
	@Test
	public void areExclusive03() {
		assertFalse(statement.areExclusive(1, 3));
	}
	
	@Test
	public void areExclusive04() {
		assertFalse(statement.areExclusive(2, 3));
	}
}

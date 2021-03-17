package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.*;

import helpers.BreakStmt;
import helpers.BreakStmt.BreakType;
import symtable.Scope;

public class BreakStmtTest {
	private static BreakStmt statement = new BreakStmt(1, 2, BreakType.LOOP_BREAK, null);
	
	@Test
	public void getRowNoTest() {
		assertEquals(1, statement.getRowNo());
	}

	@Test
	public void getScopeIdTest() {
		assertEquals(2, statement.getScopeId());
	}

	@Test
	public void getTypeTest() {
		assertEquals(BreakType.LOOP_BREAK, statement.getType());
	}

	@Test
	public void getBelongsToScopeTest() {
		assertNull(statement.getBelongsToScope());
	}
}

package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import simulator.Definition;
import symtable.Scope;
import symtable.Scope.ScopeType;

public class DefinitionTest {
	private static Scope scope = new Scope(null, 0, ScopeType.CASE);
	private static Definition definition = new Definition("var", 1, scope);

	
	@Test
	public void getVariable() {
		assertEquals("var", definition.getVariable());
	}
	
	@Test
	public void getRowNo() {
		assertEquals(1, definition.getRowNo());
	}
	
	@Test
	public void getScope() {
		assertEquals(scope, definition.getScope());
	}
}

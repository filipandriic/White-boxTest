package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import simulator.Use;
import symtable.Scope;
import symtable.Scope.ScopeType;

public class UseTest {
	private static Scope scope = new Scope(null, 0, ScopeType.CASE);
	private static Use use = new Use("var", 3, 'c', scope);
	
	@BeforeAll
	public static void setAll() {
		use.setConditionFor(3);
	}

	@Test
	public void getConditionForTest() {
		assertEquals(3, use.getConditionFor());
	}

	@Test
	public void getVariableTest() {
		assertEquals("var", use.getVariable());
	}
	
	@Test
	public void getRowNoTest() {
		assertEquals(3, use.getRowNo());
	}
	
	@Test
	public void getTypeTest() {
		assertEquals('c', use.getType());
	}
	
	@Test
	public void getScopeTest() {
		assertEquals(scope, use.getScope());
	}
}

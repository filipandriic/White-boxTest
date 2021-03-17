package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import simulator.DUChain;

public class DUChainTest {
	private static DUChain chain = new DUChain("chain", 3, 5);
	
	@Test
	public void getVariableTest() {
		assertEquals("chain", chain.getVariable());
	}
	
	@Test
	public void getRowNoDefTest() {
		assertEquals(3, chain.getRowNoDef());
	}
	
	@Test
	public void getRowNoUseTest() {
		assertEquals(5, chain.getRowNoUse());
	}
}

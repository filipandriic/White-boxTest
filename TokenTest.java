package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import simulator.Token;

public class TokenTest {
	private static Token token = new Token("", 0);
	
	@BeforeAll
	public static void setAll() {
		token.setToken("token");
		token.setRowNo(4);
	}
	
	@Test
	public void getTokenTest() {
		assertEquals("token", token.getToken());
	}

	@Test
	public void getRowNoTest() {
		assertEquals(4, token.getRowNo());
	}

}

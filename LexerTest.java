package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import simulator.Lexer;

public class LexerTest {
	private static Lexer lexer = new Lexer();
	
	@BeforeAll
	public static void before() {
		assertNull(lexer.nextToken());
		assertNull(lexer.peakNextToken());
		lexer.addUserType("myType");
		lexer.addConstant("const");
		
		String s = "int\n j = 0;\n"
				+ "for (int i = 0; i < 100; i++) {\n"
				+ "\tj++;\n"
				+ "}\n";
		s += "String s = String\"\"\n"
				+ "s = \"C:\\Users\"\n";
		s += "char c = char\'\'\n"
				+ "s = \'a'\n";
		//Ako se stavi s = \"\\\" ili \'\\\' ostaje u beskonacnoj while petlji
		lexer.scanCode(s);
	}
	
	@Test
	public void nextTokenTest01() {
		assertEquals("int", lexer.nextToken().getToken());
	}
	
	@Test
	public void peakNextTokenTest01() {
		assertEquals("j", lexer.peakNextToken().getToken());
	}
	
	@Test
	public void isKeywordTest01() {
		assertTrue(lexer.isKeyword("assert"));
	}
	
	@Test
	public void isKeywordTest02() {
		assertFalse(lexer.isKeyword("nesto"));
	}
	
	@Test
	public void isTypeTest01() {
		assertTrue(lexer.isType("myType"));
	}
	
	@Test
	public void isTypeTest02() {
		assertTrue(lexer.isType("Thread"));
	}
	
	@Test
	public void isTypeTest03() {
		assertTrue(lexer.isType("short"));
	}
	
	@Test
	public void isTypeTest04() {
		assertFalse(lexer.isType("none"));
	}
	
	@Test
	public void isAccessModifierTest01() {
		assertTrue(lexer.isAccessModifier("private"));
	}
	
	@Test
	public void isAccessModifierTest02() {
		assertFalse(lexer.isAccessModifier("none"));
	}
	
	@Test
	public void isLiteralTest01() {
		assertTrue(lexer.isLiteral("volatile"));
	}
	
	@Test
	public void isLiteralTest02() {
		assertFalse(lexer.isLiteral("none"));
	}
	
	@Test
	public void isValueTest01() {
		assertTrue(lexer.isValue("null"));
	}
	
	@Test
	public void isValueTest02() {
		assertFalse(lexer.isValue("none"));
	}
	
	@Test
	public void isValueTest03() {
		assertTrue(lexer.isValue("5"));
	}
	
	@Test
	public void isValueTest04() {
		assertTrue(lexer.isValue("\'"));
	}
	
	@Test
	public void isValueTest05() {
		assertTrue(lexer.isValue("\""));
	}
	
	@Test
	public void isConstTest01() {
		assertTrue(lexer.isConst("const"));
	}
	
	@Test
	public void isConstTest02() {
		assertFalse(lexer.isConst("none"));
	}

	@Test
	public void isVariableTest01() {
		assertTrue(lexer.isVariable("this"));
	}
	
	@Test
	public void isVariableTest02() {
		assertFalse(lexer.isVariable("1static"));
	}
	
	@Test
	public void isVariableTest03() {
		assertTrue(lexer.isVariable("None"));
	}
	
	@Test
	public void isVariableTest04() {
		assertTrue(lexer.isVariable("_none"));
	}
	
	@Test
	public void isVariableTest05() {
		assertFalse(lexer.isVariable("~static"));
	}
	
	@Test
	public void isVariableTest06() {
		assertFalse(lexer.isVariable("true"));
	}
	
	@Test
	public void isVariableTest07() {
		assertFalse(lexer.isVariable("static"));
	}
	
	@Test
	public void isVariableTest08() {
		assertFalse(lexer.isVariable("continue"));
	}
	
	@Test
	public void isVariableTest09() {
		assertFalse(lexer.isVariable("Exception"));
	}
	
	@Test
	public void isVariableTest10() {
		assertFalse(lexer.isVariable("boolean"));
	}
	
	@Test
	public void isVariableTest11() {
		assertFalse(lexer.isVariable("public"));
	}
	
//	@Test
//	public void isVariableTest12() {
//		assertFalse(lexer.isVariable("const"));
//	}
	
	@Test
	public void hasThisTest01() {
		assertTrue(lexer.hasThis("nonethisnone"));
	}
	
	@Test
	public void hasThisTest02() {
		assertFalse(lexer.hasThis("none"));
	}
	
	@Test
	public void getTopObjectTest01() {
		//Bag ukoliko nema ni jedne tacke
		assertEquals("none", lexer.getTopObject("none."));
	}
	
}

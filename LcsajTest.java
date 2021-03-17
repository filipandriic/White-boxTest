package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import simulator.Lcsaj;

public class LcsajTest {
	private static Lcsaj lcsaj = new Lcsaj(0, 0, 0);
	
	@BeforeAll
	public static void setAll() {
		lcsaj.setStartSeq(2);
		lcsaj.setEndSeq(8);
		lcsaj.setJump(10);
	}

	@Test
	public void getStartSeqTest() {
		assertEquals(2, lcsaj.getStartSeq());
	}

	@Test
	public void getEndSeqTest() {
		assertEquals(8, lcsaj.getEndSeq());
	}

	@Test
	public void getJumpTest() {
		assertEquals(10, lcsaj.getJump());
	}

}

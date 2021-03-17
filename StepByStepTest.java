package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import gui.MainWindow;

public class StepByStepTest {
	
	private static MainWindow main = new MainWindow();
	private static String input = new String();

	@BeforeAll
	public static void loadFile() {
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\ProjekatTS\\dz2\\Java04\\Java04_DUSim\\Test primeri\\DU\\Test3.txt"));
		    
		    String line = null;
		    do {
		    	line = bufferedReader.readLine();
		    	input += line + '\n';
		    } while (line != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		finally {
			
			main.getCodeArea().setText(input);
			main.getStartButton().doClick();
			main.getStartButton().doClick();
			main.getStartButton().doClick();
			
		    if (bufferedReader != null) {
		        try {
		        	bufferedReader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	@Test
	public void StepByStepModeTest() {
		assertTrue(main.getSimulator().isStepByStep());
	}
	
	@Test
	public void DefinitionTest() {
		System.out.println(main.getDefArea().getText());
		
		String expect = "ID (red 2)\n"
				+ "IG (red 3)\n";
		
		
		assertEquals(expect, main.getDefArea().getText());
			
	}
	
	@Test
	public void UseTest() {
		System.out.println(main.getUseArea().getText());
		
		String expect = "N (red 3, c-upotreba)\n"
				+ "ID (red 4, p-upotreba)\n"
				+ "IG (red 4, p-upotreba)\n";
		
		
		assertEquals(expect, main.getUseArea().getText());
	}
	
	@Test
	public void DUTest() {
		System.out.println(main.getdDUChainsArea().getText());
		
		String expect = "[ID, 2, 4]\n"
				+ "[IG, 3, 4]\n";
		
		assertEquals(expect, main.getdDUChainsArea().getText());
	}
	
	@Test
	public void LCSAJTest() {
		System.out.println(main.getSimulator().getLcsaj());
		
		String expect = "(1, 4, 10)\n"
				+ "(1, 6, 7)\n"
				+ "(1, 6, 9)\n"
				+ "(4, 4, 10)\n"
				+ "(4, 6, 7)\n"
				+ "(4, 6, 9)\n"
				+ "(7, 9, 4)\n"
				+ "(7, 7, 8)\n"
				+ "(7, 7, 9)\n"
				+ "(8, 9, 4)\n"
				+ "(9, 9, 4)\n"
				+ "(10, 12)\n"
				+ "\n"
				+ "Broj LCSAJ sekvenci: 12";
		
		
		assertEquals(expect, main.getSimulator().getLcsaj());
	}
	
	@AfterAll
	public static void delete()
	{
		main = null;
	}
}

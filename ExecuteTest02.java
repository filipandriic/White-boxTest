package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.*;

import gui.MainWindow;

public class ExecuteTest02 {
	
	private static MainWindow main = new MainWindow();
	private static String input = new String();
	
	@BeforeAll
	public static void loadFile() {
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\ProjekatTS\\dz2\\Java04\\Java04_DUSim\\Test primeri\\TEST\\Test.txt"));
		    
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
			main.getFinishButton().doClick();
			
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
	public void DefinitionTest() {
		System.out.println(main.getSimulator().getDefinitions());
		
		String expect = "id (red 3)\n"
				+ "myID (red 7)\n"
				+ "id (red 7)\n"
				+ "i (red 11)\n"
				+ "i (red 13)\n"
				+ "i (red 16)\n"
				+ "i (red 20)\n"
				+ "i (red 23)\n"
				+ "i (red 28)\n"
				+ "i (red 31)\n"
				+ "j (red 35)\n"
				+ "j (red 35)\n"
				+ "i (red 36)\n"
				+ "myID (red 38)\n"
				+ "\n"
				+ "Broj definicija: 14";
		
		
		assertEquals(expect, main.getSimulator().getDefinitions());
			
	}
	
	@Test
	public void UseTest() {
		System.out.println(main.getSimulator().getUses());
		
		String expect = "id (red 7, c-upotreba)\n"
				+ "id (red 7, c-upotreba)\n"
				+ "i (red 12, p-upotreba)\n"
				+ "i (red 13, c-upotreba)\n"
				+ "i (red 16, c-upotreba)\n"
				+ "i (red 17, p-upotreba)\n"
				+ "i (red 19, p-upotreba)\n"
				+ "i (red 20, c-upotreba)\n"
				+ "i (red 23, c-upotreba)\n"
				+ "i (red 26, p-upotreba)\n"
				+ "i (red 28, c-upotreba)\n"
				+ "i (red 31, c-upotreba)\n"
				+ "j (red 35, p-upotreba)\n"
				+ "j (red 35, c-upotreba)\n"
				+ "i (red 36, c-upotreba)\n"
				+ "i (red 38, p-upotreba)\n"
				+ "\n"
				+ "Broj c-upotreba: 10\n"
				+ "Broj p-upotreba: 6";
		
		
		assertEquals(expect, main.getSimulator().getUses());
	}
	
	@Test
	public void DUTest() {
		System.out.println(main.getSimulator().getDuChains());
		
		String expect = "[i, 11, 12]\n"
				+ "[i, 11, 13]\n"
				+ "[i, 11, 16]\n"
				+ "[i, 11, 17]\n"
				+ "[i, 11, 19]\n"
				+ "[i, 11, 20]\n"
				+ "[i, 11, 23]\n"
				+ "[i, 11, 26]\n"
				+ "[i, 11, 28]\n"
				+ "[i, 11, 36]\n"
				+ "[i, 11, 38]\n"
				+ "[i, 13, 12]\n"
				+ "[i, 13, 13]\n"
				+ "[i, 13, 16]\n"
				+ "[i, 13, 17]\n"
				+ "[i, 13, 19]\n"
				+ "[i, 13, 20]\n"
				+ "[i, 13, 23]\n"
				+ "[i, 13, 26]\n"
				+ "[i, 13, 28]\n"
				+ "[i, 13, 36]\n"
				+ "[i, 13, 38]\n"
				+ "[i, 16, 16]\n"
				+ "[i, 16, 17]\n"
				+ "[i, 16, 19]\n"
				+ "[i, 16, 20]\n"
				+ "[i, 16, 23]\n"
				+ "[i, 16, 26]\n"
				+ "[i, 16, 28]\n"
				+ "[i, 16, 36]\n"
				+ "[i, 16, 38]\n"
				+ "[i, 20, 26]\n"
				+ "[i, 20, 28]\n"
				+ "[i, 20, 36]\n"
				+ "[i, 20, 38]\n"
				+ "[i, 23, 26]\n"
				+ "[i, 23, 28]\n"
				+ "[i, 23, 36]\n"
				+ "[i, 23, 38]\n"
				+ "[i, 31, 36]\n"
				+ "[i, 31, 38]\n"
				+ "[i, 36, 36]\n"
				+ "[i, 36, 38]\n"
				+ "\n"
				+ "Broj DU-lanaca: 43";
		
		
		assertEquals(expect, main.getSimulator().getDuChains());
	}
	
	@Test
	public void LCSAJTest() {
		System.out.println(main.getSimulator().getLcsaj());
		
		String expect = "(1, 12, 15)\n"
				+ "(1, 14, 12)\n"
				+ "(12, 12, 15)\n"
				+ "(12, 14, 12)\n"
				+ "(15, 17, 15)\n"
				+ "(15, 19, 22)\n"
				+ "(15, 21, 25)\n"
				+ "(22, 27, 30)\n"
				+ "(22, 29, 34)\n"
				+ "(25, 27, 30)\n"
				+ "(25, 29, 34)\n"
				+ "(30, 32, 34)\n"
				+ "(35, 35, 38)\n"
				+ "(35, 37, 35)\n"
				+ "(38, 42)\n"
				+ "\n"
				+ "Broj LCSAJ sekvenci: 15";
		
		
		assertEquals(expect, main.getSimulator().getLcsaj());
	}
	
	@AfterAll
	public static void delete()
	{
		main = null;
	}
	
}
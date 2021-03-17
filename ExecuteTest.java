package testing;

import simulator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.*;

public class ExecuteTest {
	
	private static Simulator simulator = new Simulator();
	private static String input = new String();
	private static String vars = "";
	
	@BeforeAll
	public static void loadFile() {
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\ProjekatTS\\dz2\\Java04\\Java04_DUSim\\Test primeri\\LCSAJ\\Test3.txt"));
		    
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
			simulator.analyseCode(input, vars);
			
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
		System.out.println(simulator.getDefinitions());
		
		String expect = "count (red 2)\n"
				+ "totals (red 2)\n"
				+ "val (red 2)\n"
				+ "count (red 4)\n"
				+ "val (red 6)\n"
				+ "totals (red 7)\n"
				+ "totals (red 9)\n"
				+ "count (red 11)\n"
				+ "\n"
				+ "Broj definicija: 8";
		
		
		assertEquals(expect, simulator.getDefinitions());
			
	}
	
	@Test
	public void UseTest() {
		System.out.println(simulator.getUses());
		
		String expect = "MAXCOLUMNS (red 2, c-upotreba)\n"
				+ "totals (red 3, c-upotreba)\n"
				+ "MAXCOLUMNS (red 3, c-upotreba)\n"
				+ "count (red 5, p-upotreba)\n"
				+ "ITERATIONS (red 5, p-upotreba)\n"
				+ "MAXCOLUMNS (red 6, c-upotreba)\n"
				+ "val (red 7, c-upotreba)\n"
				+ "totals (red 8, p-upotreba)\n"
				+ "val (red 8, p-upotreba)\n"
				+ "MAXCOUNT (red 8, p-upotreba)\n"
				+ "val (red 9, c-upotreba)\n"
				+ "MAXCOUNT (red 9, c-upotreba)\n"
				+ "count (red 11, c-upotreba)\n"
				+ "\n"
				+ "Broj c-upotreba: 8\n"
				+ "Broj p-upotreba: 5";
		
		
		assertEquals(expect, simulator.getUses());
	}
	
	@Test
	public void DUTest() {
		System.out.println(simulator.getDuChains());
		
		String expect = "[totals, 2, 3]\n"
				+ "[count, 4, 5]\n"
				+ "[count, 4, 11]\n"
				+ "[val, 6, 7]\n"
				+ "[val, 6, 8]\n"
				+ "[val, 6, 9]\n"
				+ "[totals, 7, 8]\n"
				+ "[count, 11, 5]\n"
				+ "[count, 11, 11]\n"
				+ "\n"
				+ "Broj DU-lanaca: 9";
		
		
		assertEquals(expect, simulator.getDuChains());
	}
	
	@Test
	public void LCSAJTest() {
		System.out.println(simulator.getLcsaj());
		
		String expect = "(1, 5, 13)\n"
				+ "(1, 12, 5)\n"
				+ "(1, 8, 11)\n"
				+ "(5, 5, 13)\n"
				+ "(5, 12, 5)\n"
				+ "(5, 8, 11)\n"
				+ "(11, 12, 5)\n"
				+ "(13, 15)\n"
				+ "\n"
				+ "Broj LCSAJ sekvenci: 8";
		
		
		assertEquals(expect, simulator.getLcsaj());
	}
	
	@AfterAll
	public static void delete()
	{
		simulator = null;
	}
	
}
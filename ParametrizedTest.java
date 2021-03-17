package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import gui.MainWindow;
import simulator.VarsToInclude;

public class ParametrizedTest {
	private static MainWindow main = new MainWindow();
	private static String input = new String();
	
	@BeforeAll
	public static void loadFile() {
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\ProjekatTS\\dz2\\Java04\\Java04_DUSim\\Test primeri\\LCSAJ\\Test1.txt"));
		    
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
			
		    if (bufferedReader != null) {
		        try {
		        	bufferedReader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/csvFiles/import.csv")
	public void DefinitionTest(String var1, String var2, String var3) {
		VarsToInclude variables = new VarsToInclude();
		StringBuilder sb = new StringBuilder();
		sb.append(var1 + " " + var2 + " " + var3);
		variables.scanVars(sb.toString());
		main.getVarArea1().setText(variables.printVars());
		
		String expect = "brojac (red 4)\n"
				+ "x (red 6)\n"
				+ "y (red 7)\n"
				+ "x (red 10)\n"
				+ "y (red 12)\n"
				+ "brojac (red 13)\n"
				+ "\n"
				+ "Broj definicija: 6";
		
		main.getFinishButton().doClick();
		System.out.println(main.getSimulator().getDefinitions());
		assertEquals(expect, main.getSimulator().getDefinitions());
			
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/csvFiles/import.csv")
	public void UseTest(String var1, String var2, String var3) {
		VarsToInclude variables = new VarsToInclude();
		StringBuilder sb = new StringBuilder();
		sb.append(var1 + " " + var2 + " " + var3);
		variables.scanVars(sb.toString());
		
		String expect = "brojac (red 8, p-upotreba)\n"
				+ "x (red 9, p-upotreba)\n"
				+ "y (red 9, p-upotreba)\n"
				+ "x (red 10, c-upotreba)\n"
				+ "y (red 10, c-upotreba)\n"
				+ "x (red 12, c-upotreba)\n"
				+ "y (red 12, c-upotreba)\n"
				+ "brojac (red 13, c-upotreba)\n"
				+ "x (red 15, c-upotreba)\n"
				+ "y (red 15, c-upotreba)\n"
				+ "\n"
				+ "Broj c-upotreba: 7\n"
				+ "Broj p-upotreba: 3";
		
		main.getFinishButton().doClick();
		System.out.println(main.getSimulator().getUses());
		assertEquals(expect, main.getSimulator().getUses());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/csvFiles/import.csv")
	public void DUTest(String var1, String var2, String var3) {
		VarsToInclude variables = new VarsToInclude();
		StringBuilder sb = new StringBuilder();
		sb.append(var1 + " " + var2 + " " + var3);
		variables.scanVars(sb.toString());
		
		String expect = "[brojac, 4, 8]\n"
				+ "[brojac, 4, 13]\n"
				+ "[x, 6, 9]\n"
				+ "[x, 6, 10]\n"
				+ "[x, 6, 12]\n"
				+ "[x, 6, 15]\n"
				+ "[y, 7, 9]\n"
				+ "[y, 7, 10]\n"
				+ "[y, 7, 12]\n"
				+ "[y, 7, 15]\n"
				+ "[x, 10, 9]\n"
				+ "[x, 10, 10]\n"
				+ "[x, 10, 12]\n"
				+ "[x, 10, 15]\n"
				+ "[y, 12, 9]\n"
				+ "[y, 12, 10]\n"
				+ "[y, 12, 12]\n"
				+ "[y, 12, 15]\n"
				+ "[brojac, 13, 8]\n"
				+ "[brojac, 13, 13]\n"
				+ "\n"
				+ "Broj DU-lanaca: 20";
		
		main.getFinishButton().doClick();
		System.out.println(main.getSimulator().getDuChains());
		assertEquals(expect, main.getSimulator().getDuChains());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/csvFiles/import.csv")
	public void LCSAJTest(String var1, String var2, String var3) {
		VarsToInclude variables = new VarsToInclude();
		StringBuilder sb = new StringBuilder();
		sb.append(var1 + " " + var2 + " " + var3);
		variables.scanVars(sb.toString());
		
		String expect = "(1, 8, 15)\n"
				+ "(1, 9, 11)\n"
				+ "(1, 10, 13)\n"
				+ "(8, 8, 15)\n"
				+ "(8, 9, 11)\n"
				+ "(8, 10, 13)\n"
				+ "(11, 14, 8)\n"
				+ "(13, 14, 8)\n"
				+ "(15, 17)\n"
				+ "\n"
				+ "Broj LCSAJ sekvenci: 9";
		
		main.getFinishButton().doClick();
		System.out.println(main.getSimulator().getLcsaj());
		assertEquals(expect, main.getSimulator().getLcsaj());
	}
	
	@AfterAll
	public static void delete()
	{
		main = null;
	}
}

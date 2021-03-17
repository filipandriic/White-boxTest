package testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import simulator.*;
import gui.MainWindow;

public class Mockito {
	private static MainWindow main = new MainWindow();
	private static String input = new String();
	
	@BeforeAll
	public static void loadFile() {
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\Desktop\\ProjekatTS\\dz2\\Java04\\Java04_DUSim\\Test primeri\\LCSAJ\\Test2.txt"));
		    
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
	
	private Definition definition(String variable, int rowNo) {
		Definition definition = mock(Definition.class);
		when(definition.getVariable()).thenReturn(variable);
		when(definition.getRowNo()).thenReturn(rowNo);
		
		return definition;
	}
	
	@Test
	public void definitionMock() {
		List<Definition> definitions = new LinkedList<>();
		definitions.add(definition("n", 1));
		definitions.add(definition("i", 2));
		definitions.add(definition("i", 2));
		definitions.add(definition("p", 3));
		definitions.add(definition("j", 4));
		definitions.add(definition("niz", 6));
		definitions.add(definition("j", 6));
		definitions.add(definition("niz", 9));

		StringBuilder expect = new StringBuilder();
		
		for (Definition definition : definitions) {
			expect.append(definition.getVariable() + " (red " + definition.getRowNo() + ")\n");
		}
		expect.append("\nBroj definicija: " + definitions.size());
		
		assertEquals(expect.toString(), main.getSimulator().getDefinitions());
	}
	
	private Use use(String variable, int rowNo, char type) {
		Use use = mock(Use.class);
		when(use.getVariable()).thenReturn(variable);
		when(use.getRowNo()).thenReturn(rowNo);
		when(use.getType()).thenReturn(type);
		
		return use;
	}
	
	@Test
	public void useMock() {
		List<Use> uses = new LinkedList<>();
		
		uses.add(use("niz.length", 1, 'c'));		
		uses.add(use("i", 2, 'p'));
		uses.add(use("n", 2, 'p'));
		uses.add(use("i", 2, 'c'));
		uses.add(use("niz", 3, 'p'));
		uses.add(use("i", 3, 'p'));
		uses.add(use("i", 4, 'p'));
		uses.add(use("j", 5, 'p'));
		uses.add(use("p", 5, 'p'));
		uses.add(use("niz", 5, 'p'));
		uses.add(use("j", 5, 'p'));
		uses.add(use("j", 6, 'p'));
		uses.add(use("niz", 6, 'p'));
		uses.add(use("j", 6, 'p'));
		uses.add(use("j", 6, 'c'));
		uses.add(use("j", 9, 'p'));
		uses.add(use("p", 9, 'p'));

		StringBuilder expect = new StringBuilder();
		
		for (Use use : uses) {
			expect.append(use.getVariable() + " (red " + use.getRowNo() + ", " + use.getType() + "-upotreba)\n");
		}
		expect.append("\nBroj c-upotreba: 3");
		expect.append("\nBroj p-upotreba: 14");
		
		assertEquals(expect.toString(), main.getSimulator().getUses());
	}
	
	private DUChain du(String variable, int rowNoDef, int rowNoUse) {
		DUChain du = mock(DUChain.class);
		when(du.getVariable()).thenReturn(variable);
		when(du.getRowNoDef()).thenReturn(rowNoDef);
		when(du.getRowNoUse()).thenReturn(rowNoUse);
		return du;
	}
	
	@Test
	public void duMock() {
		List<DUChain> dus = new LinkedList<>();
		dus.add(du("n", 1, 2));
		dus.add(du("p", 3, 5));
		dus.add(du("p", 3, 9));
		dus.add(du("j", 4, 5));
		dus.add(du("j", 4, 5));
		dus.add(du("j", 4, 6));
		dus.add(du("j", 4, 6));
		dus.add(du("j", 4, 6));
		dus.add(du("j", 4, 9));
		dus.add(du("niz", 6, 3));
		dus.add(du("niz", 6, 5));
		dus.add(du("niz", 6, 6));
		dus.add(du("j", 6, 5));
		dus.add(du("j", 6, 5));
		dus.add(du("j", 6, 6));
		dus.add(du("j", 6, 6));
		dus.add(du("j", 6, 6));
		dus.add(du("j", 6, 9));
		dus.add(du("niz", 9, 3));
		dus.add(du("niz", 9, 5));
		dus.add(du("niz", 9, 6));
		
		StringBuilder expect = new StringBuilder();
		
		for (DUChain du : dus) {
			expect.append("[" + du.getVariable() + ", " + du.getRowNoDef() + ", " + du.getRowNoUse() + "]\n");
		}
		expect.append("\nBroj DU-lanaca: " + dus.size());
		
		assertEquals(expect.toString(), main.getSimulator().getDuChains());
	}
	
	private Lcsaj lcsaj(int startSeq, int endSeq, int jump) {
		Lcsaj lcsaj = mock(Lcsaj.class);
		when(lcsaj.getStartSeq()).thenReturn(startSeq);
		when(lcsaj.getEndSeq()).thenReturn(endSeq);
		when(lcsaj.getJump()).thenReturn(jump);
		return lcsaj;
	}
	
	@Test
	public void LcsajMock() {
		List<Lcsaj> lcsajs = new LinkedList<>();
		lcsajs.add(lcsaj(1, 2, 12));
		lcsajs.add(lcsaj(1, 5, 9));
		lcsajs.add(lcsaj(1, 8, 5));
		lcsajs.add(lcsaj(2, 2, 12));
		lcsajs.add(lcsaj(2, 5, 9));
		lcsajs.add(lcsaj(2, 8, 5));
		lcsajs.add(lcsaj(5, 5, 9));
		lcsajs.add(lcsaj(5, 8, 5));
		lcsajs.add(lcsaj(9, 11, 2));
		
		
		StringBuilder expect = new StringBuilder();
		
		for (Lcsaj lcsaj : lcsajs) {
			expect.append("(" + lcsaj.getStartSeq() + ", " + lcsaj.getEndSeq() + ", " + lcsaj.getJump() + ")\n");
		}
		expect.append("\nBroj LCSAJ sekvenci: " + lcsajs.size());
		
		assertEquals(expect.toString(), main.getSimulator().getLcsaj());
	}
}

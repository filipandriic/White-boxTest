package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.*;

import gui.FileInfo;

public class FileInfoTest {
	private static Path path = Paths.get("path");
	private static Path parentPath = Paths.get("parentPath");
	
	private static FileInfo fileInfo = new FileInfo("name", path, parentPath);
	
	@Test
	public void getFileNameTest() {
		assertEquals("name", fileInfo.getFileName());
	}

	@Test
	public void getFilePathTest() {
		assertEquals("path", fileInfo.getFilePath().toString());
	}
	
	@Test
	public void getParentPathTest() {
		assertEquals("parentPath", fileInfo.getParentPath().toString());
	}

	@Test
	public void toStringTest() {
		assertEquals("name", fileInfo.toString());
	}
}

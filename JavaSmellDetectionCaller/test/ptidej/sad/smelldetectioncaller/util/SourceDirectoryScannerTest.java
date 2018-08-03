package ptidej.sad.smelldetectioncaller.util;
import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ptidej.sad.smelldetectioncaller.util.DirectoryFilter;
import ptidej.sad.smelldetectioncaller.util.SourceDirectoryScanner;

public class SourceDirectoryScannerTest {

	String MULTI_PROJECT_PATH = "./test-resources/srcdir/multiproject";

	@Before
	public void setup() {

		File file = new File(MULTI_PROJECT_PATH);
		Assert.assertTrue(file.exists());

	}

	@Test
	public void test() {

		DirectoryFilter fileFilter = DirectoryFilter.production();
		SourceDirectoryScanner scanner = new SourceDirectoryScanner(fileFilter, MULTI_PROJECT_PATH);

		String[] sourcePaths = scanner.listSourcePaths();
		Assert.assertEquals(2, sourcePaths.length);
		Assert.assertEquals(MULTI_PROJECT_PATH + File.separator + "retrofit/src/main/java", sourcePaths[0]);
		Assert.assertEquals(MULTI_PROJECT_PATH + File.separator + "retrofit-adapters/src/main/java", sourcePaths[1]);

	}

}

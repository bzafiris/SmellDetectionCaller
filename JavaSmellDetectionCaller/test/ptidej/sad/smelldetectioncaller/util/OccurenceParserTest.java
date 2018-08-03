package ptidej.sad.smelldetectioncaller.util;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceBuilder;
import util.io.ProxyDisk;
import util.io.ReaderInputStream;

public class OccurenceParserTest {

	
	@Test
	public void parseBlobOccurences() throws IOException{
		
		String path = "./test-resources/rsc/antisingleton.ini";
		
		final Properties properties = new Properties();
		properties.load(new ReaderInputStream(ProxyDisk
			.getInstance()
			.fileAbsoluteInput(path)));
		final OccurrenceBuilder solutionBuilder =
			OccurrenceBuilder.getInstance();
		final Occurrence[] solutions =
			solutionBuilder.getCanonicalOccurrences(properties);
		
		System.out.println("Ok");
		
	}
	
	
	
}

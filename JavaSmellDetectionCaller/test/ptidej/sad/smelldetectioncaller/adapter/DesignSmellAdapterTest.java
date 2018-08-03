package ptidej.sad.smelldetectioncaller.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ptidej.sad.smelldetectioncaller.JavaSmellDetectionCallerTestCase;

public class DesignSmellAdapterTest extends JavaSmellDetectionCallerTestCase {

	MockSmellOccurenceVisitor visitor;
	
	@Before
	public void setup(){
		
		visitor = new MockSmellOccurenceVisitor();
		
	}
	
	
	@Test
	public void parseAntisingletonOutput(){
		
		String antisingleton = loadPtidejOutputResource("antisingleton.ini");
		
		DesignSmellAdapter adapter = SmellAdapterFactory.getAdapter(DesignSmellAdapter.ANTISINGLETON);
		adapter.setOccurencesOutput(antisingleton);
		adapter.accept(visitor);
		
		Assert.assertEquals(19, visitor.getAntiSingletons().size());
		
	}
	
	
	protected String loadPtidejOutputResource(String fileName){
		String resourcepath = getTestResourcesPath("rsc", fileName); 
		File file = new File(resourcepath);
	
		try {
			StringBuffer fileContentsBuffer = new StringBuffer();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ( (line = br.readLine()) != null){
				fileContentsBuffer.append(line);
				fileContentsBuffer.append("\n");
			}
			
			return fileContentsBuffer.toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	
}

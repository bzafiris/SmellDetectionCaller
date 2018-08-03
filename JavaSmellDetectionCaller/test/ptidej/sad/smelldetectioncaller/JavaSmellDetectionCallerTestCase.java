package ptidej.sad.smelldetectioncaller;

import java.io.File;

public class JavaSmellDetectionCallerTestCase {

	public String getTestResourcesPath(String ... segments){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(".");
		buffer.append(File.separator);
		buffer.append("test-resources");
		
		for(String segment: segments){
			buffer.append(File.separator);
			buffer.append(segment);
		}
		
		return buffer.toString();
	}
	
	
	
}

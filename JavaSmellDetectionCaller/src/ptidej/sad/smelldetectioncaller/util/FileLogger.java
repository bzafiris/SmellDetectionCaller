package ptidej.sad.smelldetectioncaller.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {

	private BufferedWriter writer;
	
	private FileLogger(){
		
	}
	
	public static Logger getInstance(String fileName){
		
		FileLogger logger = new FileLogger();
		
		try {
			logger.writer = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return logger;
		
	}
	
	
	@Override
	protected void writeLine(String line) {
		try {
			writer.write(line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

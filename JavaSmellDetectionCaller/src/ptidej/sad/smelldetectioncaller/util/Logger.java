package ptidej.sad.smelldetectioncaller.util;

public interface Logger {
	
	void logHeaders();
	
	void log(String className, Integer[] values);

	void close();
	
}

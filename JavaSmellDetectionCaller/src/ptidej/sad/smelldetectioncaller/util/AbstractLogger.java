package ptidej.sad.smelldetectioncaller.util;

import java.util.ArrayList;
import java.util.List;

import ptidej.sad.smelldetectioncaller.DesignSmells;

public abstract class AbstractLogger implements Logger {

	@Override
	public void logHeaders() {
		
		StringBuffer buffer = new StringBuffer("Class");
		buffer.append(",");
		buffer.append(String.join(",", DesignSmells.LIST));
		writeLine(buffer.toString());

	}

	@Override
	public void log(String className, Integer[] values) {

		StringBuffer buffer = new StringBuffer(className);
		buffer.append(",");
		
		List<String> valuesList = new ArrayList<>();
		for(Integer value: values){
			valuesList.add(String.valueOf(value));
		}
		
		buffer.append(String.join(",", valuesList));
		writeLine(buffer.toString());
		
	}
	
	public void close(){}

	protected abstract void writeLine(String line);

}

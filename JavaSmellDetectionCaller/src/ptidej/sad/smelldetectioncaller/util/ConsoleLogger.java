package ptidej.sad.smelldetectioncaller.util;

public class ConsoleLogger extends AbstractLogger {

	@Override
	protected void writeLine(String line) {

		System.out.println(line);
	}

}

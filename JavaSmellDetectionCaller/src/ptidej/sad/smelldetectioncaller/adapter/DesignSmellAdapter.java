package ptidej.sad.smelldetectioncaller.adapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import padl.kernel.IAbstractLevelModel;
import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceBuilder;
import sad.designsmell.detection.IDesignSmellDetection;
import util.io.ProxyConsole;
import util.io.ReaderInputStream;

/**
 * 
 * @author bzafiris
 *
 * Processes the output of a specific smell detector (key-value pairs).
 * Invokes the {@link ptidej.sad.smelldetectioncaller.DesignSmellOccurenceVisitor}
 * depending on the identified smell. 
 * See subclasses for more details.
 * Examples of IDesignSmellDetection output is available in folder test-resources/rsc
 * 
 *
 */
public abstract class DesignSmellAdapter {

	public abstract String getAntiPatternName();

	private IDesignSmellDetection detection;
	private String occurencesOutput;

	public void detect(IAbstractLevelModel idiomLevelModel) {

		String antiPatternName = getAntiPatternName();

		Class<?> detectionClass;
		try {
			detectionClass = Class.forName(
					"sad.designsmell.detection.repository." + antiPatternName + '.' + antiPatternName + "Detection");
			detection = (IDesignSmellDetection) detectionClass.newInstance();

			detection.detect(idiomLevelModel);
			StringWriter stringWriter = new StringWriter();
			detection.output(new PrintWriter(stringWriter));
			occurencesOutput = stringWriter.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace(ProxyConsole.getInstance().errorOutput());
			throw new RuntimeException(e);
		}

	}

	protected abstract void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurences);

	public void accept(IDesignSmellOccurenceVisitor visitor) {

		if (occurencesOutput == null) {
			throw new IllegalStateException("Detect not called on DesignSmellAdapter");
		}

		final Properties properties = new Properties();
		try {
			properties.load(new ReaderInputStream(new StringReader(occurencesOutput)));
			final OccurrenceBuilder solutionBuilder = OccurrenceBuilder.getInstance();
			final Occurrence[] solutions = solutionBuilder.getCanonicalOccurrences(properties);

			processOccurence(visitor, solutions);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// For testing purposes
	public void setOccurencesOutput(String occurencesOutput) {
		this.occurencesOutput = occurencesOutput;
	}

}

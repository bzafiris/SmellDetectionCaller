package ptidej.sad.smelldetectioncaller.adapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import padl.kernel.IAbstractLevelModel;
import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceBuilder;
import sad.designsmell.detection.IDesignSmellDetection;
import util.io.ProxyConsole;
import util.io.ReaderInputStream;

/**
 * 
 * @author bzafiris
 *
 */
public abstract class DesignSmellAdapter {

	public static final String ANTISINGLETON = "AntiSingleton";
	private static final String TRADITION_BREAKER = "TraditionBreaker";
	private static final String SWISS_ARMY_KNIFE = "SwissArmyKnife";
	private static final String SPECULATIVE_GENERALITY = "SpeculativeGenerality";
	private static final String SPAGHETTI_CODE = "SpaghettiCode";
	private static final String REFUSED_PARENT_BEQUEST = "RefusedParentBequest";
	private static final String MESSAGE_CHAINS = "MessageChains";
	private static final String MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX = "ManyFieldAttributesButNotComplex";
	private static final String LONG_PARAMETER_LIST = "LongParameterList";
	private static final String LONG_METHOD = "LongMethod";
	private static final String LAZY_CLASS = "LazyClass";
	private static final String LARGE_CLASS = "LargeClass";
	private static final String FUNCTIONAL_DECOMPOSITION = "FunctionalDecomposition";
	private static final String COMPLEX_CLASS = "ComplexClass";
	private static final String CLASS_DATA_SHOULD_BE_PRIVATE = "ClassDataShouldBePrivate";
	private static final String BLOB = "Blob";
	private static final String BASE_CLASS_SHOULD_BE_ABSTRACT = "BaseClassShouldBeAbstract";
	private static final String BASE_CLASS_KNOWS_DERIVED_CLASS = "BaseClassKnowsDerivedClass";

	public abstract String getAntiPatternName();

	private IDesignSmellDetection detection;

	public void detect(IAbstractLevelModel idiomLevelModel) {

		String antiPatternName = getAntiPatternName();

		Class<?> detectionClass;
		try {
			detectionClass = Class.forName(
					"sad.designsmell.detection.repository." + antiPatternName + '.' + antiPatternName + "Detection");
			detection = (IDesignSmellDetection) detectionClass.newInstance();

			detection.detect(idiomLevelModel);
		} catch (Exception e) {
			e.printStackTrace(ProxyConsole.getInstance().errorOutput());
			throw new RuntimeException(e);
		}

	}

	protected abstract void processOccurence(ISmellOccurenceVisitor visitor, Occurrence[] occurences);

	public void accept(ISmellOccurenceVisitor visitor) {

		StringWriter stringWriter = new StringWriter();
		detection.output(new PrintWriter(stringWriter));

		final Properties properties = new Properties();
		try {
			properties.load(new ReaderInputStream(new StringReader(stringWriter.getBuffer().toString())));
			final OccurrenceBuilder solutionBuilder = OccurrenceBuilder.getInstance();
			final Occurrence[] solutions = solutionBuilder.getCanonicalOccurrences(properties);

			processOccurence(visitor, solutions);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

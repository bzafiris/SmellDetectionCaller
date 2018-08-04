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
 */
public abstract class DesignSmellAdapter {

	// done
	public static final String ANTISINGLETON = "AntiSingleton";
	// pending
	public static final String TRADITION_BREAKER = "TraditionBreaker";
	// done
	public static final String SWISS_ARMY_KNIFE = "SwissArmyKnife";
	// done
	public static final String SPECULATIVE_GENERALITY = "SpeculativeGenerality";
	// done
	public static final String SPAGHETTI_CODE = "SpaghettiCode";
	// done
	public static final String REFUSED_PARENT_BEQUEST = "RefusedParentBequest";
	// done
	public static final String MESSAGE_CHAINS = "MessageChains";
	// done
	public static final String MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX = "ManyFieldAttributesButNotComplex";
	// done
	public static final String LONG_PARAMETER_LIST = "LongParameterList";
	// done
	public static final String LONG_METHOD = "LongMethod";
	// done
	public static final String LAZY_CLASS = "LazyClass";
	//
	public static final String LARGE_CLASS = "LargeClass";
	
	public static final String FUNCTIONAL_DECOMPOSITION = "FunctionalDecomposition";
	public static final String COMPLEX_CLASS = "ComplexClass";
	public static final String CLASS_DATA_SHOULD_BE_PRIVATE = "ClassDataShouldBePrivate";
	// done
	public static final String BLOB = "Blob";
	public static final String BASE_CLASS_SHOULD_BE_ABSTRACT = "BaseClassShouldBeAbstract";
	public static final String BASE_CLASS_KNOWS_DERIVED_CLASS = "BaseClassKnowsDerivedClass";

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

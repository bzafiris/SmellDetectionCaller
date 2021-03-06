package ptidej.sad.smelldetectioncaller;

import java.util.HashMap;
import java.util.Map;
import static ptidej.sad.smelldetectioncaller.DesignSmells.*;

/**
 * 
 * @author bzafiris
 *
 * Aggregates the code smell occurrences for each class.
 * It is invoked by subclasses of {@link ptidej.sad.smelldetectioncaller.adapter.DesignSmellAdapter}
 *
 */
public class DesignSmellOccurenceVisitor implements IDesignSmellOccurenceVisitor {

	Map<String, DesignSmellOccurrenceSummary> designSmellOccurrencesPerClass = new HashMap<>();

	@Override
	public void visitAntiSingleton(String className) {
		setSingleSmellOccurrence(className, ANTISINGLETON);
	}

	@Override
	public void visitBlobClass(String className) {
		setSingleSmellOccurrence(className, BLOB);
	}

	@Override
	public void visitSwissArmyKnife(String className) {
		setSingleSmellOccurrence(className, SWISS_ARMY_KNIFE);
	}

	@Override
	public void visitSpeculativeGenerality(String className) {
		setSingleSmellOccurrence(className, SPECULATIVE_GENERALITY);
	}

	@Override
	public void visitSpaghettiCode(String className) {
		addSmellOccurrence(className, SPAGHETTI_CODE, 1);
	}

	@Override
	public void visitRefusedParentRequest(String className) {
		setSingleSmellOccurrence(className, REFUSED_PARENT_BEQUEST);
	}

	@Override
	public void visitMessageChains(String className) {
		setSingleSmellOccurrence(className, MESSAGE_CHAINS);
	}

	@Override
	public void visitManyFieldAttributesButNotComplex(String className) {
		setSingleSmellOccurrence(className, MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX);
	}

	@Override
	public void visitLongParameterListClass(String className) {
		setSingleSmellOccurrence(className, LONG_PARAMETER_LIST);
	}

	@Override
	public void visitLongMethodClass(String className) {
		addSmellOccurrence(className, LONG_METHOD, 1);
	}

	@Override
	public void visitLazyClass(String className) {
		setSingleSmellOccurrence(className, LAZY_CLASS);
	}

	@Override
	public void visitLowCohesionClass(String className) {

	}

	@Override
	public void visitDataClass(String className) {
	}

	@Override
	public void visitLargeClass(String className) {
		setSingleSmellOccurrence(className, LARGE_CLASS);
	}

	@Override
	public void visitFunctionalDecomposition(String className) {
		setSingleSmellOccurrence(className, FUNCTIONAL_DECOMPOSITION);
	}

	@Override
	public void visitComplexClass(String className) {
		setSingleSmellOccurrence(className, COMPLEX_CLASS);
	}

	@Override
	public void visitClassDataShouldBePrivate(String className) {
		setSingleSmellOccurrence(className, CLASS_DATA_SHOULD_BE_PRIVATE);
	}

	@Override
	public void visitBaseClassShouldBeAbstract(String className) {
		setSingleSmellOccurrence(className, BASE_CLASS_SHOULD_BE_ABSTRACT);

	}

	@Override
	public void visitBaseClassKnowsDerivedClass(String className) {
		setSingleSmellOccurrence(className, BASE_CLASS_KNOWS_DERIVED_CLASS);
	}

	@Override
	public void visitTraditionBreaker(String className) {
		setSingleSmellOccurrence(className, TRADITION_BREAKER);
	}

	private void setSingleSmellOccurrence(String className, String smell) {
		DesignSmellOccurrenceSummary occurrenceSummary = designSmellOccurrencesPerClass.get(className);
		if (occurrenceSummary == null) {
			occurrenceSummary = new DesignSmellOccurrenceSummary(className);
			designSmellOccurrencesPerClass.put(className, occurrenceSummary);
		}
		occurrenceSummary.setSingleSmellOccurrence(smell);
	}

	private void addSmellOccurrence(String className, String smell, int count) {
		DesignSmellOccurrenceSummary occurrenceSummary = designSmellOccurrencesPerClass.get(className);
		if (occurrenceSummary == null) {
			occurrenceSummary = new DesignSmellOccurrenceSummary(className);
			designSmellOccurrencesPerClass.put(className, occurrenceSummary);
		}
		occurrenceSummary.addSmellOccurrence(smell, count);
	}

	
	public Map<String, DesignSmellOccurrenceSummary> getDesignSmellOccurrencesPerClass() {
		return designSmellOccurrencesPerClass;
	}

}

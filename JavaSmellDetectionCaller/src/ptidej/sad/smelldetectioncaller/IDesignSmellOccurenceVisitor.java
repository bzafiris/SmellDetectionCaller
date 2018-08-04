package ptidej.sad.smelldetectioncaller;

/**
 * 
 * @author bzafiris
 *
 */
public interface IDesignSmellOccurenceVisitor {

	void visitAntiSingleton(String className);
	
	void visitBlobClass(String className);
	
	void visitLowCohesionClass(String className);
	
	void visitDataClass(String className);
	
	void visitSwissArmyKnife(String className);
	
	void visitSpeculativeGenerality(String className);
	
	void visitSpaghettiCode(String className);
	
	void visitRefusedParentRequest(String className);
	
	void visitMessageChains(String className);
	
	void visitManyFieldAttributesButNotComplex(String className);
	
	void visitLongParameterListClass(String className);
	
	void visitLongMethodClass(String className);
	
	void visitLazyClass(String className);
	
	void visitLargeClass(String className);
	
	void visitFunctionalDecomposition(String className);
	
	void visitComplexClass(String className);

}
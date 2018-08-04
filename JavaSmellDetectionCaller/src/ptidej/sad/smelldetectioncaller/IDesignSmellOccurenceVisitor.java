package ptidej.sad.smelldetectioncaller;

/**
 * 
 * @author bzafiris
 *
 */
public interface IDesignSmellOccurenceVisitor {

	void visitAntiSingleton(String className);
	
	void visitLargeClass(String className);
	
	void visitSwissArmyKnife(String className);
	
	void visitSpeculativeGenerality(String className);
	
	void visitSpaghettiCode(String className);
	
	void visitRefusedParentRequest(String className);
	
	void visitMessageChains(String className);
	
	void visitManyFieldAttributesButNotComplex(String className);
	
	void visitLongParameterListClass(String className);
	
	void visitLongMethodClass(String className);

}
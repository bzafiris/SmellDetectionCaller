package ptidej.sad.smelldetectioncaller;

public interface ISmellOccurenceVisitor {

	void visitAntiSingleton(String className);
	
	void visitLargeClass(String className);
	
	void visitSwissArmyKnife(String className);

}
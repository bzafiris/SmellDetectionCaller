package ptidej.sad.smelldetectioncaller;

import java.util.HashSet;
import java.util.Set;

public class DesignSmellOccurenceVisitor implements ISmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	Set<String> blobs = new HashSet<>();
	
	@Override
	public void visitAntiSingleton(String className){
		antiSingletons.add(className);
	}
	
	public Set<String> getAntiSingletons() {
		return antiSingletons;
	}

	@Override
	public void visitLargeClass(String className) {
		blobs.add(className);
		
	}

	@Override
	public void visitSwissArmyKnife(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitSpeculativeGenerality(String className) {
		// TODO Auto-generated method stub
		
	}
		
}

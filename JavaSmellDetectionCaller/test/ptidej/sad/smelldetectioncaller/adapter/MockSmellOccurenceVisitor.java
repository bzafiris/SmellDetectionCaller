package ptidej.sad.smelldetectioncaller.adapter;

import java.util.HashSet;
import java.util.Set;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;

public class MockSmellOccurenceVisitor implements ISmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	
	@Override
	public void visitAntiSingleton(String className){
		antiSingletons.add(className);
	}
	
	public Set<String> getAntiSingletons() {
		return antiSingletons;
	}
	
	
}

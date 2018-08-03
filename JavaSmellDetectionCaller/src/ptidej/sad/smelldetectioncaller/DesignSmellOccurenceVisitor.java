package ptidej.sad.smelldetectioncaller;

import java.util.HashSet;
import java.util.Set;

public class DesignSmellOccurenceVisitor implements ISmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	
	@Override
	public void visitAntiSingleton(String className){
		antiSingletons.add(className);
	}
	
	public Set<String> getAntiSingletons() {
		return antiSingletons;
	}
		
}

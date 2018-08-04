package ptidej.sad.smelldetectioncaller.adapter;

import java.util.HashSet;
import java.util.Set;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;

public class MockSmellOccurenceVisitor implements ISmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	Set<String> blobs = new HashSet<>();
	Set<String> swissArmyKnives = new HashSet<>();
	
	@Override
	public void visitAntiSingleton(String className){
		antiSingletons.add(className);
	}
	
	@Override
	public void visitLargeClass(String className) {
		blobs.add(className);
		
	}

	@Override
	public void visitSwissArmyKnife(String className) {
		swissArmyKnives.add(className);
	}
	
	
	public Set<String> getAntiSingletons() {
		return antiSingletons;
	}

	
	public Set<String> getBlobs() {
		return blobs;
	}
	
	public Set<String> getSwissArmyKnives() {
		return swissArmyKnives;
	}


	
}

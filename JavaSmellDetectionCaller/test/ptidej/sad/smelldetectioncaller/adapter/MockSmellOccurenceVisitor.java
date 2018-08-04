package ptidej.sad.smelldetectioncaller.adapter;

import java.util.HashSet;
import java.util.Set;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;

public class MockSmellOccurenceVisitor implements ISmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	Set<String> blobs = new HashSet<>();
	Set<String> swissArmyKnives = new HashSet<>();
	Set<String> speculativeGeneralities = new HashSet<>();
	Set<String> spaghettiCodeClasses = new HashSet<>();

	@Override
	public void visitSpaghettiCode(String className) {
		spaghettiCodeClasses.add(className);
		
	}
	
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
	

	@Override
	public void visitSpeculativeGenerality(String className) {
		speculativeGeneralities.add(className);
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


	public Set<String> getSpeculativeGeneralities() {
		return speculativeGeneralities;
	}

	public Set<String> getSpaghettiCodeClasses() {
		return spaghettiCodeClasses;
	}



	
}

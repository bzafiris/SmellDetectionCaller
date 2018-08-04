package ptidej.sad.smelldetectioncaller.adapter;

import java.util.HashSet;
import java.util.Set;

import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;

public class MockDesignSmellOccurenceVisitor implements IDesignSmellOccurenceVisitor {

	Set<String> antiSingletons = new HashSet<>();
	Set<String> blobs = new HashSet<>();
	Set<String> lowCohesionClasses = new HashSet<>();
	Set<String> dataClasses = new HashSet<>();
	Set<String> swissArmyKnives = new HashSet<>();
	Set<String> speculativeGeneralities = new HashSet<>();
	Set<String> spaghettiCodeClasses = new HashSet<>();
	Set<String> refusedParentBequestClasses = new HashSet<>();
	Set<String> messageChainsClasses = new HashSet<>();
	Set<String> manyFieldAttributesButNotComplexClasses = new HashSet<>();
	Set<String> longParameterListClasses = new HashSet<>();
	Set<String> longMethodClasses = new HashSet<>();
	Set<String> lazyClasses = new HashSet<>();
	Set<String> largeClasses = new HashSet<>();
	Set<String> functionalDecompositionClasses = new HashSet<>();

	@Override
	public void visitFunctionalDecomposition(String className) {
		functionalDecompositionClasses.add(className);
	}

	@Override
	public void visitLargeClass(String className) {
		largeClasses.add(className);
	}

	@Override
	public void visitLowCohesionClass(String className) {
		lowCohesionClasses.add(className);
	}

	@Override
	public void visitDataClass(String className) {
		dataClasses.add(className);
	}

	@Override
	public void visitLazyClass(String className) {
		lazyClasses.add(className);
	}

	@Override
	public void visitLongMethodClass(String className) {
		longMethodClasses.add(className);
	}

	@Override
	public void visitLongParameterListClass(String className) {
		longParameterListClasses.add(className);
	}

	@Override
	public void visitManyFieldAttributesButNotComplex(String className) {
		manyFieldAttributesButNotComplexClasses.add(className);
	}

	@Override
	public void visitMessageChains(String className) {
		messageChainsClasses.add(className);
	}

	@Override
	public void visitRefusedParentRequest(String className) {
		refusedParentBequestClasses.add(className);
	}

	@Override
	public void visitSpaghettiCode(String className) {
		spaghettiCodeClasses.add(className);

	}

	@Override
	public void visitAntiSingleton(String className) {
		antiSingletons.add(className);
	}

	@Override
	public void visitBlobClass(String className) {
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

	public Set<String> getRefusedParentBequestClasses() {
		return refusedParentBequestClasses;
	}

	public Set<String> getMessageChainsClasses() {
		return messageChainsClasses;
	}

	public Set<String> getManyFieldAttributesButNotComplexClasses() {
		return manyFieldAttributesButNotComplexClasses;
	}

	public Set<String> getLongParameterListClasses() {
		return longParameterListClasses;
	}

	public Set<String> getLongMethodClasses() {
		return longMethodClasses;
	}

	public Set<String> getLazyClasses() {
		return lazyClasses;
	}

	public Set<String> getLowCohesionClasses() {
		return lowCohesionClasses;
	}

	public Set<String> getDataClasses() {
		return dataClasses;
	}
	
	public Set<String> getLargeClasses() {
		return largeClasses;
	}
	
	public Set<String> getFunctionalDecompositionClasses() {
		return functionalDecompositionClasses;
	}

}

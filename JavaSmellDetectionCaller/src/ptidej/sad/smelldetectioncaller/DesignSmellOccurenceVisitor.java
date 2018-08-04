package ptidej.sad.smelldetectioncaller;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author bzafiris
 *
 */
public class DesignSmellOccurenceVisitor implements IDesignSmellOccurenceVisitor {

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
	public void visitBlobClass(String className) {
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

	@Override
	public void visitSpaghettiCode(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitRefusedParentRequest(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMessageChains(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitManyFieldAttributesButNotComplex(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLongParameterListClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLongMethodClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLazyClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLowCohesionClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDataClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLargeClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitFunctionalDecomposition(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitComplexClass(String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitClassDataShouldBePrivate(String className) {
		// TODO Auto-generated method stub
		
	}
		
}

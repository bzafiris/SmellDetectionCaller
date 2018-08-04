package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.DesignSmells;
import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

/**
 * 
 * @author bzafiris
 *
 */
public class LazyClassAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.LAZY_CLASS;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				String displayName = occurrenceComponent.getDisplayName();
				if (displayName.contains("FewMethods") // whichever appears first
						|| displayName.contains("NotComplexClass")){
					visitor.visitLazyClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

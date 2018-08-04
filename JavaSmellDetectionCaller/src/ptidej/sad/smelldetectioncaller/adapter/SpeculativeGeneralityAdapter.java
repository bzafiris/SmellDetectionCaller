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
public class SpeculativeGeneralityAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.SPECULATIVE_GENERALITY;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				// first component of each occurence is the swiss army knife class 
				// (implements multiple interfaces)
				if (occurrenceComponent.getDisplayName().contains("AbstractClass")){
					visitor.visitSpeculativeGenerality(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

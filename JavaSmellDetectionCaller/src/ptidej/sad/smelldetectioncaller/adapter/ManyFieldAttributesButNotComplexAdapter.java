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
public class ManyFieldAttributesButNotComplexAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				// not complex class that declares many attributes and public fields
				String displayName = occurrenceComponent.getDisplayName();
				if (displayName.contains("NotComplex") // whichever appears first
						|| displayName.contains("FieldPublic")
						|| displayName.contains("ManyAttributes")){
					visitor.visitManyFieldAttributesButNotComplex(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

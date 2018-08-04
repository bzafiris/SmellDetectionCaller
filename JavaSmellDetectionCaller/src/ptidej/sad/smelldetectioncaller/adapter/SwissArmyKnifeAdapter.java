package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class SwissArmyKnifeAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return SWISS_ARMY_KNIFE;
	}

	@Override
	protected void processOccurence(ISmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				// first component of each occurence is the swiss army knife class 
				// (implements multiple interfaces)
				if (occurrenceComponent.getDisplayName().contains("MultipleInterface")){
					visitor.visitSwissArmyKnife(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

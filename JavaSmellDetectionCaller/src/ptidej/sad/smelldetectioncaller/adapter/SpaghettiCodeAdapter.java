package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class SpaghettiCodeAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return SPAGHETTI_CODE;
	}

	@Override
	protected void processOccurence(ISmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				// class that does not inherit, has long methods with no parameters
				// and utilizes global variables (static variables)
				String displayName = occurrenceComponent.getDisplayName();
				if (displayName.contains("NoInheritance") // whichever appears first
						|| displayName.contains("ClassGlobalVariable")
						|| displayName.contains("MethodNoParameter")
						|| displayName.contains("LongMethod")){
					visitor.visitSpaghettiCode(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

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
public class SpaghettiCodeAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.SPAGHETTI_CODE;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
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

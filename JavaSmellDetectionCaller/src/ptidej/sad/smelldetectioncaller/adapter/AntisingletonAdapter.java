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
public class AntisingletonAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		// TODO Auto-generated method stub
		return DesignSmells.ANTISINGLETON;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			if (components.size() == 3){
				// class name is the second component
				visitor.visitAntiSingleton(components.get(1).getDisplayValue());	
			}
		}
		
		
	}

}

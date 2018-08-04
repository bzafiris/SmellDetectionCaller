package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

/**
 * 
 * @author bzafiris
 *
 */
public class BlobAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		// TODO Auto-generated method stub
		return BLOB;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			
			for(OccurrenceComponent occurrenceComponent: components){
				if (occurrenceComponent.getDisplayName().contains("LargeClass")){
					visitor.visitLargeClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}
			
		}
		
		
	}

}

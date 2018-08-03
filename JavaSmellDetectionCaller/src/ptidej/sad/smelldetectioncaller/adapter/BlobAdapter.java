package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class BlobAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		// TODO Auto-generated method stub
		return BLOB;
	}

	@Override
	protected void processOccurence(ISmellOccurenceVisitor visitor, 
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

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
public class BlobAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		// TODO Auto-generated method stub
		return DesignSmells.BLOB;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, 
			Occurrence[] occurrences) {

		for(Occurrence occurrence: occurrences){
			List<OccurrenceComponent> components = occurrence.getComponents();
			boolean ignoreLargeClass = false;
			boolean ignoreDataClass = false;
			boolean ignoreLowCohesion = false;
			for(OccurrenceComponent occurrenceComponent: components){
				if (occurrenceComponent.getDisplayName().contains("LargeClass") && !ignoreLargeClass){
					visitor.visitBlobClass(occurrenceComponent.getDisplayValue());
					ignoreLargeClass = true;
					ignoreDataClass = false;
					ignoreLowCohesion = false;
				} else if (occurrenceComponent.getDisplayName().contains("LowCohesion") && !ignoreLowCohesion){
					visitor.visitLowCohesionClass(occurrenceComponent.getDisplayValue());
					ignoreLargeClass = false;
					ignoreDataClass = false;
					ignoreLowCohesion = true;
				} else if (occurrenceComponent.getDisplayName().contains("DataClass") && !ignoreDataClass){
					visitor.visitDataClass(occurrenceComponent.getDisplayValue());
					ignoreLargeClass = false;
					ignoreDataClass = true;
					ignoreLowCohesion = false;
				}
			}
			
		}
		
		
	}

}

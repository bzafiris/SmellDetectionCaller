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
public class ComplexClassAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return COMPLEX_CLASS;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				// Large classes are also regarded as complex classes
				if (displayName.contains("ComplexClassOnly")) {
					visitor.visitComplexClass(occurrenceComponent.getDisplayValue());
					break;
				} else if (displayName.contains("LargeClassOnly")){
					visitor.visitLargeClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

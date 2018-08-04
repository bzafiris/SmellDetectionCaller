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
public class ClassDataShouldBePrivateAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return CLASS_DATA_SHOULD_BE_PRIVATE;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				if (displayName.contains("FieldPublic")) {
					visitor.visitClassDataShouldBePrivate(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

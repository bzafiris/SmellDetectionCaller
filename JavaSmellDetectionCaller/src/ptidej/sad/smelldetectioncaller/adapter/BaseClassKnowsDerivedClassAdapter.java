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
 * FIXME: For some reasons inheritance related metrics are not calculated properly...
 * Just Run the tool on JavaSmellSamples
 *
 */
public class BaseClassKnowsDerivedClassAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.BASE_CLASS_KNOWS_DERIVED_CLASS;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				// the base class that knows its children must not inherit
				if (displayName.contains("NoInheritance")) {
					visitor.visitBaseClassKnowsDerivedClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

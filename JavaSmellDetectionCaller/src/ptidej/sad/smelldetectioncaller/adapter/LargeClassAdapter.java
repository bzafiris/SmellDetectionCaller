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
public class LargeClassAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.LARGE_CLASS;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				// A class that redefines inherited method using empty bodies,
				String displayName = occurrenceComponent.getDisplayName();
				// the parent class is ParentClassProvidesProtected
				if (displayName.contains("LargeClass")) {
					visitor.visitLargeClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class RefusedParentRequestAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return REFUSED_PARENT_BEQUEST;
	}

	@Override
	protected void processOccurence(ISmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				// A class that redefines inherited method using empty bodies,
				String displayName = occurrenceComponent.getDisplayName();
				// the parent class is ParentClassProvidesProtected
				if (displayName.contains("RareOverriding")) {
					visitor.visitRefusedParentRequest(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

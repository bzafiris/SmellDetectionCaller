package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class LongMethodAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return LONG_METHOD;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				// A class that redefines inherited method using empty bodies,
				String displayName = occurrenceComponent.getDisplayName();
				// the parent class is ParentClassProvidesProtected
				if (displayName.contains("LongMethodClass")) {
					visitor.visitLongMethodClass(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.IDesignSmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

public class FunctionalDecompositionAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return FUNCTIONAL_DECOMPOSITION;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				if (displayName.contains("FunctionMethodClass")
						|| displayName.contains("NoPolymorphism")
						|| displayName.contains("NoInheritance")) {
					visitor.visitFunctionalDecomposition(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

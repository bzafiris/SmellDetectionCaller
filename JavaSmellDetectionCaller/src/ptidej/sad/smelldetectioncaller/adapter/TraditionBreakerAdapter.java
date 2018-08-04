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
 *FIXME: Untested, could not find tradition breaker instances, probably related to inheritance
 *metrics calculations
 *
 *
 */
public class TraditionBreakerAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return DesignSmells.TRADITION_BREAKER;
	}

	@Override
	protected void processOccurence(IDesignSmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				// tradition breaker is also a large class
				if (displayName.contains("LargeClass")) {
					visitor.visitTraditionBreaker(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

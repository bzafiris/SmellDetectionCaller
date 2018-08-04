package ptidej.sad.smelldetectioncaller.adapter;

import java.util.List;

import ptidej.sad.smelldetectioncaller.ISmellOccurenceVisitor;
import ptidej.solver.Occurrence;
import ptidej.solver.OccurrenceComponent;

/**
 * 
 * @author bzafiris
 *
 */
public class MessageChainsAdapter extends DesignSmellAdapter {

	@Override
	public String getAntiPatternName() {
		return MESSAGE_CHAINS;
	}

	@Override
	protected void processOccurence(ISmellOccurenceVisitor visitor, Occurrence[] occurrences) {

		for (Occurrence occurrence : occurrences) {
			List<OccurrenceComponent> components = occurrence.getComponents();

			for (OccurrenceComponent occurrenceComponent : components) {
				String displayName = occurrenceComponent.getDisplayName();
				// the parent class is ParentClassProvidesProtected
				if (displayName.contains("MessageChainsClass")) {
					visitor.visitMessageChains(occurrenceComponent.getDisplayValue());
					break;
				}
			}

		}

	}

}

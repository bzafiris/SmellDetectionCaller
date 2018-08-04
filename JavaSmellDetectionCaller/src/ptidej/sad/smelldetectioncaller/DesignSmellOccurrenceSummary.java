package ptidej.sad.smelldetectioncaller;

import java.util.Map;
import java.util.TreeMap;

public class DesignSmellOccurrenceSummary {

	private Map<String, Integer> smellOccurrencesMap = new TreeMap<>();
	private String className;

	public DesignSmellOccurrenceSummary(String className) {
		super();
		this.className = className;

		for (String smell : DesignSmells.LIST) {
			smellOccurrencesMap.put(smell, 0);
		}
	}

	public void setSingleSmellOccurrence(String smell) {
		smellOccurrencesMap.put(smell, 1);
	}

	public void addSmellOccurrence(String smell, int occurrenceCount) {
		int currentValue = smellOccurrencesMap.get(smell);
		currentValue += occurrenceCount;
		smellOccurrencesMap.put(smell, currentValue);
	}

	public Integer[] getDesignSmellOccurrences() {
		Integer[] occurrences = new Integer[smellOccurrencesMap.size()];

		occurrences = smellOccurrencesMap.values().toArray(occurrences);

		return occurrences;
	}

	public String getClassName() {
		return className;
	}

}

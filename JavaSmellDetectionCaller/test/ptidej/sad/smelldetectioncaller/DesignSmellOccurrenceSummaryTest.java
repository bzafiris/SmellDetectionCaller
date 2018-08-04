package ptidej.sad.smelldetectioncaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DesignSmellOccurrenceSummaryTest {

	DesignSmellOccurrenceSummary occurrenceSummary;
	
	@Before
	public void setup(){
	
		occurrenceSummary = new DesignSmellOccurrenceSummary("MyClass");
		
	}
	
	@Test
	public void ensureOccurrencesListedInProperOrder(){
		
		occurrenceSummary.addSmellOccurrence(DesignSmells.ANTISINGLETON, 1);
		occurrenceSummary.addSmellOccurrence(DesignSmells.BLOB, 3);
		occurrenceSummary.addSmellOccurrence(DesignSmells.FUNCTIONAL_DECOMPOSITION, 6);
		occurrenceSummary.addSmellOccurrence(DesignSmells.LONG_METHOD, 9);
		occurrenceSummary.addSmellOccurrence(DesignSmells.MESSAGE_CHAINS, 12);
		occurrenceSummary.addSmellOccurrence(DesignSmells.SPECULATIVE_GENERALITY, 15);

		occurrenceSummary.addSmellOccurrence(DesignSmells.SPECULATIVE_GENERALITY, 15);
		occurrenceSummary.addSmellOccurrence(DesignSmells.MESSAGE_CHAINS, 12);
		occurrenceSummary.addSmellOccurrence(DesignSmells.ANTISINGLETON, 1);
		occurrenceSummary.addSmellOccurrence(DesignSmells.BLOB, 3);
		occurrenceSummary.addSmellOccurrence(DesignSmells.FUNCTIONAL_DECOMPOSITION, 6);
		occurrenceSummary.addSmellOccurrence(DesignSmells.LONG_METHOD, 9);
		

		occurrenceSummary.addSmellOccurrence(DesignSmells.BASE_CLASS_KNOWS_DERIVED_CLASS, 2);
		occurrenceSummary.addSmellOccurrence(DesignSmells.BASE_CLASS_KNOWS_DERIVED_CLASS, 2);
		
		
		Integer[] occurrences = occurrenceSummary.getDesignSmellOccurrences();
		
		Assert.assertArrayEquals(new Integer[]{
				2, 4, 0,
				6, 0, 0,
				12, 0, 0,
				18, 0, 0,
				24, 0, 0,
				30, 0, 0
		}, 
				occurrences);
		
	}
	
}

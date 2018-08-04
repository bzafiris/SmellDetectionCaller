package ptidej.sad.smelldetectioncaller.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ptidej.sad.smelldetectioncaller.JavaSmellDetectionCallerTestCase;

public class DesignSmellAdapterTest extends JavaSmellDetectionCallerTestCase {

	MockDesignSmellOccurenceVisitor visitor;
	
	@Before
	public void setup(){
		
		visitor = new MockDesignSmellOccurenceVisitor();
		
	}
	
	@Test
	public void parseLongMethodDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("longMethod.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.LONG_METHOD);
		
		Assert.assertEquals(122, visitor.getLongMethodClasses().size());
		Assert.assertTrue(visitor
				.getLongMethodClasses()
				.contains("org.jfree.chart.plot.CombinedRangeXYPlot"));
		Assert.assertTrue(visitor
				.getLongMethodClasses()
				.contains("org.jfree.chart.renderer.category.GanttRenderer"));
		
	}
	
	
	@Test
	public void parseLongParameterListDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("longParameterList.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.LONG_PARAMETER_LIST);
		
		Assert.assertEquals(58, visitor.getLongParameterListClasses().size());
		Assert.assertTrue(visitor
				.getLongParameterListClasses()
				.contains("org.jfree.chart.axis.PeriodAxisLabelInfo"));
		Assert.assertTrue(visitor
				.getLongParameterListClasses()
				.contains("org.jfree.chart.renderer.xy.StackedXYAreaRenderer2"));
		
		
	}
	
	@Test
	public void parseManyFieldAttributesButNotComplexDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("manyFieldAttributesButNotComplex.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX);
		
		Assert.assertEquals(2, visitor.getManyFieldAttributesButNotComplexClasses().size());
		Assert.assertTrue(visitor
				.getManyFieldAttributesButNotComplexClasses()
				.contains("org.apache.xerces.impl.dv.XSFacets"));
		Assert.assertTrue(visitor
				.getManyFieldAttributesButNotComplexClasses()
				.contains("org.w3c.dom.DOMException"));
		
	}
	
	@Test
	public void parseMessageChainsDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("messageChains.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.MESSAGE_CHAINS);
		
		Assert.assertEquals(9, visitor.getMessageChainsClasses().size());
		Assert.assertTrue(visitor
				.getMessageChainsClasses()
				.contains("demo.SurveyResultsDemo1"));
		
	}
	
	@Test
	public void parseRefusedParentBequestDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("refusedParentBequest.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.REFUSED_PARENT_BEQUEST);
		
		Assert.assertEquals(13, visitor.getRefusedParentBequestClasses().size());
		Assert.assertTrue(visitor
				.getRefusedParentBequestClasses()
				.contains("org.jfree.chart.entity.CategoryLabelEntity"));
		
	}
	
	@Test
	public void parseSpaghettiCodeDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("spaghettiCode.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.SPAGHETTI_CODE);
		
		Assert.assertEquals(3, visitor.getSpaghettiCodeClasses().size());
		Assert.assertTrue(visitor.getSpaghettiCodeClasses().contains("org.argouml.ui.targetmanager.TargetManager"));
		
	}
	
	@Test
	public void parseSpeculativeGeneralityDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("speculativeGenerality.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.SPECULATIVE_GENERALITY);
		
		Assert.assertEquals(12, visitor.getSpeculativeGeneralities().size());
		Assert.assertTrue(visitor.getSpeculativeGeneralities().contains("org.eclipse.mylar.internal.tasks.ui.search.SearchResultContentProvider"));
		
	}
	
	
	@Test
	public void parseSwissArmyKnifeDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("swissArmyKnife.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.SWISS_ARMY_KNIFE);
		
		Assert.assertEquals(30, visitor.getSwissArmyKnives().size());
		Assert.assertTrue(visitor.getSwissArmyKnives().contains("org.gudy.azureus2.pluginsimpl.local.sharing.test.ShareTester"));
		
	}
	
	@Test
	public void parseBlobDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("blob.ini");
		processDetectorOutput(detectorOutput, DesignSmellAdapter.BLOB);
		
		Assert.assertEquals(8, visitor.getBlobs().size());
		
	}
	
	@Test
	public void parseAntisingletonDetectorOutput(){
		
		String antisingleton = loadPtidejOutputResource("antisingleton.ini");
		
		processDetectorOutput(antisingleton, DesignSmellAdapter.ANTISINGLETON);
		
		Assert.assertEquals(19, visitor.getAntiSingletons().size());
		
	}
	
	public void processDetectorOutput(String detectorOutput, String smellType){
		DesignSmellAdapter adapter = DesignSmellAdapterFactory.getAdapter(smellType);
		adapter.setOccurencesOutput(detectorOutput);
		adapter.accept(visitor);
	}
	
	
	protected String loadPtidejOutputResource(String fileName){
		String resourcepath = getTestResourcesPath("rsc", fileName); 
		File file = new File(resourcepath);
	
		try {
			StringBuffer fileContentsBuffer = new StringBuffer();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ( (line = br.readLine()) != null){
				fileContentsBuffer.append(line);
				fileContentsBuffer.append("\n");
			}
			
			return fileContentsBuffer.toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	
}

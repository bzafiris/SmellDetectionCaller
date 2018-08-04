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

import ptidej.sad.smelldetectioncaller.DesignSmells;
import ptidej.sad.smelldetectioncaller.JavaSmellDetectionCallerTestCase;

public class DesignSmellAdapterTest extends JavaSmellDetectionCallerTestCase {

	MockDesignSmellOccurenceVisitor visitor;
	
	@Before
	public void setup(){
		
		visitor = new MockDesignSmellOccurenceVisitor();
		
	}
	
	@Test
	public void parseBaseClassShouldBeAbstractDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("baseClassShouldBeAbstract.ini");
		processDetectorOutput(detectorOutput, DesignSmells.BASE_CLASS_SHOULD_BE_ABSTRACT);
		
		Assert.assertEquals(38, visitor
				.getBaseClassShouldBeAbstract()
				.size());
		
		Assert.assertTrue(visitor
				.getBaseClassShouldBeAbstract()
				.contains("org.apache.xerces.xinclude.XIncludeTextReader"));
		Assert.assertTrue(visitor
				.getBaseClassShouldBeAbstract()
				.contains("org.apache.xerces.impl.dv.DatatypeException"));
		
	}
	
	@Test
	public void parseClassDataShouldBePrivateDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("classDataShouldBePrivate.ini");
		processDetectorOutput(detectorOutput, DesignSmells.CLASS_DATA_SHOULD_BE_PRIVATE);
		
		Assert.assertEquals(4, visitor
				.getClassDataShouldBePrivate()
				.size());
		
		Assert.assertTrue(visitor
				.getClassDataShouldBePrivate()
				.contains("org.jfree.chart.axis.CyclicNumberAxis"));
		Assert.assertTrue(visitor
				.getClassDataShouldBePrivate()
				.contains("org.jfree.chart.ui.Size2D"));
		
	}
	
	@Test
	public void parseComplexClassDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("complexClass.ini");
		processDetectorOutput(detectorOutput, DesignSmells.COMPLEX_CLASS);
		
		Assert.assertEquals(3, visitor
				.getComplexClasses()
				.size());
		
		Assert.assertEquals(3, visitor
				.getLargeClasses()
				.size());
		
		Assert.assertTrue(visitor
				.getComplexClasses()
				.contains("org.jfree.chart.plot.Plot"));
		Assert.assertTrue(visitor
				.getLargeClasses()
				.contains("org.jfree.chart.renderer.xy.XYLineAndShapeRenderer"));
		
	}
	
	@Test
	public void parseFunctionalDecompositionDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("functionalDecomposition.ini");
		processDetectorOutput(detectorOutput, DesignSmells.FUNCTIONAL_DECOMPOSITION);
		
		Assert.assertEquals(19, visitor
				.getFunctionalDecompositionClasses()
				.size());
		Assert.assertTrue(visitor
				.getFunctionalDecompositionClasses()
				.contains("com.sncf.gl.app.referentiel.outils.presentation.SupprimerOutilAction"));
		Assert.assertTrue(visitor
				.getFunctionalDecompositionClasses()
				.contains("com.sncf.gl.app.referentiel.agent.metier.GestionPeriodes"));
		Assert.assertTrue(visitor
				.getFunctionalDecompositionClasses()
				.contains("com.sncf.gl.common.referentiel.habilitation.presentation.ReferentielStartupServlet"));
		
	}
	
	@Test
	public void parseLazyLargeClassDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("largeClass.ini");
		processDetectorOutput(detectorOutput, DesignSmells.LARGE_CLASS);
		
		Assert.assertEquals(17, visitor
				.getLargeClasses()
				.size());
		Assert.assertTrue(visitor
				.getLargeClasses()
				.contains("org.apache.xerces.validators.schema.XSchemaValidator"));
		Assert.assertTrue(visitor
				.getLargeClasses()
				.contains("org.apache.xerces.validators.dtd.DTDValidator"));
		
	}
	
	@Test
	public void parseLazyClassDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("lazyClass.ini");
		processDetectorOutput(detectorOutput, DesignSmells.LAZY_CLASS);
		
		Assert.assertEquals(22, visitor
				.getLazyClasses()
				.size());
		Assert.assertTrue(visitor
				.getLazyClasses()
				.contains("org.jfree.chart.text.AttributedStringUtils"));
		Assert.assertTrue(visitor
				.getLazyClasses()
				.contains("org.jfree.data.general.DefaultKeyedValuesDataset"));
		
	}
	
	@Test
	public void parseLongMethodDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("longMethod.ini");
		processDetectorOutput(detectorOutput, DesignSmells.LONG_METHOD);
		
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
		processDetectorOutput(detectorOutput, DesignSmells.LONG_PARAMETER_LIST);
		
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
		processDetectorOutput(detectorOutput, DesignSmells.MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX);
		
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
		processDetectorOutput(detectorOutput, DesignSmells.MESSAGE_CHAINS);
		
		Assert.assertEquals(9, visitor.getMessageChainsClasses().size());
		Assert.assertTrue(visitor
				.getMessageChainsClasses()
				.contains("demo.SurveyResultsDemo1"));
		
	}
	
	@Test
	public void parseRefusedParentBequestDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("refusedParentBequest.ini");
		processDetectorOutput(detectorOutput, DesignSmells.REFUSED_PARENT_BEQUEST);
		
		Assert.assertEquals(13, visitor.getRefusedParentBequestClasses().size());
		Assert.assertTrue(visitor
				.getRefusedParentBequestClasses()
				.contains("org.jfree.chart.entity.CategoryLabelEntity"));
		
	}
	
	@Test
	public void parseSpaghettiCodeDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("spaghettiCode.ini");
		processDetectorOutput(detectorOutput, DesignSmells.SPAGHETTI_CODE);
		
		Assert.assertEquals(3, visitor.getSpaghettiCodeClasses().size());
		Assert.assertTrue(visitor.getSpaghettiCodeClasses().contains("org.argouml.ui.targetmanager.TargetManager"));
		
	}
	
	@Test
	public void parseSpeculativeGeneralityDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("speculativeGenerality.ini");
		processDetectorOutput(detectorOutput, DesignSmells.SPECULATIVE_GENERALITY);
		
		Assert.assertEquals(12, visitor.getSpeculativeGeneralities().size());
		Assert.assertTrue(visitor.getSpeculativeGeneralities().contains("org.eclipse.mylar.internal.tasks.ui.search.SearchResultContentProvider"));
		
	}
	
	
	@Test
	public void parseSwissArmyKnifeDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("swissArmyKnife.ini");
		processDetectorOutput(detectorOutput, DesignSmells.SWISS_ARMY_KNIFE);
		
		Assert.assertEquals(30, visitor.getSwissArmyKnives().size());
		Assert.assertTrue(visitor.getSwissArmyKnives().contains("org.gudy.azureus2.pluginsimpl.local.sharing.test.ShareTester"));
		
	}
	
	@Test
	public void parseBlobDetectorOutput(){
		
		String detectorOutput = loadPtidejOutputResource("blob.ini");
		processDetectorOutput(detectorOutput, DesignSmells.BLOB);
		
		Assert.assertEquals(8, visitor.getBlobs().size());
		
		Assert.assertTrue(visitor
				.getBlobs()
				.contains("org.jfree.chart.ChartPanel"));
		Assert.assertTrue(visitor
				.getBlobs()
				.contains("org.jfree.chart.plot.CategoryPlot"));
		
		Assert.assertEquals(2, visitor.getLowCohesionClasses().size());
		
		Assert.assertTrue(visitor
				.getLowCohesionClasses()
				.contains("org.jfree.chart.axis.ValueTick"));
		Assert.assertTrue(visitor
				.getLowCohesionClasses()
				.contains("org.jfree.data.KeyedValueComparator"));
		
		Assert.assertEquals(10, visitor.getDataClasses().size());
		
		Assert.assertTrue(visitor
				.getDataClasses()
				.contains("org.jfree.chart.axis.DateTickMarkPosition"));
		Assert.assertTrue(visitor
				.getDataClasses()
				.contains("org.jfree.chart.axis.TickType"));
		
	}
	
	@Test
	public void parseAntisingletonDetectorOutput(){
		
		String antisingleton = loadPtidejOutputResource("antisingleton.ini");
		
		processDetectorOutput(antisingleton, DesignSmells.ANTISINGLETON);
		
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

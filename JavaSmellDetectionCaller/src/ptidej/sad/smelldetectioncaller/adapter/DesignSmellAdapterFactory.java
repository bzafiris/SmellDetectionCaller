package ptidej.sad.smelldetectioncaller.adapter;
 
public class DesignSmellAdapterFactory {

	

	public static DesignSmellAdapter getAdapter(String antiPatternName) {

		switch (antiPatternName) {

		case DesignSmellAdapter.ANTISINGLETON:
			return new AntisingletonAdapter();
		case DesignSmellAdapter.BLOB:
			return new BlobAdapter();
		case DesignSmellAdapter.SWISS_ARMY_KNIFE:
			return new SwissArmyKnifeAdapter();
		case DesignSmellAdapter.SPECULATIVE_GENERALITY:
			return new SpeculativeGeneralityAdapter();
		case DesignSmellAdapter.SPAGHETTI_CODE:
			return new SpaghettiCodeAdapter();
		case DesignSmellAdapter.REFUSED_PARENT_BEQUEST:
			return new RefusedParentRequestAdapter();
		case DesignSmellAdapter.MESSAGE_CHAINS:
			return new MessageChainsAdapter();
		case DesignSmellAdapter.MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX:
			return new ManyFieldAttributesButNotComplexAdapter();
		case DesignSmellAdapter.LONG_PARAMETER_LIST:
			return new LongParameterListAdapter();
		case DesignSmellAdapter.LONG_METHOD:
			return new LongMethodAdapter();
		case DesignSmellAdapter.LAZY_CLASS:
			return new LazyClassAdapter();
		case DesignSmellAdapter.LARGE_CLASS:
			return new LargeClassAdapter();
		case DesignSmellAdapter.FUNCTIONAL_DECOMPOSITION:
			return new FunctionalDecompositionAdapter();

		}

		return null;

	}

}

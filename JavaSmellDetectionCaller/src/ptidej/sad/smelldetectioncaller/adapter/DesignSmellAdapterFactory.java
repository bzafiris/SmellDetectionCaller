package ptidej.sad.smelldetectioncaller.adapter;

import ptidej.sad.smelldetectioncaller.DesignSmells;

/**
 * 
 * @author bzafiris
 *
 */
public class DesignSmellAdapterFactory {

	public static DesignSmellAdapter getAdapter(String antiPatternName) {

		switch (antiPatternName) {

		case DesignSmells.ANTISINGLETON:
			return new AntisingletonAdapter();
		case DesignSmells.BLOB:
			return new BlobAdapter();
		case DesignSmells.SWISS_ARMY_KNIFE:
			return new SwissArmyKnifeAdapter();
		case DesignSmells.SPECULATIVE_GENERALITY:
			return new SpeculativeGeneralityAdapter();
		case DesignSmells.SPAGHETTI_CODE:
			return new SpaghettiCodeAdapter();
		case DesignSmells.REFUSED_PARENT_BEQUEST:
			return new RefusedParentRequestAdapter();
		case DesignSmells.MESSAGE_CHAINS:
			return new MessageChainsAdapter();
		case DesignSmells.MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX:
			return new ManyFieldAttributesButNotComplexAdapter();
		case DesignSmells.LONG_PARAMETER_LIST:
			return new LongParameterListAdapter();
		case DesignSmells.LONG_METHOD:
			return new LongMethodAdapter();
		case DesignSmells.LAZY_CLASS:
			return new LazyClassAdapter();
		case DesignSmells.LARGE_CLASS:
			return new LargeClassAdapter();
		case DesignSmells.FUNCTIONAL_DECOMPOSITION:
			return new FunctionalDecompositionAdapter();
		case DesignSmells.COMPLEX_CLASS:
			return new ComplexClassAdapter();
		case DesignSmells.CLASS_DATA_SHOULD_BE_PRIVATE:
			return new ClassDataShouldBePrivateAdapter();
		case DesignSmells.BASE_CLASS_SHOULD_BE_ABSTRACT:
			return new BaseClassShouldBeAbstractAdapter();
		case DesignSmells.BASE_CLASS_KNOWS_DERIVED_CLASS:
			return new BaseClassKnowsDerivedClassAdapter();
		case DesignSmells.TRADITION_BREAKER:
			return new TraditionBreakerAdapter();

		}

		return null;

	}

}

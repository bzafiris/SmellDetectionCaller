package ptidej.sad.smelldetectioncaller;

public class DesignSmells {
	
	// done
	public static final String ANTISINGLETON = "AntiSingleton";
	// needs testing
	public static final String TRADITION_BREAKER = "TraditionBreaker";
	// done
	public static final String SWISS_ARMY_KNIFE = "SwissArmyKnife";
	// done
	public static final String SPECULATIVE_GENERALITY = "SpeculativeGenerality";
	// done
	public static final String SPAGHETTI_CODE = "SpaghettiCode";
	// done
	public static final String REFUSED_PARENT_BEQUEST = "RefusedParentBequest";
	// done
	public static final String MESSAGE_CHAINS = "MessageChains";
	// done
	public static final String MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX = "ManyFieldAttributesButNotComplex";
	// done
	public static final String LONG_PARAMETER_LIST = "LongParameterList";
	// done
	public static final String LONG_METHOD = "LongMethod";
	// done
	public static final String LAZY_CLASS = "LazyClass";
	// done
	public static final String LARGE_CLASS = "LargeClass";
	// done
	public static final String FUNCTIONAL_DECOMPOSITION = "FunctionalDecomposition";
	// done
	public static final String COMPLEX_CLASS = "ComplexClass";
	// done
	public static final String CLASS_DATA_SHOULD_BE_PRIVATE = "ClassDataShouldBePrivate";
	// done
	public static final String BLOB = "Blob";
	// done
	public static final String BASE_CLASS_SHOULD_BE_ABSTRACT = "BaseClassShouldBeAbstract";
	// needs testing, not working properly
	public static final String BASE_CLASS_KNOWS_DERIVED_CLASS = "BaseClassKnowsDerivedClass";

	public static final String [] LIST = new String[]{
		ANTISINGLETON, BASE_CLASS_KNOWS_DERIVED_CLASS, BASE_CLASS_SHOULD_BE_ABSTRACT,
		BLOB, CLASS_DATA_SHOULD_BE_PRIVATE, COMPLEX_CLASS, 
		FUNCTIONAL_DECOMPOSITION, LARGE_CLASS, LAZY_CLASS, 
		LONG_METHOD, LONG_PARAMETER_LIST, MANY_FIELD_ATTRIBUTES_BUT_NOT_COMPLEX, 
		MESSAGE_CHAINS, REFUSED_PARENT_BEQUEST, SPAGHETTI_CODE, 
		SPECULATIVE_GENERALITY, SWISS_ARMY_KNIFE, TRADITION_BREAKER
	};
	
	
}

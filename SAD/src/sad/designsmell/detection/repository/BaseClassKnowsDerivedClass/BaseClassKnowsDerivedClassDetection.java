/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Ga�l Gu�h�neuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Ga�l Gu�h�neuc and others, see in file; API and its implementation
 ******************************************************************************/
package sad.designsmell.detection.repository.BaseClassKnowsDerivedClass;

/**
 * This class implements the detection algorithms 
 * of the design smell BaseClassKnowsDerivedClass.
 * 
 * @author Autogenerated files
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import padl.kernel.IAbstractLevelModel;
import sad.codesmell.detection.repository.BaseClassKnowsDerivedClass.*;
import sad.kernel.ICodeSmell;
import sad.codesmell.detection.ICodeSmellDetection;
import sad.designsmell.detection.IDesignSmellDetection;
import sad.designsmell.detection.repository.AbstractDesignSmellDetection;
import sad.kernel.impl.DesignSmell;
import sad.util.OperatorsCodeSmells;
import sad.util.Relationships;

public class BaseClassKnowsDerivedClassDetection extends AbstractDesignSmellDetection implements IDesignSmellDetection {
	private final OperatorsCodeSmells operators;
	private final Relationships relations;

	public BaseClassKnowsDerivedClassDetection() {
		super();

		this.operators = OperatorsCodeSmells.getInstance();
		this.relations = Relationships.getInstance();
	}

	public String getName() {
		return "BaseClassKnowsDerivedClass";
	}

	public String getRuleCardFile() {
		return "../SAD Rules Creator/rsc/BaseClassKnowsDerivedClass.rules";
	}

	public void detect(final IAbstractLevelModel anAbstractLevelModel) {
		final Set candidateDesignSmells = new HashSet();

		final ICodeSmellDetection csHasChildren = new HasChildrenDetection();
		csHasChildren.detect(anAbstractLevelModel);
		final Set setHasChildren = ((HasChildrenDetection) csHasChildren).getCodeSmells();

		final ICodeSmellDetection csNoInheritance = new NoInheritanceDetection();
		csNoInheritance.detect(anAbstractLevelModel);
		final Set setNoInheritance = ((NoInheritanceDetection) csNoInheritance).getCodeSmells();

		final Set setBaseClass = this.operators.intersection(setNoInheritance, setHasChildren);

		final ICodeSmellDetection csNotAbstract = new NotAbstractDetection();
		csNotAbstract.detect(anAbstractLevelModel);
		final Set setNotAbstract = ((NotAbstractDetection) csNotAbstract).getCodeSmells();

		final ICodeSmellDetection csTwoInheritance = new TwoInheritanceDetection();
		csTwoInheritance.detect(anAbstractLevelModel);
		final Set setTwoInheritance = ((TwoInheritanceDetection) csTwoInheritance).getCodeSmells();

		final Set setDerivedClass = this.operators.intersection(setTwoInheritance, setNotAbstract);

		final Set setBaseClassInheritDerivedClass = this.relations.checkAssociationOneToOne(4, setBaseClass,
				setDerivedClass);

		final Set setBaseClassAssociateDerivedClass = this.relations.checkAssociationOneToOne(1, setBaseClass,
				setDerivedClass);

		final Set setBaseClassKnowsDerivedClass = this.operators.intersection(setBaseClassAssociateDerivedClass,
				setBaseClassInheritDerivedClass);

		final Iterator iterSet = setBaseClassKnowsDerivedClass.iterator();
		while (iterSet.hasNext()) {
			final ICodeSmell aCodeSmell = (ICodeSmell) iterSet.next();
			final DesignSmell designSmell = new DesignSmell(aCodeSmell);
			designSmell.setName("BaseClassKnowsDerivedClass");
			final String definition = "To defined";
			designSmell.setDefinition(definition);
			candidateDesignSmells.add(designSmell);
		}
		this.setSetOfDesignSmells(candidateDesignSmells);
	}
}

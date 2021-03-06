/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Gaël Guéhéneuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Gaël Guéhéneuc and others, see in file; API and its implementation
 ******************************************************************************/
package ptidej.sad.smelldetectioncaller;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import ptidej.sad.smelldetectioncaller.util.ConsoleLogger;
import ptidej.sad.smelldetectioncaller.util.DirectoryFilter;
import ptidej.sad.smelldetectioncaller.util.FileLogger;
import ptidej.sad.smelldetectioncaller.util.Logger;
import ptidej.sad.smelldetectioncaller.util.SourceDirectoryScanner;

public class SmellDetectionCaller {

	public static String[] DIR_PATTERNS = new String[] { "src/main/java/" };

	public static void main(final String[] args) {

		if (args.length < 3) {
			System.out.println("Usage: SmellDetectionCaller <projectName> <rootFolder> <outputFolder>");
			return;
		}
		/*
		 * SmellDetectionHelper.
		 * analyseCodeLevelModelFromJavaClassFiles("../0 - SmellDetectionCaller/bin/"
		 * , "SmellDetectionCaller Itself", "rsc/");
		 */

		String projectName = args[0];
		String rootFolder = args[1];
		String outputFolder = args[2];

		DirectoryFilter fileFilter = DirectoryFilter.production();
		SourceDirectoryScanner sourceDirectoryScanner = new SourceDirectoryScanner(fileFilter, rootFolder);

		String[] sourcePaths = sourceDirectoryScanner.listSourcePaths();

		for (String path : sourcePaths) {
			System.out.println(path);
		}

		DesignSmellOccurenceVisitor visitor = new DesignSmellOccurenceVisitor();

		SmellDetectionHelper smellDetectionHelper = new SmellDetectionHelper(visitor);
		smellDetectionHelper.analyseCodeLevelModelFromJavaSourceFilesEclipse(SmellDetectionHelper.SMELLS,
				new String[] {}, sourcePaths, projectName, outputFolder);

		
		String fileName = outputFolder + File.separator + projectName + "-smells.csv";
		
		Logger logger = FileLogger.getInstance(fileName);
		logger.logHeaders();

		Map<String, DesignSmellOccurrenceSummary> map = visitor.getDesignSmellOccurrencesPerClass();
		for (Entry<String, DesignSmellOccurrenceSummary> entry : map.entrySet()) {

			logger.log(entry.getKey(), entry.getValue().getDesignSmellOccurrences());

		}

		logger.close();
	}

}

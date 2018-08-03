package ptidej.sad.smelldetectioncaller.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceDirectoryScanner {

	DirectoryFilter filter;
	String rootDirectory;

	public SourceDirectoryScanner(DirectoryFilter filter, String rootDirectory) {
		super();
		this.filter = filter;
		this.rootDirectory = rootDirectory;
	}

	public String[] listSourcePaths() {

		File rootDir = new File(rootDirectory);
		
		DirectoryFilter filter = DirectoryFilter.production();
		
		String [] dirContents = rootDir.list();
		String[] sourcePaths = getSourcePaths(filter, rootDirectory, dirContents);
		
		return sourcePaths;
	}

	static String[] getSourcePaths(DirectoryFilter filter, String root, String[] dirContents) {

		List<String> sourcePathList = new ArrayList<>();

		for (String filePath : dirContents) {
			String fullPath = root + File.separator + filePath;
			// System.out.println("Processing " + fullPath);
			File file = new File(fullPath);

			if (file.isDirectory()) {
				if (filter.accept(fullPath)) {
					sourcePathList.add(fullPath);
				} else {
					String[] arSourcePaths = getSourcePaths(filter, fullPath, file.list());
					if (arSourcePaths != null && arSourcePaths.length > 0) {
						sourcePathList.addAll(Arrays.asList(arSourcePaths));
					}
				}
			}
		}

		return sourcePathList.toArray(new String[sourcePathList.size()]);
	}

}

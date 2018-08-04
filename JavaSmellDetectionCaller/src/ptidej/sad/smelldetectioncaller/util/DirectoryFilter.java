package ptidej.sad.smelldetectioncaller.util;

import java.util.ArrayList;
import java.util.List;

public class DirectoryFilter {

    private static final DirectoryFilter NO_FILTER = new DirectoryFilter();

    private final List<String> inclusionPatterns = new ArrayList<>();
    private final List<String> exclusionPatterns = new ArrayList<>();

    DirectoryFilter() {
    }

    /**
     * Creates a filter that only let through production code. (no tests or examples)
     *
     * @return a new instance of the filter
     */
    public static DirectoryFilter production() {
        final DirectoryFilter fileFilter = new DirectoryFilter();
        fileFilter.addInclusionPattern("src/main/java");
//        fileFilter.addInclusionPattern("src");
        fileFilter.addExclusionPattern("src/test/java");
        return fileFilter;
    }

    public static DirectoryFilter noFilter() {
        return NO_FILTER;
    }

    void addInclusionPattern(String pattern) {
        inclusionPatterns.add(pattern);
    }
    
   
    void addExclusionPattern(String pattern) {
        exclusionPatterns.add(pattern);
    }

    /**
     * Checks if a path is conform to this filter.
     *
     * @param path the path
     * @return <code>true</code> if the path is conform
     */
    public boolean accept(String path) {
       
        for (String pattern : inclusionPatterns) {
            if (path.endsWith(pattern)) {
                return true;
            }
        }
        
        return false;
    }
}

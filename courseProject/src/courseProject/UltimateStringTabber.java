//Caleb Barbee CIS407 Week 6: Course Project
package courseProject;

//import java.util.ArrayList;
import java.util.List;

/**
 * Drop-in class to allow for "easy" alignment of columns of strings.
 * @author Caleb Barbee
 */
public class UltimateStringTabber {

	/**
	 * Returns a list of strings with tabs automatically appended such that all strings are of equal length
	 * @param stringList - An n-sized list of strings needing to be tab-aligned
	 * @param makeBars - An optional decorative addition of "| " prepended on every item
	 * @return List of tab-aligned strings optionally with decorative bars
	 */
	public static List<String> ultimateStringTabber(List<String> stringList, boolean makeBars) {

		// Optional decorative bars
		if (makeBars) {
			for (int i = 0; i < stringList.size(); i++) {
				stringList.set(i, "| " + stringList.get(i));
			}
		}
		
		// The tab size in my console is 8 characters
		int tabSize = 8;
		int maxSize = 0;
		
		// Find the length of the longest string in the list
		for (String string : stringList) {
			if (string.length() > maxSize) {
				maxSize = string.length();
			}
		}
		// Find the number of tabs needed to reach that length
		int tabLength = maxSize / tabSize;
		for (int i = 0; i < stringList.size(); i++) {
			String currString = stringList.get(i);
			int tabDiff = tabLength - (currString.length() / tabSize);
			for (int x = 0; x < Math.max(0, tabDiff); x++) {
				// Tab string up to the block the longest one is in
				currString += "\t";
			}
			// Add one more tab so everything aligns
			currString += "\t";
			stringList.set(i, currString);
		}
		
		return stringList;
		
	}
	
}

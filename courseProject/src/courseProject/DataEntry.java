//Caleb Barbee CIS407 Week 4: Course Project
package courseProject;

public class DataEntry {
	
	public static boolean validateString(String entry) {
		return (!(entry.isBlank()));
	}
	
	public static boolean validateStringLength(String entry, int length) {
		return (!(entry.isBlank()) && (entry.length() <= length));
	}
	
	public static boolean validateStringExactLength(String entry, int length) {
		return (entry.length() == length);
	}
	
	public static boolean validateStringNumeric(String entry) {
		// Regex matches on at least one digit, and only digits
		// Ex:
		//		"999".matches()	=> true
		//		"9".matches()	=> true
		//		"9-9".matches()	=> false
		return entry.matches("\\d+");
	}
	
	public static boolean validateIntRange(int entry, int min, int max) {
		return (min <= entry && entry <= max);
	}
	
	public static boolean validateDecimalRange(float entry, float min, float max) {
		return (min <= entry && entry <= max);
	}
	
	public static boolean validateDate(String entry) {
		// Regex matches MM/DD/YYYY or M/D/YYYY
		// Ex:
		//		1/1/2010.matches()		=> true
		//		11/1/2010.matches()		=> true
		//		1/11/2010.matches()		=> true
		//		11/11/2010.matches()	=> true
		//		1/1/10.matches()		=> false
		return (entry.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}"));
	}

}

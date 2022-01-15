import java.util.*;

class Program {

  public ArrayList<String> validIPAddresses(String string) {
		ArrayList<String> result = new ArrayList<String> ();
		int maxLength = string.length();
    // Write your code here.
    for (int i = 1; i <= Math.min(3, maxLength - 1); i++ ) {
			String subString1 = string.substring(0, i);
			if (isValid(subString1)) {
				for (int j = i + 1; j <= Math.min(i + 3, maxLength - 1); j++ ) {
					String subString2 = string.substring(i, j);
					if (isValid(subString2)) {
						for (int k = j + 1; k <= Math.min(j + 3, maxLength - 1); k++ ) {
							String subString3 = string.substring(j, k);
								if (isValid(subString3)) {
										  String subString4 = string.substring(k, maxLength);
											if (isValid(subString4)) {result.add(subString1 + "." + subString2+ "." + subString3 + "." + subString4);}
											}
									}
							}
						}
					}
				}
		return result;
	}
	
	public boolean isValid (String substring) {
		if (substring.charAt(0) == '0' && substring.length() > 1) {return false;} else {
			int convertedToInteger = Integer.parseInt(substring);
			if (convertedToInteger >=0 && convertedToInteger <= 255) {return true;} else {return false;}
		}
	}
}

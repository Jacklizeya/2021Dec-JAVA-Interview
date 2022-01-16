import java.util.*;

class Program {

  public String reverseWordsInString(String string) {
    // Write your code here.
		if (string.equals("")) {return new String("");}
		
		String result = "";
		String currentSlice = string.substring(0, 1);
		for (int i = 1; i < string.length(); i++) {
			if ((string.charAt(i) != ' ' && string.charAt(i - 1) == ' ') || (string.charAt(i) == ' ' && string.charAt(i - 1) != ' ') ) {
				result = currentSlice + result;
				currentSlice = string.substring(i, i+1);
			} else {
				currentSlice = currentSlice + string.substring(i, i+1);
			}
		}
		result = currentSlice + result;
		
    return result;
  }
}

import java.util.*;

class Program {
  public String runLengthEncoding(String string) {
    // Write your code here.
		String result = "";
		char currentChar = string.charAt(0);
		int count  = 1;
		
		for (int i = 1; i < string.length(); i++) {
			if (string.charAt(i) == currentChar) {
				count++;
				// clear
				if (count == 10) {result = result + 9 + currentChar; count = 1;}
			}
			else {
				// add all previous to result
				result = result + count + currentChar; 
				// reset
				currentChar = string.charAt(i);
				count = 1;
			}
		}
		// for the last one
		result = result + count + currentChar;
				
    return result;
  }
}

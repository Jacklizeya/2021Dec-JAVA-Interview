import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int sequenceLocator = 0;
		int arrayScanner = 0;
		while (sequenceLocator < sequence.size() && arrayScanner < array.size()) {
			if (array.get(arrayScanner) == sequence.get(sequenceLocator) ) {sequenceLocator++;}			
			arrayScanner++;
		}
	
    if (sequenceLocator == sequence.size()) {return true;} else {return false;}
  }
}

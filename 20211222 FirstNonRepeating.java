import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
		Map <Character, Integer> frequency = new HashMap<Character, Integer> ();
		for (int i= 0; i < string.length(); i++) {
			char currentKey = string.charAt(i);
			if (frequency.containsKey(currentKey)) {
				frequency.put(currentKey, frequency.get(currentKey) + 1);
			} else {
				frequency.put(currentKey, 1);
			}
		}
		
		for (int i=0; i < string.length(); i++) {
			char currentKey = string.charAt(i);
			if (frequency.get(currentKey) == 1) {return i;}
		}
		
    return -1;
  }
}

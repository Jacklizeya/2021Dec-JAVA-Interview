import java.util.*;

class Program {

  public boolean generateDocument(String characters, String document) {
    // Write your code here.
		Map<Character, Integer> input = new HashMap<Character, Integer> ();
		Map<Character, Integer> output = new HashMap<Character, Integer> ();
		
		for (int i= 0; i < characters.length(); i++) {
			char inputChar = characters.charAt(i);
			if (input.containsKey(inputChar)) {input.put(inputChar, input.get(inputChar) + 1);} else {
				input.put(inputChar, 1);
			}
		}
		
		for (int i= 0; i < document.length(); i++) {
			char outputChar = document.charAt(i);
			if (output.containsKey(outputChar)) {output.put(outputChar, output.get(outputChar) + 1);} else {
				output.put(outputChar, 1);
			}
		}
		
		for (char key : output.keySet()) {
			if (!input.containsKey(key) || input.get(key) < output.get(key)) {return false;}
		}
		
    return true;
  }
}

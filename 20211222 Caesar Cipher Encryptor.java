import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
		String result = "";
		for (int i =0 ; i < str.length(); i++) {
			char initialCharacter = str.charAt(i);
			int newIndex = ("abcdefghijklmnopqrstuvwxyz".indexOf(initialCharacter) + key) % 26;
			char newCharacter = "abcdefghijklmnopqrstuvwxyz".charAt(newIndex);
			result += newCharacter;
		}
    return result;
  }
}

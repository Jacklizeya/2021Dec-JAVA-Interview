import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Set<Integer> storage = new HashSet<Integer> ();
		for (int value : array) {
			if (storage.contains(targetSum - value)) {return new int[] {targetSum - value, value};}
			else {storage.add(value);}
		}

		return new int[0];
  }
}

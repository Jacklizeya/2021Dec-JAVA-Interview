// Solution 1: less optimal

import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == targetSum) {return new int[] {array[i], array[j]};}
			}
		}
		
		
		
    return new int[0];
  }
}

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

// Time: o(N) Space: O(N)

// Solution 3
import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Arrays.sort(array);
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		while (leftPointer < rightPointer) {
			if (array[leftPointer] + array[rightPointer] < targetSum) {leftPointer++;}
			else if (array[leftPointer] + array[rightPointer] > targetSum) {rightPointer--;}
			else {return new int[] {array[leftPointer], array[rightPointer]};}
		}
		
    return new int[0];
  }
}

// time n * logn, space: 1

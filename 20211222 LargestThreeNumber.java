import java.util.*;

class Program {
  public static int[] findThreeLargestNumbers(int[] array) {
    // Write your code here.
    int [] largestThree = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		for (int number : array) {
			if (number >= largestThree[2]) {largestThree[0] = largestThree[1]; largestThree[1] = largestThree[2]; largestThree[2] = number;}
			else if (number >= largestThree[1]) {largestThree[0] = largestThree[1]; largestThree[1] = number;}
			else if (number >= largestThree[0]) {largestThree[0] = number;}
		}
		return largestThree;
  }
}

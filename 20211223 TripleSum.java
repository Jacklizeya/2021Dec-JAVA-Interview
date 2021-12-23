import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		Arrays.sort(array);
		for (int left = 0; left < array.length - 2; left++) {
			int twoSum = targetSum - array[left];
			int middle = left + 1; 
			int right = array.length - 1;
			while (middle < right) {
				if (array[middle] + array[right] == twoSum) {
					result.add(new Integer[] {array[left], array[middle], array[right]});
					right--;
					middle++;
				}
				else if (array[middle] + array[right] > twoSum) {right--;}
				else {middle ++;}
			}
		}
    return result;
  }
}

import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int[] result = new int[array.length];
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		for (int i = result.length -1; i >= 0; i--) {
			if (Math.abs(array[leftPointer]) < Math.abs(array[rightPointer])) {
				result[i] = array[rightPointer] * array[rightPointer];
				rightPointer--;
			} else {
				result[i] = array[leftPointer] * array[leftPointer];
				leftPointer++;
			}
		}
		
		
    return result;
  }
}

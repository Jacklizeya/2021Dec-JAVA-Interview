import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		boolean needSwapping = true;
		while (needSwapping) {
			needSwapping = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) {
					swap(array, i, i+1);
					needSwapping = true;
				}
			}
		}
		return array;
  }
	
	public static void swap(int[] array, int i, int j) {
		int temporary = array[i];
		array[i] = array[j];
		array[j] = temporary;
	}
}

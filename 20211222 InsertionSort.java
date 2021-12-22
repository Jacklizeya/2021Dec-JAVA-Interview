import java.util.*;

// This is not very efficient, it use Ologn

class Program {
  public static int[] insertionSort(int[] array) {
    // Write your code here.
		
		for (int i = 1 ; i < array.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1); 
				} else {break;}
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

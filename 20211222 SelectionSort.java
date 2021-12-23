// Find the smallest on each iteration to place it at the right place

import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
		
		for (int locationToPlace = 0 ; locationToPlace < array.length - 1; locationToPlace++) {
			int indexOfMinimum = locationToPlace;
			int minimum = array[indexOfMinimum];
			for (int i = locationToPlace + 1; i < array.length; i++) {
				if (array[i] < minimum) {
					indexOfMinimum = i;
					minimum = array[i];
				}
			}
			if (indexOfMinimum != locationToPlace) {swap(array, indexOfMinimum, locationToPlace);}
		}
		
    return array;
  }
	
	
	public static void swap(int[] array, int i, int j) {
		int temporary = array[i];
		array[i] = array[j];
		array[j] = temporary;
	}
}

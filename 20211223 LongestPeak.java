// Only consider the middle portion


import java.util.*;

class Program {
  public static int longestPeak(int[] array) {
    // Write your code here.
		int maxLength = 0;
    for (int i = 1; i < array.length - 1; i++) {
				if ( i > 0 && i < array.length && array[i] > array[i - 1] && array[i] > array[i + 1]) {
					  int left = i;
					  int right = i;
					  while(right + 1 < array.length && array[right + 1] < array[right]) {right++;}
					  while(left - 1 >= 0 && array[left - 1] < array[left]) {left--;}
					  maxLength = Math.max(maxLength, right - left + 1); 
				}
		}
			
		return maxLength;
	}
}

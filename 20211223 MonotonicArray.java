import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
    // Write your code here.
		if (array.length <= 2) {return true;}
		
		if (array[array.length -1] > array[0]) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {return false;}
			}
		} else {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i + 1]) {return false;}
			}
		}
				
		
    return true;
  }
}

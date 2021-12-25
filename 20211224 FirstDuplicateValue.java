import java.util.*;

// Cyclic Sorting

class Program {

  public int firstDuplicateValue(int[] array) {
    // Write your code here.
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		for (int i= 0; i < array.length; i++) {
			int number = array[i];
			if (frequency.containsKey(number)) {return array[i];} 
			else {frequency.put(number, 1);}
		}
			
		return -1;
  }
	
	
}

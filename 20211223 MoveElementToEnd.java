import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		if (array.size() == 0) {return array;}
		
    // Write your code here.
		int left = 0;
		while (left < array.size() && array.get(left) != toMove) {left++;}
		int right = array.size() - 1;
		while (right >=0 && array.get(right) == toMove) {right--;}
		
		while (left < right) {
			swap(array, left, right);
			while (array.get(left) != toMove) {left++;}
			while (array.get(right) == toMove) {right--;}
		}
	
    return array;
	
  }
	
	public static void swap(List<Integer> array, int left, int right) {
		int temporary = array.get(left);
		array.set(left, array.get(right));
		array.set(right, temporary);
	}
}

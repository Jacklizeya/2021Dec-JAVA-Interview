import java.util.*;

class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    int leftPointer = 0;
		int rightPointer = array.length -1;
		while (leftPointer <= rightPointer) {
			int middle = Math.floorDiv(leftPointer + rightPointer, 2);
			if (array[middle] == target) {return middle;}
			else if (array[middle] < target) {leftPointer = middle + 1;}
			else {rightPointer = middle - 1;}
		}

		return -1;
  }
}

// And Recursively do it, space logn (n layer of calls)

import java.util.*;

class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    return BST(array, target, 0, array.length - 1);
  }
	
	public static int BST(int[] array, int target, int left, int right) {
		if (left > right) {return -1;}
		
		int middle = Math.floorDiv(left + right, 2);
		if (array[middle] == target) {return middle;}
		else if (array[middle] < target) {return BST(array, target, left + 1, right);}
		else {return BST(array, target, left, right -1);}
	}
}

import java.util.*;

class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    // Write your code here.
    return calculateLevelSum(array, 1);
  }
	
	public static int calculateLevelSum(List<Object> array, int depth) {
		int sum = 0;
		for (Object element : array) {
			if (!(element instanceof ArrayList)) {sum += (int) element * depth;} 
			else {
				ArrayList<Object> elementInArrayListStyle = (ArrayList<Object>) element;
				sum += calculateLevelSum(elementInArrayListStyle, depth + 1) * depth;
			}
		}
		return sum;
	}
}

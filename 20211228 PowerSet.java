import java.util.*;

class Program {
  public static List<List<Integer>> powerset(List<Integer> array) {
    // Write your code here.
    List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer> ());
		
		for (Integer element : array) {
			int size = result.size();
			
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> toBeCopy = (ArrayList<Integer>) result.get(i);
				ArrayList<Integer> copied = new ArrayList<Integer> (toBeCopy);
				copied.add(element);
				result.add(copied);
			}
		}
		
		return result;
		
  }
}

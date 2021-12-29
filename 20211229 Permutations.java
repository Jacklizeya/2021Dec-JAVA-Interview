import java.util.*;

class Program {
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
		if (array.size() == 0) {return new ArrayList(new ArrayList());}
		
    List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		addToPath(array, path, result);
		return result;
  }
	
	public static void addToPath(List<Integer> array, List<Integer> path, List<List<Integer>> result) {
		if (array.size() == 0) {result.add(path);}

		for (int i =0 ; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = new ArrayList<Integer>(array);
			  ArrayList<Integer> pathCopy = new ArrayList<Integer>(path);
			  pathCopy.add(arrayCopy.get(i));
			  arrayCopy.remove(i);
			  addToPath(arrayCopy, pathCopy, result);
		}
	}
}


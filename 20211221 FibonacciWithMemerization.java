import java.util.*;

class Program {
  public static int getNthFib(int n) {
    // Write your code here.
		Map <Integer, Integer> storage = new HashMap<Integer, Integer> ();
		storage.put(1, 0);
		storage.put(2, 1);
    return calculateWithDynamic(n, storage);
  }
	
	public static int calculateWithDynamic(int n, Map <Integer, Integer> storage) {
		if (storage.containsKey(n)) {return storage.get(n);}
		
		int result = calculateWithDynamic(n - 1, storage) + calculateWithDynamic(n - 2, storage);
		storage.put(n, result);
		return storage.get(n);
	}
}

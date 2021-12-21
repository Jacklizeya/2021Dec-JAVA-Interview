import java.util.*;

class Program {

  public int minimumWaitingTime(int[] queries) {
    // Write your code here.
		Arrays.sort(queries);
		int sum = 0;
		for (int i = 0 ; i < queries.length; i++) {
			sum += queries[i] * (queries.length - i - 1);
		}
    return sum;
  }
}

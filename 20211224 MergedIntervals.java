import java.util.*;

class Program {

  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		ArrayList<int[]> mergedIntervals = new ArrayList<int[]> ();
		int left = intervals[0][0];
		int right = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int[] element = intervals[i];
			if (element[0] > right) {
				int[] toBeAdded = new int[] {left, right};
				mergedIntervals.add(toBeAdded);
				left = element[0];
				right = element[1];
			} else {
				right = Math.max(right, element[1]);
			}
		}
		mergedIntervals.add(new int[] {left, right});
		
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }
}

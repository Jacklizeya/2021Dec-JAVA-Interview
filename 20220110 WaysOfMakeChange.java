import java.util.*;

class Program {
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    // Write your code here.
    int ways[] = new int[n + 1];
		ways[0] = 1;
		for (int denom : denoms) {
			for (int i = 0; i < ways.length; i++) {
				if (i >= denom) {
					ways[i] = ways[i] + ways[i - denom];
				}
			}
		}
		return ways[n];
  }
}

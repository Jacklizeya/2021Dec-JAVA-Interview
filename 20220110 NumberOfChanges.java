// There is a Logic problem

import java.util.*;

class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
		Arrays.sort(denoms);
    int count = 0;
		for (int i = denoms.length - 1; i >=0; i--) {
			int countForThisChange = Math.floorDiv(n, denoms[i]);
			count += countForThisChange;
			n = n - countForThisChange * denoms[i];
		}
		if (n == 0) {return count;} else {return -1;}
  }
}


import java.util.*;

class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
    int[] numOfCoins = new int[n + 1];
		Arrays.fill(numOfCoins, Integer.MAX_VALUE);
		numOfCoins[0] = 0;
		int toCompare = 0;
		for (int denom: denoms) {
			for (int amount = 0; amount <=n; amount++) {
				if (denom <= amount) {
					if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = numOfCoins[amount - denom];
					}
					else {
						toCompare = numOfCoins[amount - denom] + 1;
					}
					numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
				}
			}
		}
		return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
  }
}



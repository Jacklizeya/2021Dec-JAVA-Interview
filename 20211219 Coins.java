// There is a trick
// if new coin > sum + 1, return sum + 1;
// else sum = sum + coin;


import java.util.*;

class Program {

  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
		Arrays.sort(coins);
		if (coins.length == 0) {return 1;}
		int sum = 0;
		for (int index = 0; index < coins.length; index++) {
			if (coins[index] > sum + 1) {return sum + 1;} else {sum += coins[index];}
		}
		return sum + 1;
  }
	

}

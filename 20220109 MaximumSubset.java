import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
		
		if (array.length == 0) {return 0;} else if (array.length == 1) {return array[0];}

		int twoBeforeMe = array[0];
		int oneBeforeMe = Math.max(array[0], array[1]);

		for (int i = 2; i < array.length; i++) {
			int current = Math.max(twoBeforeMe + array[i], oneBeforeMe);
			twoBeforeMe = oneBeforeMe;
			oneBeforeMe = current;
		}
		return oneBeforeMe;
  }
}

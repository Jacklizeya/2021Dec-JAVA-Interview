import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int jumperOne = 0;
		int jumperTwo = 0;
		int[] result = {arrayOne[jumperOne], arrayTwo[jumperTwo]};
		int minimumDistance = Math.abs(arrayOne[jumperOne] - arrayTwo[jumperTwo]);
		while (jumperOne < arrayOne.length && jumperTwo < arrayTwo.length) {
			if (Math.abs(arrayOne[jumperOne] - arrayTwo[jumperTwo]) < minimumDistance) {
				minimumDistance = Math.abs(arrayOne[jumperOne] - arrayTwo[jumperTwo]);
				result[0] = arrayOne[jumperOne];
				result[1] = arrayTwo[jumperTwo];
			}
			
			if (arrayOne[jumperOne] == arrayTwo[jumperTwo]) {return result;}
		  else if (arrayOne[jumperOne] < arrayTwo[jumperTwo]) {jumperOne++;}
			else {jumperTwo++;}
		}
																	 
    return result;
  }
}

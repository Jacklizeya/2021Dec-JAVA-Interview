import java.util.*;

class Program {
  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
    int[] count = new int[array.length];
		Arrays.fill(count, 0);
		int location = 0;
		
		for (int i = 0; i < array.length; i++) {
			int step = array[location];
			System.out.println(step);
			location = location + step;
			location = location % array.length;
			if (location < 0) {location += array.length;}
			System.out.println(location);
			count[location]++;
		}
		
		System.out.println(Arrays.toString(count));
		
		if (location != 0) {return false;}
		for (int i =0; i < array.length; i++) {if (count[i] != 1) {return false;}}
		return true;
  }
}

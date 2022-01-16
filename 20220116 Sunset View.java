import java.util.*;

class Program {

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer> ();
		int max = -1;
		if (direction.equals("WEST")) {
			for (int i = 0; i < buildings.length; i++) {
				if (buildings[i] > max) {result.add(i); max = buildings[i];}
			}
		} else {
			for (int i = buildings.length - 1; i >=0; i--) {
				if (buildings[i] > max) {result.add(0, i); max = buildings[i];}
			}
		}
		
    return result;
  }
}

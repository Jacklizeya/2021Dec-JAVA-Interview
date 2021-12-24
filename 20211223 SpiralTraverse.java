import java.util.*;

class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		int maxRow = array.length - 1;
		int maxCol = array[0].length - 1;
		int maxLayer = Math.min(Math.floorDiv(maxRow, 2), Math.floorDiv(maxCol, 2));
    System.out.println(maxLayer);
		for (int layer = 0; layer <= maxLayer; layer++) {
			for (int col = layer; col <= maxCol - layer; col++) {result.add(array[layer][col]);}
			for (int row = layer + 1; row < maxRow - layer; row++) {result.add(array[row][maxCol - layer]);}
			for (int col = maxCol - layer; col >= layer; col--) {if (maxRow - layer > layer) {result.add(array[maxRow - layer][col]);}}
			for (int row = maxRow - layer - 1; row >= layer + 1; row--) {if (layer < maxCol - layer) {result.add(array[row][layer]);}}
		}
    return result;
  }
}

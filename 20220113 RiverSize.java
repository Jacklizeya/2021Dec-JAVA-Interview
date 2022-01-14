import java.util.*;

class Program {
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
    ArrayList<Integer> islandsAreas = new ArrayList<Integer>();
		String[][] tracking = new String[maxRow][maxCol];
		
		for (int row = 0; row < maxRow; row++)
			for (int col = 0; col < maxCol; col++) {
				if (tracking[row][col] != "visited") {
					tracking[row][col] = "visited";
					if (matrix[row][col] == 1) {
						int islandArea = breathFirstExpandAndCount(row, col, tracking, matrix, maxRow, maxCol);
						islandsAreas.add(islandArea);
					}
				}
			}
		
		return islandsAreas;
		}
	
	public static int breathFirstExpandAndCount(int row, int col, String[][] tracking, int[][] matrix, int maxRow, int maxCol) {
		ArrayList<int[]> queue = new ArrayList<int[]> ();
		queue.add(new int[] {row, col});
		int islandArea = 1;
		while (queue.size() > 0) {
			int[] currentLocation = queue.remove(0);
			int currentRow = currentLocation[0];
			int currentCol = currentLocation[1];
			// up
			if (currentRow - 1 >= 0 && tracking[currentRow - 1][currentCol] != "visited") { tracking[currentRow -1][currentCol] = "visited"; if(matrix[currentRow -1][currentCol] == 1) {queue.add(new int[] {currentRow -1, currentCol}); islandArea++;}}
			if (currentRow + 1 < maxRow && tracking[currentRow + 1][currentCol] != "visited") { tracking[currentRow + 1][currentCol] = "visited"; if(matrix[currentRow + 1][currentCol] == 1) {queue.add(new int[] {currentRow + 1, currentCol});islandArea++;}}
			if (currentCol - 1 >= 0 && tracking[currentRow][currentCol - 1] != "visited") { tracking[currentRow][currentCol - 1] = "visited"; if(matrix[currentRow][currentCol - 1] == 1) {queue.add(new int[] {currentRow, currentCol - 1});islandArea++;}}
			if (currentCol + 1 < maxCol && tracking[currentRow][currentCol + 1] != "visited") { tracking[currentRow][currentCol + 1] = "visited"; if(matrix[currentRow][currentCol + 1] == 1) {queue.add(new int[] {currentRow, currentCol + 1});islandArea++;}}
		}
		return islandArea;
	}
	
	
  }


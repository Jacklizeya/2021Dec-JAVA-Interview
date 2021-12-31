import java.util.*;

class Program {

  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
		int maxRow = matrix.length - 1;
		int maxCol = matrix[0].length - 1;
		String[][] tracking = new String[maxRow + 1][maxCol + 1];
		// top line
		for (int col = 0; col <= maxCol; col++) {
			expandFromPointBFS(0, col, matrix, tracking);
		}
		// bottom line
		for (int col = 0; col <= maxCol; col++) {
			expandFromPointBFS(maxRow, col, matrix, tracking);
		}
		// left
		for (int row = 0; row <= maxRow; row++) {
			expandFromPointBFS(row, 0, matrix, tracking);
		}
		// right
		for (int row = 0; row <= maxRow; row++) {
			expandFromPointBFS(row, maxCol, matrix, tracking);
		}
		
		for (int row = 0; row <= maxRow; row++) {
			for (int col =0; col <= maxCol; col++) {
				if (tracking[row][col] != "reachableFromEdge") {matrix[row][col] = 0;}
			}
		}
		
    return matrix;
  }
	// expand BFS
	public void expandFromPointBFS(int row, int col, int[][] matrix, String[][] tracking) {
		int maxRow = matrix.length - 1;
		int maxCol = matrix[0].length - 1;
		if (tracking[row][col] != "reachableFromEdge") {
			tracking[row][col] = "reachableFromEdge";
			if (matrix[row][col] == 1) {
				Queue<int[]> queue= new LinkedList<int[]> ();
				queue.add(new int[] {row, col});
				while (!queue.isEmpty()) {
					int[] currentPosition = queue.poll();
					row = currentPosition[0];
					col = currentPosition[1];
					if (row - 1 >=0 && tracking[row-1][col] != "reachableFromEdge") {
						tracking[row-1][col] = "reachableFromEdge";
						if (matrix[row-1][col] == 1) {queue.add(new int[] {row-1, col});}
					}
					if (row + 1 <= maxRow && tracking[row+1][col] != "reachableFromEdge") {
						tracking[row+1][col] = "reachableFromEdge";
						if (matrix[row+1][col] == 1) {queue.add(new int[] {row+1, col});}
					}
					if (col - 1 >=0 && tracking[row][col - 1] != "reachableFromEdge") {
						tracking[row][col - 1] = "reachableFromEdge";
						if (matrix[row][col - 1] == 1) {queue.add(new int[] {row, col - 1});}
					}
					if (col + 1 <= maxCol && tracking[row][col + 1] != "reachableFromEdge") {
						tracking[row][col+1] = "reachableFromEdge";
						if (matrix[row][col + 1] == 1) {queue.add(new int[] {row, col +1});}
					}
				}
			}
		}
	}
}

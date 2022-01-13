import java.util.*;

class Program {

  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.
    return pathToEnd(0, 0, width, height);
  }
	
	public int pathToEnd(int row, int col, int width, int height) {
		if (row == width - 1 && col == height - 1) {return 1;}
		int result = 0;
		if (col + 1 < height) {result += pathToEnd(row, col + 1, width, height);}
		if (row + 1 < width) {result += pathToEnd(row + 1, col, width, height);}
		return result;
	}
}

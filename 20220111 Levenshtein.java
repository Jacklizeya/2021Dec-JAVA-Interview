import java.util.*;

class Program {
  public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
    int[][] result = new int[str1.length() + 1][str2.length() + 1];
		for (int row = 0; row <= str1.length(); row++) {
			for (int col = 0; col <= str2.length(); col++) {
				
				if (row == 0) {result[row][col] = col;}
				else {
					if (col == 0) {result[row][col] = row;}
					else {
						if (str1.charAt(row - 1) == str2.charAt(col - 1)) {result[row][col] = result[row - 1][col - 1];}
						else {result[row][col] = Math.min(Math.min(result[row - 1][col - 1], result[row - 1][col]), result[row][col - 1]) + 1;}
					     }
						}
				
					}
				}
		   return result[str1.length()][str2.length()];
			}
}

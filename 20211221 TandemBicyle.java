import java.util.*;

class Program {

  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    // Write your code here.
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		
    if (fastest == true) {
			reverseArrayInPlace(blueShirtSpeeds);
		} 
		
		return maxSum(redShirtSpeeds, blueShirtSpeeds);
		
  }
	
	public void reverseArrayInPlace(int[] array) {
		int left = 0; 
		int right = array.length -1;
		while (left < right) {
			int temporary = array[left];
			array[left] = array[right];
			array[right] = temporary;
			left++;
			right--;
		}
	}
	
	
	public int maxSum(int[] array1, int[] array2) {
		int sum = 0;
		for (int i= 0; i < array1.length; i++) {
			sum += Math.max(array1[i], array2[i]);
		}
		return sum;
	}
	
}

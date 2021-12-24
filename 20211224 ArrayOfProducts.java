import java.util.*;

class Program {
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
		int[] leftSideProduct = new int[array.length];
		leftSideProduct[0] = 1;
		int leftProduct = 1;
		for (int i = 1; i < array.length; i++) {
			leftProduct = leftProduct * array[i - 1];
			leftSideProduct[i] = leftProduct;
		}
		
		System.out.println(Arrays.toString(leftSideProduct));
		
		int[] rightSideProduct = new int[array.length];
		rightSideProduct[array.length - 1] = 1;
		int rightProduct = 1;
		for (int i = array.length - 2; i >= 0; i--) {
			rightProduct = rightProduct * array[i + 1];
			rightSideProduct[i] = rightProduct;
		}
		
		System.out.println(Arrays.toString(rightSideProduct));
		
		
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = leftSideProduct[i] * rightSideProduct[i];
		}
		
		return result;
		
  }
}

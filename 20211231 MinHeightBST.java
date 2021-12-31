import java.util.*;

class Program {
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
		int left = 0;
		int right = array.size() - 1;
		int middle = Math.floorDiv(left + right, 2); 
		BST root = new BST(array.get(middle));
		addArrayMiddleToNode(root, array, left, middle - 1);
		addArrayMiddleToNode(root, array, middle + 1, right);
    return root;
  }
	
	public static void addArrayMiddleToNode(BST root, List<Integer> array, int left, int right) {
		if (left <= right) {
		int middle = Math.floorDiv(left + right, 2); 
		root.insert(array.get(middle));
		addArrayMiddleToNode(root, array, left, middle - 1);
		addArrayMiddleToNode(root, array, middle + 1, right);
		} else {return;}
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}

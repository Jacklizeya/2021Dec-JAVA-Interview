import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		return DFS(tree, target, tree.value);
  }
	
	public static int DFS(BST tree, int target, int closestNumber) {
		// The Logic: if the middle is better, use the middle
		// If it has children, try the children too
		// Recursive Call stack use log(n) space
		// pass the closest number from last level into NEXT level
		if (Math.abs( tree.value - target) < Math.abs(closestNumber - target)) {closestNumber = tree.value;}
		if (target < tree.value) {
			if (tree.left != null) {closestNumber = DFS(tree.left, target, closestNumber);}
		} else {
			if (tree.right != null) {closestNumber = DFS(tree.right, target, closestNumber);}
		}
		return closestNumber;
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}


import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
    return iterativeBST(tree, target, tree.value);
  }
	
	public static int iterativeBST(BST tree, int target, int closest) {
		
		BST currentNode = tree;
		while (currentNode != null) {
			if (Math.abs(currentNode.value - target) < Math.abs(closest - target)) {
				closest = currentNode.value;
			}
			if (target < currentNode.value && currentNode.left != null) {
				currentNode = currentNode.left;
			} else if (target > currentNode.value && currentNode.right != null) {
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return closest;
	}
	

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}

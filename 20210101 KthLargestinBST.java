import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
		ArrayList<Integer> allNodesInArray = new ArrayList<Integer>();
		inOrderTraverse(tree, allNodesInArray);
		return allNodesInArray.get(allNodesInArray.size() - k );
  }
	
	public void inOrderTraverse(BST tree, ArrayList<Integer> allNodes) {
		if (tree == null) {return;}
		inOrderTraverse(tree.left, allNodes);
		allNodes.add(tree.value);
		inOrderTraverse(tree.right, allNodes);
		
	}
}

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
	
	static class TreeInfo{
		public boolean isBalanced;
		public int height;
		
		public TreeInfo (boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    return grabTreeInfo(tree).isBalanced;
  }
	
	public TreeInfo grabTreeInfo(BinaryTree tree) {
		if (tree == null) {return new TreeInfo(true, -1);}
		
		TreeInfo leftTreeInfo = grabTreeInfo(tree.left);
		TreeInfo rightTreeInfo = grabTreeInfo(tree.right);
		
		boolean parentTreeBalancedOrNot = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;
		int parentTreeHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
		
		return new TreeInfo(parentTreeBalancedOrNot, parentTreeHeight);
	}
	
}

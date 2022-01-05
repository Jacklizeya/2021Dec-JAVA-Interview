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

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
    return getTreeInfo(tree).diameter;
  }
	
	public TreeInfo getTreeInfo(BinaryTree tree) {
		if (tree == null) {return new TreeInfo(0, 0);}
		// This is a very special recursive design. Get the left and right then build it up
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);
		// The logic
		int diameterPassingNode = leftTreeInfo.height + rightTreeInfo.height;
		int diameterNotPassingNode = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
		int finalDiameter = Math.max(diameterPassingNode, diameterNotPassingNode);
		int finalHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
		
		return new TreeInfo(finalDiameter, finalHeight);
	}
	
	public class TreeInfo {
		int diameter;
		int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}
}

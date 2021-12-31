// Brute force，Traverse everything

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		ArrayList<BinaryTree> sequence = new ArrayList<BinaryTree> ();
		inOrderTraverse(tree, sequence);
		for (int i = 0; i < sequence.size(); i++) {
			if (sequence.get(i) == node) {
				if (i < sequence.size() - 1) {return sequence.get(i + 1);}
			}
		}
		return null;
  }
	
	public void inOrderTraverse(BinaryTree tree, ArrayList<BinaryTree> sequence) {
		if (tree == null) {return;}
		inOrderTraverse(tree.left, sequence);
		sequence.add(tree);
		inOrderTraverse(tree.right, sequence);
	}
}


// Observe the trend, the first right turn

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		BinaryTree nodePointer = node;
		if (node.right != null) {
			nodePointer = node.right;
			while (nodePointer.left != null) {
				nodePointer = nodePointer.left;
			}
			return nodePointer;
		} else {
			while (nodePointer.parent != null) {
				if (nodePointer == nodePointer.parent.left) {return nodePointer.parent;}
				nodePointer = nodePointer.parent;
			}
		}
    return null;
  }
}

// Level-Iteration

import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
		ArrayList<BinaryTree> queue = new ArrayList<BinaryTree> ();
		queue.add(root);
		int level = 0;
		int levelSum = 0;
		while (queue.size() > 0) {
			int levelSize = queue.size();
			levelSum += level * levelSize;
			for (int i =0; i < levelSize; i++) {
				BinaryTree currentNode = queue.remove(0);
				if (currentNode.left != null) {queue.add(currentNode.left);}
				if (currentNode.right != null) {queue.add(currentNode.right);}
			}
			level++;
		}
		return levelSum;
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}


// Recursion

import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    return nodeDepthHelper(root, 0);
  }
	
	public static int nodeDepthHelper(BinaryTree root, int depth) {
		if (root == null) {return 0;}
		return depth + nodeDepthHelper(root.left, depth + 1) + nodeDepthHelper(root.right, depth + 1);
	}

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}


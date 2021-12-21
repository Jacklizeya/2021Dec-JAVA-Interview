import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		DFS(root, path, result);
    return result;
  }
	
	public static void DFS(BinaryTree root, ArrayList<Integer> path, ArrayList<Integer> result) {
		path.add(root.value);
		if (root.left == null && root.right == null) {result.add(Sum(path));}
		else if (root.left != null && root.right == null) {DFS(root.left, path, result);}
		else if (root.left == null && root.right != null) {DFS(root.right, path, result);}
		else {DFS(root.left, path, result); DFS(root.right, path, result);}
		path.remove(path.size() - 1);
	}
	
	public static int Sum(ArrayList<Integer> path) {
		int sum = 0;
		for (int number : path) {
			sum += number;
		}	
		return sum;
	}
}

// A simplified version
// Add first
// Then continue
// no need to do anything for value


import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		DFS(root, 0, result);
    return result;
  }
	
	public static void DFS(BinaryTree root, int currentSum, ArrayList<Integer> result) {
		currentSum += root.value;
		if (root.left == null && root.right == null) {result.add(currentSum);}
		else if (root.left != null && root.right == null) {DFS(root.left, currentSum, result);}
		else if (root.left == null && root.right != null) {DFS(root.right, currentSum, result);}
		else {DFS(root.left, currentSum, result); DFS(root.right, currentSum, result);}
	}
}


// Added Dec 21, A more elegant way to do DFS

import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		DFS(root, path, result);
    return result;
  }
	
	public static void DFS(BinaryTree root, ArrayList<Integer> path, ArrayList<Integer> result) {
		if (root == null) {return;}
		// treat left node and right node as unknow
		path.add(root.value);
		if (root.left == null && root.right == null) {result.add(Sum(path));}
		DFS(root.left, path, result); 
		DFS(root.right, path, result);
		path.remove(path.size() - 1);
	}
	
	public static int Sum(ArrayList<Integer> path) {
		int sum = 0;
		for (int number : path) {
			sum += number;
		}	
		return sum;
	}
}




import java.util.*;

class Program {
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return check(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
	
	public static boolean check(BST node, int min, int max) {
		// if it is null, then stop
		if (node == null) {return true;}
		// if it is not null, check itself first, then check its kid
		if (node.value < min || node.value >= max) {return false;}
		return check(node.left, min, node.value) && check (node.right,node.value, max);
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

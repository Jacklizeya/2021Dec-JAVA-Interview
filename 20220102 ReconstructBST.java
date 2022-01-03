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

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    // Write your code here.
		BST rootNode = new BST(preOrderTraversalValues.get(0));
    addChildrenInTheRange(rootNode, 1, preOrderTraversalValues.size() - 1, preOrderTraversalValues);
		return rootNode;
  }
	
	public void addChildrenInTheRange(BST Node, int leftRange, int rightRange, ArrayList<Integer> preOrderTraversalValues) {
		if (leftRange > rightRange) {return;}
		
		int firstLargerThanNodeValue = leftRange;
		while (firstLargerThanNodeValue <= rightRange) {
			if(preOrderTraversalValues.get(firstLargerThanNodeValue) >= Node.value) {break;}
			firstLargerThanNodeValue++;
		}
		if (firstLargerThanNodeValue > rightRange) {
			// everything is smaller
			BST leftNode = new BST(preOrderTraversalValues.get(leftRange));
			Node.left = leftNode;
			addChildrenInTheRange(leftNode, leftRange + 1, rightRange, preOrderTraversalValues);
		} 
		else if (firstLargerThanNodeValue == leftRange) {
			BST rightNode = new BST(preOrderTraversalValues.get(firstLargerThanNodeValue));
			Node.right = rightNode;
			addChildrenInTheRange(rightNode, firstLargerThanNodeValue + 1, rightRange, preOrderTraversalValues);
		}
		else {
			BST rightNode = new BST(preOrderTraversalValues.get(firstLargerThanNodeValue));
			Node.right = rightNode;
			addChildrenInTheRange(rightNode, firstLargerThanNodeValue + 1, rightRange, preOrderTraversalValues);
			BST leftNode = new BST(preOrderTraversalValues.get(leftRange));
			Node.left = leftNode;
			addChildrenInTheRange(leftNode, leftRange + 1, firstLargerThanNodeValue - 1, preOrderTraversalValues);
			}
	}
}

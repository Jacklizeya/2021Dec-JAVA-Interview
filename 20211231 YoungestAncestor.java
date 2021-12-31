import java.util.*;

class Program {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.
		ArrayList<AncestralTree> pathOne = new ArrayList<AncestralTree> ();
		ArrayList<AncestralTree> pathTwo = new ArrayList<AncestralTree> ();
		AncestralTree currentOne = descendantOne;
		while (currentOne != null) {
			pathOne.add(currentOne);
			currentOne = currentOne.ancestor;
		}
		AncestralTree currentTwo = descendantTwo;
		while (currentTwo != null) {
			pathTwo.add(currentTwo);
			currentTwo = currentTwo.ancestor;
		}
		
		int i = pathOne.size() - 1;
		int j = pathTwo.size() - 1;
		while (i >= 0 && j >= 0) {
			if (pathOne.get(i) != pathTwo.get(j)) {break;} else {i--; j--;}
		}
		
    return pathOne.get(i + 1); // Replace this line
  }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}

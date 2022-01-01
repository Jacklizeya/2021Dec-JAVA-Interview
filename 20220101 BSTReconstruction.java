import java.util.*;

class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
			if (value >= this.value) {
				if (this.right == null) {
					this.right = new BST(value);
				} else {
					this.right.insert(value);
				}
			} else {
				if (this.left == null) {
					this.left = new BST(value);
				} else {
					this.left.insert(value);
				}
			}
      return this;
    }

    public boolean contains(int value) {
      // Write your code here.
			if (this == null) {return false;}
			if (value > this.value) {
				if (this.right == null) {return false;} else
				{return this.right.contains(value);}
			} else if (value < this.value) {
				if (this.left == null) {return false;} else
				{return this.left.contains(value);}
			}
			else {
				return true;
			}
    }
		
		public BST remove(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
			if (this.left != null || this.right != null) {
				this.removeWithParentTracking(value, null);
			}
      return this;
    }

    public void removeWithParentTracking (int value, BST parent) {
      // Write your code here.
      // Do not edit the return statement of this method.
			if (value < this.value) {
				this.left.removeWithParentTracking(value, this);
			} else if (this.value < value) {
				this.right.removeWithParentTracking(value, this);
			} else {
				this.reOrganizeWithItsParent(parent);
			}
		}
		
		public void reOrganizeWithItsParent(BST parentNode) {
			if (this.right == null) {
					if (this.left != null) {
						// parentNode -> this -> this.left, upgrade this.left
						if (parentNode != null && parentNode.left == this) {parentNode.left = this.left;}
						else {parentNode.right = this.left;}
					} else {
						// this doesnot have left and right, this = null
						if (parentNode != null && parentNode.left == this) {parentNode.left = null;}
						else {parentNode.right = null;}
					}
				}
			// The follwing is based on this has right branch
			else {
				// if this.right has no left branch, this.right will be upgraded to this's level
				if (this.right.left == null) {
					this.right.left = this.left;
					if (parentNode != null && parentNode.left == this) {
						parentNode.left = this.right;
					}
					else {parentNode.right = this.right;}
				} else {
					// this has left branch 
					BST parent = this.right;
					BST child = this.right.left;
					while (child.left != null) {
						parent = parent.left;
						child = child.left;
					}
					// reach the end to the left side
					this.value = child.value;
					if (child.right == null) {
						// erase parent's child by using parent.left = null
						parent.left = null;
					} else {
						// erase in another way by replacing it
						parent.left = child.right;
					}
				}
			}	
    }
		
  }
}

import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		LinkedList fastNode = head;
		int count = 1;
		
		LinkedList slowNode = head;
		LinkedList preSlowNode = head;
		
		while (fastNode.next != null) {
			fastNode = fastNode.next;
			count++;
			
			if (count == k) {
				if (fastNode.next == null) {
					head.value = head.next.value; 
					head.next = head.next.next;
					return;}
				slowNode = head;
			} else if (count > k) {
				
					preSlowNode = slowNode;
				  slowNode = slowNode.next;

			}
		}
			preSlowNode.next = slowNode.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;
    public LinkedList(int value) {
      this.value = value;
    }
  }
}

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    // Write your code here.
		LinkedList nodeBeforeHead = new LinkedList(0);
		LinkedList currentNodeInSum = nodeBeforeHead;
		int carryToNextNode = 0;
		
		LinkedList nodePointerForLinkedListOne = linkedListOne;
		LinkedList nodePointerForLinkedListTwo = linkedListTwo;

		
		
		
		
		while (nodePointerForLinkedListOne != null || nodePointerForLinkedListTwo != null || carryToNextNode != 0) {
			int valueOne = (nodePointerForLinkedListOne == null)? 0 : nodePointerForLinkedListOne.value;
			int valueTwo = (nodePointerForLinkedListTwo == null)? 0 : nodePointerForLinkedListTwo.value;
			int sum = valueOne + valueTwo + carryToNextNode;
			
			int valueForCurrentNode = sum % 10;
			LinkedList newNode = new LinkedList(valueForCurrentNode);
			currentNodeInSum.next = newNode;
			currentNodeInSum = newNode;
			
			carryToNextNode = (sum - valueForCurrentNode)/ 10;
			nodePointerForLinkedListOne = (nodePointerForLinkedListOne != null) ? nodePointerForLinkedListOne.next : null;
			nodePointerForLinkedListTwo = (nodePointerForLinkedListTwo != null) ? nodePointerForLinkedListTwo.next : null;
		}
		
		
    return nodeBeforeHead.next;
  }
}

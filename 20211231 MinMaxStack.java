import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
		List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>> ();
		List<Integer> stack = new ArrayList<Integer> ();		
		
    public int peek() {
      // Write your code here.
      if (stack.size() >= 1) {return stack.get(stack.size() - 1);} else {return -1;}
    }

    public int pop() {
      // Write your code here.
			if (stack.size() >= 1) {
				int result = stack.remove(stack.size() - 1);
				minMaxStack.remove(minMaxStack.size() - 1);
				return result;} 
			else {return -1;}
    }

    public void push(Integer number) {
      // Write your code here.		
			stack.add(number);
			Map<String, Integer> newMinMaxElement = new HashMap<String, Integer> ();
			
			if (minMaxStack.size() >= 1) {
				// case 1, already have information
				int mostRecentMin = this.getMin();
				if (number < mostRecentMin) {
					newMinMaxElement.put("min", number);
				} else {
					newMinMaxElement.put("min", mostRecentMin);
				}
				
				int mostRecentMax = this.getMax();
				if (number > mostRecentMax) {
					newMinMaxElement.put("max", number);
				} else {
					newMinMaxElement.put("max", mostRecentMax);
				}
				
			} else {
				// case 2, no information brand new
				newMinMaxElement.put("min", number);
				newMinMaxElement.put("max", number);
			}
			minMaxStack.add(newMinMaxElement);
    }

    public int getMin() {
      // Write your code here.
      if (minMaxStack.size() >= 1) {
				return minMaxStack.get(minMaxStack.size() - 1).get("min");
			} else {return -1;}
    }

    public int getMax() {
      // Write your code here.
      if (minMaxStack.size() >= 1) {
				return minMaxStack.get(minMaxStack.size() - 1).get("max");
			} else {return -1;}
    }
  }
}

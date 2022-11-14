import java.util.*;

class Program {
  public static String longestPalindromicSubstring(String str) {
    // Write your code here.
    int maxLength = 0;
    int extremeLeft = Integer.MIN_VALUE;
    int extremeRight = Integer.MAX_VALUE;
    for (int i = 0; i <= (str.length()) / 0.5 - 2; i++) {
      double index = i * 0.5;
      int left;
      int right;
      if ((index) % 1 == 0) {left = (int)(index); right = (int) (index);} else {left =(int)(index- 0.5); right = (int)(index + 0.5);}

      while(left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
        left--;
        right++;
      }
      // It will jump to one extra step out.
      if (right - left + 1 - 2 > maxLength) {maxLength = right - left + 1 - 2; extremeLeft = left + 1; extremeRight = right - 1;}
    }

    return str.substring(extremeLeft, extremeRight + 1);
  }
}

// https://leetcode.com/problems/valid-palindrome-ii/
import java.util.*;
public class ValidPalindrome2 {
    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
          if (s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
          } else {
            return false;
          }
        }
        return true;
      }
    
      public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
    
        while (i <= j) {
          if (s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
          } else {
            return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
          }
        }
        return true;
      }
}

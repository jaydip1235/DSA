// https://leetcode.com/problems/word-pattern/
import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashSet < String > used = new HashSet < > ();
       HashMap < Character, String > map = new HashMap < > ();
       String[] arr = str.split(" ");
       if(arr.length!=pattern.length())return false;

       for (int i = 0; i < pattern.length(); i++) {
           char ch = pattern.charAt(i);
           String word = arr[i];

           if (map.containsKey(ch) == false) {
               if (used.contains(word) == true) {
                   return false;
               }
               map.put(ch, word);
               used.add(word);
           } 
           else {
               String pmword = map.get(ch); //previously mapped word

               if (pmword.equals(word) == false) {
                   return false;
               }
           }
       }

       return true;
   }
}

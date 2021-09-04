// https://leetcode.com/problems/first-unique-character-in-a-string/
import java.util.*;
public class FirstNonRep {
    public int firstUniqChar(String s) {
        int charr[] = new int[26];
        for(int i=0;i<s.length();i++){
            charr[s.charAt(i)-'a']++;
        }
          for(int i=0;i<s.length();i++){
            if(charr[s.charAt(i)-'a']==1)return i;
        }
        return -1;
    }
}

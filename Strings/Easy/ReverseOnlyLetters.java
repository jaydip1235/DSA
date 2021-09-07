// https://leetcode.com/problems/reverse-only-letters/
import java.util.*;
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder();
        int j=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                while(!Character.isLetter(s.charAt(j))){
                    j--;
                }
                ans.append(s.charAt(j));
                j--;
            }
            else{
                 ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}

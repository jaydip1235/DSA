// https://leetcode.com/problems/remove-palindromic-subsequences/
import java.util.* ;
public class RemovePalSub {
    public int removePalindromeSub(String s) {
        if(s.equals(""))return 0;
        if(isPalindrome(s))return 1;
        return 2;
    }
    public boolean isPalindrome(String s){
        int lo=0,hi=s.length()-1;
        while(lo<=hi){
            if(s.charAt(lo)!=s.charAt(hi))return false;
            lo++;
            hi--;
        }
        return true;
    }
}

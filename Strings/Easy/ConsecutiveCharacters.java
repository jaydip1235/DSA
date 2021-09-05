// https://leetcode.com/problems/consecutive-characters/
import java.util.*;
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if(s=="" || s==null)return 0;
        int maxlen = 1;
        int i=0,j=0;
        int len =0;
        while(j<s.length()){
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if(chi==chj){
                j++;
            }
            else{
                len=j-i;
                i=j;
                if(len>maxlen)maxlen = len;
                len=0;
            }
        }
        if(j==s.length()){
            maxlen = Math.max(j-i, maxlen);
        }
        return maxlen;
    }
}

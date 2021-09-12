//https://leetcode.com/problems/di-string-match/
import java.util.*;
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int lo = 0;
        int hi = s.length();
        int ans[] = new int[hi+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I')ans[i]=lo++;
            else ans[i] = hi--;
        }
        ans[s.length()]=lo;
        return ans;
    }

}

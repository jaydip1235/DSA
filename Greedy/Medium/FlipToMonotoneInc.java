// https://leetcode.com/problems/flip-string-to-monotone-increasing/
import java.util.*;
public class FlipToMonotoneInc{
public int minFlipsMonoIncr(String s) {
    int n = s.length(), res = n;
    int[] oneBefore = new int[n], zeroAfter = new int[n];
        
    oneBefore[0] = s.charAt(0) == '1' ? 1 : 0;
    zeroAfter[n - 1] = s.charAt(n - 1) == '1' ? 0 : 1;
        
    for(int i = 1; i < n; i++)
        oneBefore[i] = oneBefore[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        
    for(int i = n - 2; i >= 0; i--)
        zeroAfter[i] = zeroAfter[i + 1] + (s.charAt(i) == '1' ? 0 : 1);
        
    for(int i = 0; i < n; i++)
        res = Math.min(res, oneBefore[i] + zeroAfter[i]);

    return res - 1;
    }
}
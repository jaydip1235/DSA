// https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1/
import java.util.*;
public class DistinctSubsequqnces {
    int distinctSubsequences(String s) {
        int mod = 1000000007;
        int dp[] = new int[s.length() + 1];
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;
            if (hm.containsKey(s.charAt(i - 1))) {
                int j = hm.get(s.charAt(i - 1));
                dp[i] = (dp[i] - dp[j - 1] + mod) % mod;
            }
            hm.put(s.charAt(i - 1), i);
        }

        return dp[s.length()] % mod;

    }
}

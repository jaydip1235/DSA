// https://leetcode.com/problems/count-different-palindromic-subsequences/
import java.util.*;
public class DistinctPalSubseq {
    public int countPalindromicSubsequences(String s) {
        int dp[][] = new int[s.length()][s.length()];
        int mod = 1000000007;
        int prev[] = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                prev[i] = map.get(ch);
            } else {
                prev[i] = -1;
            }
            map.put(ch, i);
        }
        int next[] = new int[s.length()];
        map.clear();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                next[i] = map.get(ch);
            } else {
                next[i] = s.length();
            }
            map.put(ch, i);
        }

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    char ith = s.charAt(i);
                    char jth = s.charAt(j);
                    if (ith != jth) {
                        dp[i][j] = ((dp[i + 1][j] + dp[i][j - 1]) % mod - dp[i + 1][j - 1] + mod) % mod;
                    } else {
                        int n = next[i];
                        int p = prev[j];
                        if (n > p) {
                            dp[i][j] = (2 * dp[i + 1][j - 1] % mod + 2) % mod;
                        } else if (n == p) {
                            dp[i][j] = (2 * dp[i + 1][j - 1] % mod + 1) % mod;
                        } else {
                            dp[i][j] = (2 * dp[i + 1][j - 1] % mod - dp[n + 1][p - 1] + mod) % mod;
                        }
                    }
                }
            }
        }

        return dp[0][s.length() - 1] % mod;
    }
}

// https://leetcode.com/problems/wildcard-matching/
public class WildCardMatching {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = true;
                else if (i == dp.length - 1)
                    dp[i][j] = false;
                else if (j == dp[0].length - 1)
                    dp[i][j] = p.charAt(i) == '*' ? dp[i + 1][j] : false;
                else {
                    char ch = p.charAt(i);
                    if (ch == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (ch == '*') {
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else {
                        if (ch == s.charAt(j) && dp[i + 1][j + 1] == true)
                            dp[i][j] = true;
                        else
                            dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }
}

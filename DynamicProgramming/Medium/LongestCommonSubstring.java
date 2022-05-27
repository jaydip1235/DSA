// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/
public class LongestCommonSubstring {
    int longestCommonSubstr(String s1, String s2, int n, int m) {
        int ans = 0;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    char c1 = s1.charAt(i - 1);
                    char c2 = s2.charAt(j - 1);
                    if (c1 != c2) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}

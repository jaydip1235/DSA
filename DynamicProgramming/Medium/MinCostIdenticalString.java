// https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1/
public class MinCostIdenticalString {
    public int findMinCost(String s1, String s2, int x, int y) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = y + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = x + dp[i + 1][j];
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(x + dp[i + 1][j], y + dp[i][j + 1]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}

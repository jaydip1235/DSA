// https://leetcode.com/problems/burst-balloons/
public class BurstBaloons {
    public int maxCoins(int[] arr) {

        int dp[][] = new int[arr.length][arr.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                int maxi = 0;
                for (int k = i; k <= j; k++) {
                    int lp = k == i ? 0 : dp[i][k - 1];
                    int rp = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == arr.length - 1 ? 1 : arr[j + 1]);
                    if (maxi < val + lp + rp) {
                        maxi = val + lp + rp;
                    }

                }
                dp[i][j] = maxi;
            }
        }
        return dp[0][arr.length - 1];
    }
}

// https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1/
public class OptimalStrategyGame {
    static long countMaximum(int arr[], int n) {
        int dp[][] = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int v1 = arr[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]);
                    int v2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(v1, v2);
                }
            }
        }
        return (long) dp[0][n - 1];
    }
}

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/optimal-bst-official/ojquestion
public class OptimalBST {
    private static void optimalbst(int[] keys, int[] frequency, int n) {
        int dp[][] = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[j][i] = frequency[i];
                } else if (g == 1) {
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                } else {
                    int sum = 0;
                    int mini = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        sum += frequency[k];
                    }
                    for (int k = i; k <= j; k++) {

                        int lp = k == i ? 0 : dp[i][k - 1];
                        int rp = k == j ? 0 : dp[k + 1][j];
                        int p = lp + rp + sum;
                        if (p < mini)
                            mini = p;
                    }
                    dp[i][j] = mini;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}

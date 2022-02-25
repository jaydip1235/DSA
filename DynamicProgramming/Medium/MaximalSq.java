// https://leetcode.com/problems/maximal-square/
import java.util.*;
public class MaximalSq {
    public int maximalSquare(char[][] arr) {
        int r = arr.length;
        int maxi = -1;
        int c = arr[0].length;
        int dp[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((i == r - 1 || j == c - 1)) {
                    dp[i][j] = arr[i][j] - '0';
                    maxi = Math.max(maxi, dp[i][j]);
                }
            }
        }
        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                if (arr[i][j] - '0' == 1) {
                    int right = dp[i][j + 1];
                    int corner = dp[i + 1][j + 1];
                    int bottom = dp[i + 1][j];
                    dp[i][j] = 1 + (Math.min(right, Math.min(corner, bottom)));
                    maxi = Math.max(maxi, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxi * maxi;
    }
}

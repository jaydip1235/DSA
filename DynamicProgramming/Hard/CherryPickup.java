//https://leetcode.com/problems/cherry-pickup/
public class CherryPickup {

    public static int cp(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
        int c2 = r1 + c1 - r2;
        if (r1 >= arr.length || r2 >= arr.length || c2 >= arr[0].length || c1 >= arr[0].length || arr[r1][c1] == -1
                || arr[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == arr.length - 1 && c1 == arr[0].length - 1) {
            return arr[r1][c1];
        }
        if (dp[r1][c1][r2] != 0) {
            return dp[r1][c1][r2];
        }
        int cherries = 0;
        if (r2 == r1 && c2 == c1) {
            cherries += arr[r1][c1];
        } else {
            cherries += arr[r1][c1] + arr[r2][c2];
        }
        int v1 = cp(r1 + 1, c1, r2 + 1, arr, dp);
        int v2 = cp(r1 + 1, c1, r2, arr, dp);
        int v3 = cp(r1, c1 + 1, r2 + 1, arr, dp);
        int v4 = cp(r1, c1 + 1, r2, arr, dp);

        cherries += Math.max(Math.max(v1, v2), Math.max(v3, v4));
        dp[r1][c1][r2] = cherries;
        return cherries;

    }

    public int cherryPickup(int[][] grid) {
        int dp[][][] = new int[grid.length][grid.length][grid.length];
        int res = cp(0, 0, 0, grid, dp);
        if (res < 0)
            return 0;
        else
            return res;
    }
}

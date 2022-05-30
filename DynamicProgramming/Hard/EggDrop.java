// https://leetcode.com/problems/super-egg-drop/
public class EggDrop {
    int[][] memo;

    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (k == 1)
            return n;
        if (n == 0)
            return 0;
        if (memo[k][n] > 0)
            return memo[k][n];
        int res = n;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int broken = dp(k - 1, mid - 1);
            int not_broken = dp(k, n - mid);
            res = Math.min(res, Math.max(broken, not_broken) + 1);
            if (broken > not_broken) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        memo[k][n] = res;
        return res;
    }
}

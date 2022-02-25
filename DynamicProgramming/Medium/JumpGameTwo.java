// https://leetcode.com/problems/jump-game-ii/
import java.util.*;
public class JumpGameTwo {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for (int i = 0; i < n - 1; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            int steps = nums[i];
            int mini = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < nums.length; j++) {
                if (dp[i + j] != Integer.MAX_VALUE && dp[i + j] < mini) {
                    mini = dp[i + j];
                }
            }
            if (mini != Integer.MAX_VALUE)
                dp[i] = mini + 1;
        }
        return dp[0];

    }
}

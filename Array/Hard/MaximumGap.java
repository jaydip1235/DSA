import java.util.Arrays;

public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int mini = nums[0];
        int maxi = 0;
        for (int num : nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        int interval = (int) Math.ceil((maxi - mini + 0.0) / (nums.length - 1));
        int[] minbuck = new int[nums.length - 1];
        int[] maxbuck = new int[nums.length - 1];
        Arrays.fill(minbuck, Integer.MAX_VALUE);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mini || nums[i] == maxi) {
                continue;
            }
            int index = (nums[i] - mini) / interval;
            minbuck[index] = Math.min(minbuck[index], nums[i]);
            maxbuck[index] = Math.max(maxbuck[index], nums[i]);
        }

        int prev = mini;
        int ans = 0;
        for (int i = 0; i < minbuck.length; i++) {
            if (maxbuck[i] == 0) {
                continue;
            }
            ans = Math.max(ans, minbuck[i] - prev);
            prev = maxbuck[i];
        }
        ans = Math.max(ans, maxi - prev);
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap solution = new MaximumGap();
        int[] nums = {3, 6, 9, 1};
        int result = solution.maximumGap(nums);
        System.out.println("Maximum Gap: " + result);
    }
}

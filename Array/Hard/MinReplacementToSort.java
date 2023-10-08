import java.util.*;

public class MinReplacementToSort  {
    public long minimumReplacement(List<Integer> nums) {
        long ans = 0;
        int n = nums.size();
        int nxt = (int) 1e9 + 7;

        for (int j = n - 1; j >= 0; j--) {
            if (nums.get(j) <= nxt) {
                nxt = nums.get(j);
                continue;
            }

            long parts = (long) Math.ceil(nums.get(j) / (double) nxt);
            ans += parts - 1;
            nxt = (int) (nums.get(j) / parts);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinReplacementToSort solution = new MinReplacementToSort();
        List<Integer> nums = Arrays.asList(3,9,3);
        long result = solution.minimumReplacement(nums);
        System.out.println("Minimum Replacements: " + result);
    }
}

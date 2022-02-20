// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
import java.util.*;
public class NumOfPairsAbsDiffk {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (hm.containsKey(nums[i] + k)) {
                count += hm.get(nums[i] + k);
            }
            if (hm.containsKey(nums[i] - k)) {
                count += hm.get(nums[i] - k);
            }
            int freq = hm.getOrDefault(nums[i], 0) + 1;
            hm.put(nums[i], freq);
        }
        return count;
    }
}

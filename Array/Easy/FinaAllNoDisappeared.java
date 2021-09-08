// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
import java.util.*;
public class FinaAllNoDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int curr = Math.abs(nums[i]);
            nums[curr-1] = -(Math.abs(nums[curr-1]));
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)ans.add(i+1);
        }
        return ans;
    }
}

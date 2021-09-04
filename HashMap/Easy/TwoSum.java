// https://leetcode.com/problems/two-sum/
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(hm.containsKey(diff)){
                int f = i;
                int s = hm.get(diff);
                int arr[] = new int[2];
                arr[0]=f;
                arr[1]=s;
                return arr;
            }
            else{
                hm.put(nums[i],i);
            }
        }
          return new int[2];
      }
}

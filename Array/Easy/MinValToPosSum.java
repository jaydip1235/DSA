// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
import java.util.*;
public class MinValToPosSum {
    public int minStartValue(int[] nums) {
        int pre[] = new int[nums.length];
        pre[0]=nums[0];
        int mini = pre[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1]+nums[i];
            if(pre[i]<mini)mini=pre[i];
        }
        if(mini>0)return 1;
        return (mini*(-1))+1;
        
    }
}

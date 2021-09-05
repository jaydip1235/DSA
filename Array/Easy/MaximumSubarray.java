// https://leetcode.com/problems/maximum-subarray/
import java.util.*;
public class MaximumSubarray {
    public int maxSubArray(int[] arr) {
        int negcount = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)negcount++;
            max = Math.max(max,arr[i]);
            }
        if(negcount==arr.length){
            return max;
        }
        int sum = 0;
        max = arr[0];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum<0)sum=0;
            max = Math.max(max, sum);
        }
        if(max<0)return 0;
        return max;
    }
}

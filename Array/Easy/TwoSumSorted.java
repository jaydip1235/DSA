// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
import  java.util.*;
public class TwoSumSorted {
    public int[] twoSum(int[] arr, int target) {
        int i=0;
        int ans[] = new int[2];
        int j=arr.length-1;
        while(i<j){
            int val = arr[i]+arr[j];
            if(val==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
                
            }
            else if(val>target)j--;
            else if(val<target)i++;
          
        }
          return ans;
    }
}

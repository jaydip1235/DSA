// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
import java.util.*;
public class NumSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int freq[] = new int[101];
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        for(int i=0;i<arr.length;i++){
             int count=0;
            for(int j=0;j<arr[i];j++){
                count += freq[j];  
            }
             ans[i]=count;
        }
        return ans;
    }
}

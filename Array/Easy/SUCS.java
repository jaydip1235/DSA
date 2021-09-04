// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
import java.util.*;
public class SUCS {
    public int findUnsortedSubarray(int[] arr) {
        int brr[] = arr.clone();
        Arrays.sort(brr);
        int s = 0,e=0;
         for(int i=0;i<arr.length;i++){
             if(arr[i]!=brr[i]){s=i;break;}
         }
          for(int i=arr.length-1;i>=0;i--){
             if(arr[i]!=brr[i]){e=i;break;}
         }
         if(s==e)return 0;
         return Math.abs(s-e)+1;
     }
}

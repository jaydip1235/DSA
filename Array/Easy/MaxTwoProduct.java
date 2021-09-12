// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
import java.util.*;
public class MaxTwoProduct {
    public int maxProduct(int[] arr) {
        
        int max1 = Integer.MIN_VALUE;
      int max2 = max1;
      
      int min1 = Integer.MAX_VALUE;
      int min2 = min1;
      
      for(int i=0;i<arr.length;i++){
          int val = arr[i]-1;
           
          // max check
          if(val>=max1){
              max2=max1;
              max1=val;
          }
          else if(val>=max2){
              max2=val;
          }
          // min check
          if(val<=min1){
              min2 = min1;
              min1=val;
          }
          else if(val<=min2){
              min2=val;
          }
      }
      return Math.max(min1*min2, max1*max2);
  }
}

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
import java.util.*;
public class CountSubarrayWithSumDivByK {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap < Integer, Integer > map = new HashMap < > (); //ps % k vs freq
       int ps = 0;
       int count = 0;
       map.put(0, 1);

       for (int i = 0; i < arr.length; i++) {
           ps += arr[i];
           int rem = ps % k;

           if (rem < 0) {
               rem += k;
           }

           if (map.containsKey(rem) == true) {
               int of = map.get(rem);
               count += of ;
               map.put(rem, of +1);
           } else {
               map.put(rem, 1);
           }
       }

       return count;
   }
}

// https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
import java.util.*;
public class ZeroSumSubarrayCount {
    public static long findSubarray(long[] arr ,int n) 
    {
        HashMap < Integer, Integer > map = new HashMap < > (); //ps vs freq
        map.put(0, 1);

        int count = 0;
        int ps = 0;

        for (int i = 0; i < arr.length; i++) {
            ps += arr[i];

            if (map.containsKey(ps) == false) {
                map.put(ps, 1);
            } else {
                int of = map.get(ps);
                count += of ;

                map.put(ps, of +1);
            }
        }

        return count;
    }
}

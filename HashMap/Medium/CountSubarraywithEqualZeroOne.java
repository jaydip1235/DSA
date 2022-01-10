// https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1
import java.util.*;
public class CountSubarraywithEqualZeroOne {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
         //replace all 0's with -1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? -1 : arr[i];
        }

        //count subarrays having sum 0
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        int ps = 0;
        int count = 0;

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

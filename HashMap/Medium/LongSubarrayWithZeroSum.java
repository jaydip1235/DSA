// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1/
import java.util.*;
public class LongSubarrayWithZeroSum {
    int maxLen(int arr[], int n)
    {
        HashMap < Integer, Integer > map = new HashMap < > (); //prefix sum vs it's first occ
        int ps = 0;
        int olen = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            ps += arr[i];

            if (map.containsKey(ps) == false) {
                map.put(ps, i);
            } else {
                int len = i - map.get(ps);

                if (olen < len) {
                    olen = len;
                }
            }
        }
        return olen;
    }
}

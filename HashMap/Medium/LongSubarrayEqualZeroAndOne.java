// https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
import java.util.*;
public class LongSubarrayEqualZeroAndOne {
    int maxLen(int[] arr, int N)
    {
        //replace all 0's with -1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? -1 : arr[i];
        }

        //longest subarray having sum 0
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int ps = 0;
        int olen = 0;

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

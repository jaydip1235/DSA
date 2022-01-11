// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/
import java.util.*;
public class LongSubarrayWithSumEqualK {
    public static int lenOfLongSubarr (int arr[], int N, int k) {
        HashMap < Integer, Integer > map = new HashMap < > (); //ps vs first occ
        map.put(0, -1);
        int ps = 0;
        int olen = 0;

        for (int i = 0; i < arr.length; i++) {
            ps += arr[i];

            if (map.containsKey(ps - k) == true) {
                int len = i - map.get(ps - k);
                if (olen < len) {
                    olen = len;
                }
            }

            if (map.containsKey(ps) == false) {
                map.put(ps, i);
            }
        }

        return olen;
    }
    
}

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion
import java.util.*;
public class LongSubarrayWithEqualZeroOneTwo {
    public static int solution(int[] arr) {
        HashMap < String, Integer > map = new HashMap < > (); // [(c1-c0) @ (c2-c1)] vs first occ
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        int olen = 0;

        map.put("0 0", -1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            } else {
                c2++;
            }

            String key = (c1 - c0) + " " + (c2 - c1);

            if (map.containsKey(key) == false) {
                map.put(key, i);
            } else {
                int len = i - map.get(key);
                if (len > olen) {
                    olen = len;
                }
            }
        }

        return olen;
    }
}

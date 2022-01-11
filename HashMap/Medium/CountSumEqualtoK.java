// https://leetcode.com/problems/subarray-sum-equals-k/
import java.util.*;
public class CountSumEqualtoK {
    public int subarraySum(int[] arr, int k) {
        HashMap < Integer, Integer > map = new HashMap < > (); //ps vs freq
        map.put(0, 1);
        int ps = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            ps += arr[i];

            if (map.containsKey(ps - k) == true) {
                int of = map.get(ps - k);
                count += of ;
            }

            int nf = map.getOrDefault(ps, 0) + 1;
            map.put(ps, nf);
        }

        return count;
    }
}

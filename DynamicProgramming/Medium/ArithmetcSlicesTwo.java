// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
import java.util.*;
public class ArithmetcSlicesTwo {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer>[] map = new HashMap[A.length];
        for (int i = 0; i < A.length; i++)
            map[i] = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;

                int d = (int) diff;
                int ending_in_i = map[i].getOrDefault(d, 0);
                int ending_in_j = map[j].getOrDefault(d, 0);
                res += ending_in_j;
                map[i].put(d, ending_in_i + ending_in_j + 1);
            }
        }

        return res;
    }
}

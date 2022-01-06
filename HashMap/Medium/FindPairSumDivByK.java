// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
import java.util.*;
public class FindPairSumDivByK {
    public boolean canArrange(int[] arr, int k) {
        HashMap < Integer, Integer > map = new HashMap < > ();

        for (int val: arr) {
            int rem=0;
            if(val<0){
                int fac = (Math.abs(val)/k)+1;
                rem = ((k*fac)+val) % k;
            }
            else
            rem = (val) % k;

            int nf = map.getOrDefault(rem, 0) + 1;
            map.put(rem, nf);
        }


        boolean ans = true;

        for (int rem: map.keySet()) {
            int freq = map.get(rem);

            if ((k % 2 == 0 && rem == k / 2) || rem == 0) {
                if (freq % 2 != 0) {
                    ans = false;
                    break;
                }
            } else {
                int f2 = map.getOrDefault(k - rem, -1);

                if (f2 == -1 || freq != f2) {
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
}

// https://leetcode.com/problems/arithmetic-subarrays/
import java.util.*;
public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        int length = l.length;

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                temp.add(nums[j]);
            }
            Collections.sort(temp);
            int diff = 0, pdiff = 0;
            int fl = 0;
            for (int k = 1; k < temp.size(); k++) {
                if (k == 1)
                    diff = temp.get(k) - temp.get(k - 1);
                else {
                    pdiff = temp.get(k) - temp.get(k - 1);
                    if (diff != pdiff) {
                        ans.add(false);
                        fl = 1;
                        break;
                    }
                }
            }
            if (fl == 0)
                ans.add(true);
        }

        return ans;
    }
}

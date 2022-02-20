// https://leetcode.com/problems/xor-operation-in-an-array/
import java.util.*;
public class XorOperation {
    public int xorOperation(int n, int start) {
        int s = start;
        for (int i = 1; i < n; i++) {
            s ^= (start + (2 * i));
        }
        return s;
    }
}

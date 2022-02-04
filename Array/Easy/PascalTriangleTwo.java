// https://leetcode.com/problems/pascals-triangle-ii/
import java.util.*;
public class PascalTriangleTwo{
    public List<Integer> getRow(int r) {
        List<Integer> list = new ArrayList<>();
        long val = 1;
        for (int c = 0; c <= r; c++) {
            list.add((int) val);
            val = val * (r - c) / (c + 1);
        }

        return list;
    }
}
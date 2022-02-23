// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
import java.util.*;
public class NoOfRectangleFormSq {
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0, maxi = Integer.MIN_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            int minval = Math.min(rectangles[i][0], rectangles[i][1]);
            maxi = Math.max(maxi, minval);
        }
        for (int i = 0; i < rectangles.length; i++) {
            if (Math.min(rectangles[i][0], rectangles[i][1]) == maxi)
                ans++;
        }
        return ans;
    }
}

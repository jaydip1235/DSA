/**
* 1011. Capacity To Ship Packages Within D Days [https://leetcode.com/problems/capacity-to-ship-packages-within-d-days]
*/
import java.util.*;

public class Capacity_To_Ship_Packages_Within_D_Days {
  public int shipWithinDays(int[] weights, int days) {
    int min = Arrays.stream(weights).max().getAsInt();
    int max = Arrays.stream(weights).sum();

    while (min < max) {
      int mid = (min + max) / 2, sum = 0, d = 1;

      for (int w : weights) {
        if (sum + w > mid) {
          d++;
          sum = 0;
        }
        sum += w;
      }

      if (d > days)
        min = mid + 1;

      else
        max = mid;
    }

    return min;
  }
}

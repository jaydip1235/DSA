// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1/#
import java.util.*;
public class MaxSumIS {
    public int maxSumIS(int arr[], int n) {
        int dp[] = new int[n];
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Integer max = null;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max == null)
                        max = dp[j];
                    else if (dp[j] > max)
                        max = dp[j];
                }
            }
            if (max == null)
                dp[i] = arr[i];
            else
                dp[i] = arr[i] + max;
            if (dp[i] > maxsum)
                maxsum = dp[i];
        }
        return maxsum;
    }
}

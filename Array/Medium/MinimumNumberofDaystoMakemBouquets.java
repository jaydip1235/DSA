// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int b : bloomDay) {
            max = Math.max(max, b);
            min = Math.min(min, b);
        }
        int n = bloomDay.length;
        
        if (n < m * k) return -1;
        
        while (min < max) {
            int mid = (min + max) / 2;
            int cnt = 0, adj = 0;
            for (int b : bloomDay) {
                if (b > mid) adj = 0;
                else {
                    adj++;
                    if (adj == k) {
                        adj = 0;
                        cnt++;
                    }
                }
                if (cnt >= m) break;
            }
            
            if (cnt < m) min = mid + 1;
            else max = mid;
        }
        return min;
    }
}

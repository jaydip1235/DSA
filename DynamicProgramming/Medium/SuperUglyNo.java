// https://leetcode.com/problems/super-ugly-number/
public class SuperUglyNo {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == (primes[j] * dp[pointers[j]])) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
}

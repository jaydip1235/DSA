// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/rod-cutting-official/ojquestion
public class RodCutting {
    
    public static int solution(int[] prices) {
        int np[] = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            np[i + 1] = prices[i];
        }
        int dp[] = new int[np.length];
        dp[0] = 0;
        dp[1] = np[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = np[i];
            int lp = 1;
            int rp = i - 1;
            while (lp <= rp) {
                if (dp[lp] + dp[rp] > dp[i]) {
                    dp[i] = dp[lp] + dp[rp];
                }
                lp++;
                rp--;
            }
        }

        return dp[dp.length - 1];
    }
}

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
#include<bits/stdc++.h>
class Solution {
public:
    int countOrders(int n) {
        const int MOD = 1e9 + 7;
        vector<long long> dp(501, 0);
        dp[1] = 1;
        dp[2] = 6;
        for (int i = 3; i <= n; i++) {
            int oddNum = 2 * i - 1;
            dp[i] = dp[i-1] * (oddNum * (oddNum + 1) / 2) % MOD;
        }
        return dp[n];
    }
};
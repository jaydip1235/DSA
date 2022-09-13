// https://leetcode.com/problems/filling-bookcase-shelves/
#include<bits/stdc++.h>
class Solution
{
public:
    int minHeightShelves(vector<vector<int>> &books, int sw)
    {
        int n = books.size();

        vector<int> dp(n + 1, 0);
        dp[0] = 0;

        for (int i = 0; i < n; i++)
        {
            dp[i + 1] = dp[i] + books[i][1];
            int sum = 0, h = 0;
            for (int j = i; j >= 0; j--)
            {
                sum += books[j][0];
                if (sum > sw)
                {
                    break;
                }
                else
                {
                    h = max(h, books[j][1]);
                    dp[i + 1] = min(dp[j] + h, dp[i + 1]);
                }
            }
        }

        return dp[n];
    }
};
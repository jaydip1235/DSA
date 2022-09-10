// https://leetcode.com/problems/uncrossed-lines/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxUncrossedLines(vector<int> &nums1, vector<int> &nums2)
    {
        int n = nums1.size();
        int m = nums2.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

        for (int i = 0; i < dp.size(); i++)
        {

            for (int j = 0; j < dp[0].size(); j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    int ind1 = i - 1;
                    int ind2 = j - 1;
                    if (nums1[ind1] == nums2[ind2])
                    {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else
                    {
                        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[n][m];
    }
};
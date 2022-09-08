// https://leetcode.com/problems/minimum-jumps-to-reach-home/
#include<bits/stdc++.h>
class Solution
{
public:
    int fun(set<int> &s, int a, int b, int x, vector<vector<int>> &dp, int xcurr, int fl)
    {
        if (xcurr < 0 || xcurr >= 6001)
            return 1e9;
        if (s.find(xcurr) != s.end())
        {
            return 1e9;
        }
        if (xcurr == x)
        {
            return 0;
        }
        if (dp[xcurr][fl] != -1)
            return dp[xcurr][fl];
        dp[xcurr][fl] = 1 + fun(s, a, b, x, dp, xcurr + a, 0);
        if (fl == 0)
            dp[xcurr][fl] = min(dp[xcurr][fl], 1 + fun(s, a, b, x, dp, xcurr - b, 1));
        return dp[xcurr][fl];
    }

    int minimumJumps(vector<int> &forbidden, int a, int b, int x)
    {
        vector<vector<int>> dp(7001, vector<int>(2, -1));
        set<int> s;
        for (int i = 0; i < forbidden.size(); i++)
        {
            s.insert(forbidden[i]);
        }
        int ans = fun(s, a, b, x, dp, 0, 0);
        if (ans >= 1e9)
            return -1;
        return ans;
    }
};
// https://leetcode.com/problems/longest-string-chain/
#include<bits/stdc++.h>
class Solution
{
public:
    static bool comp(string &s1, string &s2)
    {
        return s1.size() < s2.size();
    }

    bool check(string &s1, string &s2)
    {
        if (s1.size() != (s2.size() + 1))
            return false;
        int f = 0, s = 0;
        while (f < s1.size())
        {
            if (s1[f] == s2[s])
            {
                f++;
                s++;
            }
            else
            {
                f++;
            }
        }
        return (f == s1.size() && s == s2.size());
    }

    int longestStrChain(vector<string> &arr)
    {
        sort(arr.begin(), arr.end(), comp);
        int n = arr.size();
        int maxi = INT_MIN;
        vector<int> dp(n + 1, 1);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (check(arr[i], arr[j]) && dp[i] < dp[j] + 1)
                {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxi)
                maxi = dp[i];
        }
        return maxi;
    }
};
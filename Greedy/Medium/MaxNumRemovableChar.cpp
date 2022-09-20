// https://leetcode.com/problems/maximum-number-of-removable-characters/
#include<bits/stdc++.h>
class Solution
{
public:
    bool func(string s, string p, int k, vector<int> &rem)
    {
        for (int i = 0; i < k; i++)
        {
            s[rem[i]] = '?';
        }
        int i = 0, j = 0;
        while (i < s.size() && j < p.size())
        {
            if (s[i] == p[j])
                j++;
            i++;
        }
        return j == p.size();
    }

    int maximumRemovals(string s, string p, vector<int> &rem)
    {
        int ans = 0, st = 0, e = rem.size();
        while (st <= e)
        {
            int mid = (st + e) / 2;
            if (func(s, p, mid, rem))
            {
                ans = mid;
                st = mid + 1;
            }
            else
            {
                e = mid - 1;
            }
        }
        return ans;
    }
};
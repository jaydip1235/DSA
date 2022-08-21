// https://leetcode.com/problems/maximum-length-of-pair-chain/
#include<bits/stdc++.h>
class Solution
{
public:
    static bool comp(pair<int, int> a, pair<int, int> b)
    {
        return a.second < b.second;
    }
    int findLongestChain(vector<vector<int>> &pairs)
    {
        vector<pair<int, int>> v;
        for (int i = 0; i < pairs.size(); i++)
        {
            v.push_back({pairs[i][0], pairs[i][1]});
        }
        sort(v.begin(), v.end(), comp);
        int i = 0, j = 1, ans = 1;
        while (j < pairs.size())
        {
            if (v[i].second < v[j].first)
            {
                i = j;
                j++;
                ans++;
            }
            else
            {
                j++;
            }
        }
        return ans;
    }
};
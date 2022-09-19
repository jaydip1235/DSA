// https://leetcode.com/problems/partition-labels/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> partitionLabels(string s)
    {

        vector<int> ans;
        map<char, int> mp;
        for (int i = 0; i < s.size(); i++)
            mp[s[i]] = i;
        ;
        int prev = -1;
        int maxi = 0;
        for (int i = 0; i < s.size(); i++)
        {
            maxi = max(maxi, mp[s[i]]);
            if (i == maxi)
            {
                ans.push_back(maxi - prev);
                prev = maxi;
            }
        }
        return ans;
    }
};
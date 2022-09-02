// https://leetcode.com/problems/sort-characters-by-frequency/
#include<bits/stdc++.h>
class Solution
{
public:
    string frequencySort(string s)
    {
        map<char, int> mp;
        for (int i = 0; i < s.size(); i++)
        {
            mp[s[i]]++;
        }
        multimap<int, char, greater<int>> mmp;
        for (auto it : mp)
        {
            mmp.insert({it.second, it.first});
        }
        string ans = "";
        for (auto it = mmp.begin(); it != mmp.end(); it++)
        {
            int freq = it->first;
            for (int j = 1; j <= freq; j++)
            {
                ans += it->second;
            }
        }
        return ans;
    }
};
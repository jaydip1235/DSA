// https://leetcode.com/problems/shuffle-string/
#include <bits/stdc++.h>
class Solution
{
public:
    string restoreString(string s, vector<int> &indices)
    {
        vector<char> v(s.size());

        for (int i = 0; i < s.size(); i++)
        {
            v[indices[i]] = s[i];
        }
        string ans = "";
        for (int i = 0; i < v.size(); i++)
        {
            ans += v[i];
        }
        return ans;
    }
};
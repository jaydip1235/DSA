// https://leetcode.com/problems/longest-repeating-character-replacement/
#include<bits/stdc++.h>
class Solution
{
public:
    static bool compare(const pair<int, int> &a, const pair<int, int> &b)
    {
        return a.second < b.second;
    }

    int characterReplacement(string s, int k)
    {
        map<char, int> mp;
        int l = 0;
        int ans = 0;
        for (int r = 0; r < s.size(); r++)
        {
            mp[s[r]]++;

            while ((r - l + 1) - max_element(mp.begin(), mp.end(), compare)->second > k)
            {
                mp[s[l]]--;
                l++;
            }

            ans = max(ans, (r - l + 1));
        }

        return ans;
    }
};
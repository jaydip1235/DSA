// https://leetcode.com/problems/construct-string-with-repeat-limit/
#include<bits/stdc++.h>
class Solution
{
public:
    string repeatLimitedString(string str, int repeatLimit)
    {
        int freq[26];
        memset(freq, 0, sizeof freq);
        for (int i = 0; i < str.size(); i++)
        {
            freq[str[i] - 'a']++;
        }
        string ans(str.size(), '_');
        int k = 0;
        set<int> s;
        for (int i = 25; i >= 0; i--)
        {

            int cnt = 0, curr = 0;
            while (cnt < freq[i] && s.size())
            {
                ans[*s.begin()] = i + 'a';
                s.erase(s.begin());
                cnt++;
            }
            while (cnt < freq[i])
            {
                if (curr == repeatLimit)
                {
                    curr = 0;
                    s.insert(k);
                    k++;
                }
                if (k > str.size())
                    break;
                ans[k] = i + 'a';
                k++;
                curr++;
                cnt++;
            }
        }
        for (int i = 0; i < ans.size(); i++)
        {
            if (ans[i] == '_')
            {
                ans.erase(ans.begin() + i, ans.end());
                break;
            }
        }
        return ans;
    }
};
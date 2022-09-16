// https://leetcode.com/problems/maximum-score-from-removing-substrings/
#include<bits/stdc++.h>
class Solution
{
public:
    int maximumGain(string s, int x, int y)
    {
        vector<char> v1, v2;
        int f = 0;
        if (x > y)
            f = 1;
        int ans = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if (v1.size() == 0)
                v1.push_back(s[i]);
            else
            {
                if (f)
                {
                    if (s[i] == 'b' && v1.back() == 'a')
                    {
                        ans += x;
                        v1.pop_back();
                    }
                    else
                        v1.push_back(s[i]);
                }
                else
                {
                    if (s[i] == 'a' && v1.back() == 'b')
                    {
                        ans += y;
                        v1.pop_back();
                    }
                    else
                        v1.push_back(s[i]);
                }
            }
        }

        for (int i = 0; i < v1.size(); i++)
        {
            if (v2.size() == 0)
                v2.push_back(v1[i]);
            else
            {
                if (!f)
                {
                    if (v1[i] == 'b' && v2.back() == 'a')
                    {
                        ans += x;
                        v2.pop_back();
                    }
                    else
                        v2.push_back(v1[i]);
                }
                else
                {
                    if (v1[i] == 'a' && v2.back() == 'b')
                    {
                        ans += y;
                        v2.pop_back();
                    }
                    else
                        v2.push_back(v1[i]);
                }
            }
        }

        return ans;
    }
};
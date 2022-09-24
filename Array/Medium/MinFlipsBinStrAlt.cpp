// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
#include<bits/stdc++.h>
class Solution
{
public:
    int minFlips(string s)
    {
        s += s;
        string alt1 = "0", alt2 = "1";
        for (int i = 1; i < s.size(); i++)
        {
            if (i % 2 == 1)
            {
                alt1 += '1';
                alt2 += '0';
            }
            else
            {
                alt1 += '0';
                alt2 += '1';
            }
        }
        int ans1 = INT_MAX, ans2 = INT_MAX, count1 = 0, count2 = 0;
        for (int i = 0; i < s.size() / 2; i++)
        {
            if ((s[i] == '0' && alt1[i] == '1') || (s[i] == '1' && alt1[i] == '0'))
                count1++;
            if ((s[i] == '0' && alt2[i] == '1') || (s[i] == '1' && alt2[i] == '0'))
                count2++;
        }
        ans1 = min(ans1, count1);
        ans2 = min(ans2, count2);
        int n = s.size() / 2;
        for (int i = s.size() / 2; i < s.size(); i++)
        {
            if ((s[i] == '0' && alt1[i] == '1') || (s[i] == '1' && alt1[i] == '0'))
                count1++;
            if ((s[i - n] == '0' && alt1[i - n] == '1') || (s[i - n] == '1' && alt1[i - n] == '0'))
                count1--;
            if ((s[i] == '0' && alt2[i] == '1') || (s[i] == '1' && alt2[i] == '0'))
                count2++;
            if ((s[i - n] == '0' && alt2[i - n] == '1') || (s[i - n] == '1' && alt2[i - n] == '0'))
                count2--;
            ans1 = min(ans1, count1);
            ans2 = min(ans2, count2);
        }
        return min(ans1, ans2);
    }
};
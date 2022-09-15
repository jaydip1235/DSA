// https://leetcode.com/problems/minimum-suffix-flips/
#include<bits/stdc++.h>
class Solution
{
public:
    int minFlips(string s)
    {
        int count = 0;
        int state = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if (state != s[i] - '0')
            {
                state = 1 - state;
                count++;
            }
        }
        return count;
    }
};
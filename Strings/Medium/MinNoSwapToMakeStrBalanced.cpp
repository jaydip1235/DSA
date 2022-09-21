// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
#include<bits/stdc++.h>
class Solution
{
public:
    int minSwaps(string s)
    {
        int maxi = 0;
        int ecc = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == ']')
                ecc++;
            else
                ecc--;
            maxi = max(maxi, ecc);
        }
        return (maxi + 1) / 2;
    }
};
// https://leetcode.com/problems/integer-break/
#include<bits/stdc++.h>
class Solution
{
public:
    int integerBreak(int n)
    {
        if (n < 4)
            return n - 1;
        int ans = 1;
        while (n >= 5)
        {
            n -= 3;
            ans *= 3;
        }
        if (n)
            ans *= n;
        return ans;
    }
};
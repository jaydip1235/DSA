// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
#include<bits/stdc++.h>
class Solution
{
public:
    long long numberOfWeeks(vector<int> &a)
    {
        long long sum = 0;
        long long maxi = INT_MIN;
        for (int i = 0; i < a.size(); i++)
        {
            sum += a[i];
            if (a[i] > maxi)
                maxi = a[i];
        }
        long rem = sum - maxi;
        if (rem <= maxi - 1)
            return 2 * rem + 1;
        return sum;
    }
};
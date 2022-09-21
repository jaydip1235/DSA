// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
#include<bits/stdc++.h>
class Solution
{
public:
    string getSmallestString(int n, int k)
    {
        string res(n, 'a');
        k -= n;
        while (k > 0)
        {
            res[n - 1] += min(25, k);
            k -= min(25, k);
            n--;
        }
        return res;
    }
};
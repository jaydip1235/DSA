// https://leetcode.com/problems/maximum-split-of-positive-even-integers/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<long long> maximumEvenSplit(long long finalSum)
    {
        vector<long long> ans;
        if (finalSum % 2)
            return ans;
        int i = 2;
        while (i <= finalSum)
        {
            ans.push_back(i);
            finalSum -= i;
            i += 2;
        }
        ans[ans.size() - 1] += finalSum;
        return ans;
    }
};
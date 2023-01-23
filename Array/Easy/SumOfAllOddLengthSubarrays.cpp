// https : //leetcode.com/problems/sum-of-all-odd-length-subarrays/
#include<bits/stdc++.h>
class Solution
{
public:
    int sumOddLengthSubarrays(vector<int> &arr)
    {
        int ans = 0;
        vector<int> sum;
        for (int i = 0; i < arr.size(); i++)
        {
            ans = arr[i];
            sum.push_back(arr[i]);
            for (int j = i + 1; j < arr.size(); j++)
            {
                ans += arr[j];
                if ((j - i) % 2 == 0)
                {
                    sum.push_back(ans);
                }
            }
        }
        int res = 0;
        for (int i : sum)
            res += i;
        return res;
    }
};
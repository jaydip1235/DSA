// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
#include<bits/stdc++.h>
class Solution
{
public:
    int findMaxK(vector<int> &nums)
    {
        map<int, int> mp;
        int maxi = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            mp[nums[i]]++;
            if (nums[i] > 0)
            {
                if (mp.find(nums[i] * (-1)) != mp.end())
                {
                    maxi = max(maxi, nums[i]);
                }
            }
            else
            {
                if (mp.find(nums[i] * (-1)) != mp.end())
                {
                    maxi = max(maxi, nums[i] * (-1));
                }
            }
        }
        return maxi == 0 ? -1 : maxi;
    }
};
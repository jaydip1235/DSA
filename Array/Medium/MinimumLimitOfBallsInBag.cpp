// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
#include<bits/stdc++.h>
class Solution
{
public:
    bool isPossible(vector<int> &nums, int mid, int o)
    {
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] > mid)
            {
                o -= (nums[i] / mid);
                if (nums[i] % mid == 0)
                    o++;
            }
        }
        return o >= 0;
    }

    int minimumSize(vector<int> &nums, int maxOperations)
    {
        int lo = 1;
        int hi = 1e9;
        int ans = INT_MAX;
        while (lo <= hi)
        {
            int mid = (hi + lo) / 2;
            if (isPossible(nums, mid, maxOperations))
            {
                ans = min(ans, mid);
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return ans;
    }
};
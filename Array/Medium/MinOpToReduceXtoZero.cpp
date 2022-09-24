// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
#include<bits/stdc++.h>
class Solution
{
public:
    int minOperations(vector<int> &nums, int x)
    {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        sum -= x;

        int ans = -1, l = 0, rsum = 0;
        for (int r = 0; r < nums.size(); r++)
        {
            rsum += nums[r];
            if (rsum == sum)
            {
                ans = max(ans, r - l + 1);
            }

            if (rsum > sum)
            {
                while (l <= r && rsum > sum)
                {
                    rsum -= nums[l++];
                }
                if (rsum == sum)
                {
                    ans = max(ans, r - l + 1);
                }
            }
        }
        return ans == -1 ? -1 : nums.size() - ans;
    }
};
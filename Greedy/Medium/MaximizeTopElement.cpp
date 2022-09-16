// https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
#include<bits/stdc++.h>
class Solution
{
public:
    int maximumTop(vector<int> &nums, int k)
    {
        if (nums.size() == 1 && k % 2 == 1)
            return -1;
        int ans = 0;
        if (k > nums.size())
        {
            for (int i = 0; i < nums.size(); i++)
                ans = max(ans, nums[i]);
            return ans;
        }
        else if (k == nums.size())
        {
            for (int i = 0; i < nums.size() - 1; i++)
                ans = max(ans, nums[i]);
            return ans;
        }
        else
        {
            for (int i = 0; i < k - 1; i++)
                ans = max(ans, nums[i]);
            return max(ans, nums[k]);
        }
    }
};
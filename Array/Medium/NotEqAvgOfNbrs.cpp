// https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> rearrangeArray(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        vector<int> ans;
        int n = nums.size();
        int s = 0, e = n - 1, f = 0;
        while (s <= e)
        {
            if (s == e)
            {
                ans.push_back(nums[e]);
                break;
            }
            ans.push_back(nums[s]);
            ans.push_back(nums[e]);
            s++;
            e--;
        }
        return ans;
    }
};
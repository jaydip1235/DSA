// https://leetcode.com/problems/maximum-width-ramp/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxWidthRamp(vector<int> &nums)
    {
        stack<int> st;
        for (int i = 0; i < nums.size(); i++)
        {
            if (st.empty() || nums[i] < nums[st.top()])
            {
                st.push(i);
            }
        }
        int ans = 0;
        for (int i = nums.size() - 1; i > ans; i--)
        {
            while (!st.empty() && nums[st.top()] <= nums[i])
            {
                ans = max(ans, i - st.top());
                st.pop();
            }
        }
        return ans;
    }
};
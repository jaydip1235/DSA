// https://leetcode.com/problems/longest-increasing-subsequence/
class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {              
        int n = nums.size();
        vector<int> dp(n + 1);
        for (int i = 1; i <= n; i++)
            dp[i] = INT_MAX;
        dp[0] = INT_MIN;                                                                
        for (int i = 0; i < n; i++)    
        {
            int idx = upper_bound(dp.begin(), dp.end(), nums[i]) - dp.begin();
            if (dp[idx - 1] < nums[i] && dp[idx] > nums[i])
                dp[idx] = nums[i];
        }
        for (int i = n; i >= 0; i--)
        {
            if (dp[i] != INT_MAX)
                return i;
        }
        return 0;
    }
};
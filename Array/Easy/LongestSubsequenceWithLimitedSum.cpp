// https: //leetcode.com/problems/longest-subsequence-with-limited-sum/
class Solution
{
public:
    vector<int> answerQueries(vector<int> &nums, vector<int> &queries)
    {
        sort(nums.begin(), nums.end());
        vector<int> pre;
        pre.push_back(nums[0]);
        for (int i = 1; i < nums.size(); i++)
        {
            pre.push_back(nums[i] + pre.back());
        }
        vector<int> ans;

        for (int i = 0; i < queries.size(); i++)
        {
            int val = upper_bound(pre.begin(), pre.end(), queries[i]) - pre.begin();
            ans.push_back(val);
        }
        return ans;
    }
};
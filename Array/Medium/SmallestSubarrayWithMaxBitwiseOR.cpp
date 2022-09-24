// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> smallestSubarrays(vector<int> &nums)
    {
        vector<int> ans;
        int n = nums.size();
        vector<vector<int>> suffix(n, vector<int>(31, 0));
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 30; j >= 0; j--)
            {
                if (nums[i] & (1 << j))
                    suffix[i][j]++;
            }
            if (i + 1 < n)
            {
                for (int j = 0; j <= 30; j++)
                {
                    suffix[i][j] += suffix[i + 1][j];
                }
            }
        }
        int l = 0;
        vector<int> pre(31, 0);

        for (int i = 0; i < n; i++)
        {

            for (int j = 0; j < 31; j++)
            {
                if (nums[i] & (1 << j))
                    pre[j]++;
            }
            bool flag = true;
            if (i + 1 < n)
            {

                for (int j = 0; j < 31; j++)
                {
                    if (suffix[i + 1][j] > 0 && pre[j] == 0)
                    {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag)
            {
                ans.push_back(i - l + 1);
                while (1)
                {

                    for (int j = 0; j < 31; j++)
                    {
                        if (nums[l] & (1 << j))
                            pre[j]--;
                    }

                    bool flag = true;
                    l++;
                    if (l > i)
                        break;
                    if (i + 1 < n)
                    {

                        for (int j = 0; j < 31; j++)
                        {
                            if (suffix[i + 1][j] > 0 && pre[j] == 0)
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag)
                        ans.push_back(i - l + 1);
                    else
                        break;
                }
            }
        }
        return ans;
    }
};

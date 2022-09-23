// https://leetcode.com/problems/longest-nice-subarray/
#include<bits/stdc++.h>
class Solution
{
public:
    int longestNiceSubarray(vector<int> &nums)
    {
        int ans = 1;
        int l = 0;
        int bits[32] = {0};
        for (int r = 0; r < nums.size(); r++)
        {

            int f = 0;
            for (int i = 0; i < 31; i++)
            {
                if (nums[r] & (1 << i))
                {
                    bits[i]++;
                    if (bits[i] > 1)
                        f = 1;
                }
            }
            if (f == 0)
                ans = max(ans, (r - l + 1));
            else
            {
                while (l <= r)
                {

                    for (int i = 0; i < 31; i++)
                    {
                        if (nums[l] & (1 << i))
                        {
                            bits[i]--;
                        }
                    }
                    l++;
                    int f = 0;
                    for (int i = 0; i < 31; i++)
                    {
                        if (bits[i] > 1)
                        {
                            f = 1;
                        }
                    }

                    if (!f)
                        break;
                }
            }
        }

        return ans;
    }
};
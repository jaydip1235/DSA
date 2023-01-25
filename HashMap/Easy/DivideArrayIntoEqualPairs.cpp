// https://leetcode.com/problems/divide-array-into-equal-pairs/
#include<bits/stdc++.h>
class Solution
{
public:
    bool divideArray(vector<int> &nums)
    {
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++)
        {
            if (mp.find(nums[i]) != mp.end())
            {
                mp.erase(nums[i]);
            }
            else
            {
                mp[nums[i]]++;
            }
        }
        return mp.size() == 0;
    }
};
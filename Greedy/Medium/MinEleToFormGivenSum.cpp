// https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/
#include<bits/stdc++.h>
class Solution
{
public:
    int minElements(vector<int> &nums, int limit, int goal)
    {
        long long int sum = 0;
        for (int i = 0; i < nums.size(); i++)
            sum += nums[i];
        long long int diff = goal - sum;
        diff = abs(diff);

        if (diff % limit == 0)
            return diff / limit;
        return (diff / limit) + 1;
    }
};
// https://leetcode.com/problems/append-k-integers-with-minimal-sum/
#include<bits/stdc++.h>
class Solution
{
public:
    long long minimalKSum(vector<int> &nums, int k)
    {
        set<long long> s;
        for (int i = 0; i < nums.size(); i++)
            s.insert(nums[i]);
        long long start = 1;
        long long ans = 0;
        for (auto it : s)
        {
            long long l = start;
            long long r = it;
            if (k > (r - l))
                k -= r - l;
            else
                break;
            ans += (r * (r - 1)) / 2 - (l * (l - 1)) / 2;
            start = r + 1;
        }
        long long l = start;
        long long r = start + k;
        ans += (r * (r - 1)) / 2 - (l * (l - 1)) / 2;
        return ans;
    }
};
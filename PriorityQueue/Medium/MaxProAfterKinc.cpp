// https://leetcode.com/problems/maximum-product-after-k-increments/
#include<bits/stdc++.h>
class Solution
{
public:
    int maximumProduct(vector<int> &nums, int k)
    {
        priority_queue<int, vector<int>, greater<int>> pq;

        for (int i = 0; i < nums.size(); i++)
            pq.push(nums[i]);
        while (k--)
        {
            int x = pq.top();
            pq.pop();
            x++;
            pq.push(x);
        }
        long long mod = 1e9 + 7, mul = 1;
        while (!pq.empty())
        {
            mul = (mul * pq.top()) % mod;
            pq.pop();
        }
        return mul;
    }
};
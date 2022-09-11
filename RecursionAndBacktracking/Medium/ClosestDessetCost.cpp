// https://leetcode.com/problems/closest-dessert-cost/
#include<bits/stdc++.h>
class Solution
{
public:
    unordered_set<int> costs;
    int diff = 1e9;

    void solve(vector<int> &t, int amount, int target, int index)
    {
        if (index >= t.size())
        {
            costs.insert(amount);
            diff = min(diff, abs(target - amount));
            return;
        }
        solve(t, amount, target, index + 1);
        solve(t, amount + t[index], target, index + 1);
        solve(t, amount + t[index] * 2, target, index + 1);
    }

    int closestCost(vector<int> &b, vector<int> &t, int target)
    {
        int amount = 0;
        for (int i = 0; i < b.size(); i++)
        {
            solve(t, amount + b[i], target, 0);
        }
        if (costs.count(target - diff) == true)
            return target - diff;
        return target + diff;
    }
};
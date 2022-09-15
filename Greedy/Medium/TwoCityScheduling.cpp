// https://leetcode.com/problems/two-city-scheduling/
#include<bits/stdc++.h>
class Solution
{
public:
    static bool compare(vector<int> &f, vector<int> &s)
    {
        return f[1] - f[0] > s[1] - s[0];
    }

    int twoCitySchedCost(vector<vector<int>> &costs)
    {
        int ans = 0;
        sort(costs.begin(), costs.end(), compare);
        for (int i = 0; i < costs.size(); i++)
        {
            if (i < costs.size() / 2)
                ans += costs[i][0];
            else
                ans += costs[i][1];
        }
        return ans;
    }
};
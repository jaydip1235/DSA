// https://leetcode.com/problems/maximum-ice-cream-bars/
#include<bits/stdc++.h>
class Solution
{
public:
    int maxIceCream(vector<int> &costs, int coins)
    {
        sort(costs.begin(), costs.end());
        int ans = 0;
        for (int i = 0; i < costs.size() && coins > 0; i++)
        {
            if (coins >= costs[i])
            {
                coins -= costs[i];
                ans++;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
};
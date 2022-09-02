// https://leetcode.com/problems/car-pooling/
#include<bits/stdc++.h>
class Solution
{
public:
    bool carPooling(vector<vector<int>> &trips, int capacity)
    {
        vector<int> v(1001, 0);
        for (int i = 0; i < trips.size(); i++)
        {
            v[trips[i][1]] += trips[i][0];
            v[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for (int i = 0; i < 1001; i++)
        {
            sum += v[i];
            if (sum > capacity)
                return false;
        }
        return true;
    }
};
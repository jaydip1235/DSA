// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
#include<bits/stdc++.h>
class Solution
{
public:
    static bool compare(vector<int> &a, vector<int> &b)
    {
        return a[1] < b[1];
    }

    int findMinArrowShots(vector<vector<int>> &arr)
    {
        sort(arr.begin(), arr.end(), compare);
        int ans = 1, end = arr[0][1];
        for (int i = 1; i < arr.size(); i++)
        {
            if (arr[i][0] > end)
            {
                ans++;
                end = arr[i][1];
            }
        }
        return ans;
    }
};
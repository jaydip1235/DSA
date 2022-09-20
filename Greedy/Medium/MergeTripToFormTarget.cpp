// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
#include<bits/stdc++.h>
class Solution
{
public:
    bool mergeTriplets(vector<vector<int>> &arr, vector<int> &target)
    {
        vector<int> res(3, 0);
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr[i][0] <= target[0] && arr[i][1] <= target[1] && arr[i][2] <= target[2])
            {
                res[0] = max(res[0], arr[i][0]);
                res[1] = max(res[1], arr[i][1]);
                res[2] = max(res[2], arr[i][2]);
            }
        }
        return res == target;
    }
};
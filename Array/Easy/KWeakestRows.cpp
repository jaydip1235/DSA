// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
#include<bits/stdc++.h>
class Solution
{
public:
    int soldierCount(vector<int> v)
    {
        int lo = 0;
        int hi = v.size() - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (v[mid] == 0)
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return lo;
    }

    vector<int> kWeakestRows(vector<vector<int>> &mat, int k)
    {
        vector<pair<int, int>> v;
        for (int i = 0; i < mat.size(); i++)
        {
            int c = soldierCount(mat[i]);
            v.push_back({c, i});
        }
        sort(v.begin(), v.end());
        vector<int> ans;
        int i = 0;
        while (k--)
        {
            ans.push_back(v[i].second);
            i++;
        }
        return ans;
    }
};
// https://leetcode.com/problems/maximum-total-importance-of-roads/
#include<bits/stdc++.h>
class Solution
{
public:
    long long maximumImportance(int n, vector<vector<int>> &roads)
    {
        vector<int> temp(n, 0);
        for (int i = 0; i < roads.size(); i++)
        {
            temp[roads[i][0]]++;
            temp[roads[i][1]]++;
        }
        int cnt = n;
        sort(temp.begin(), temp.end(), greater<int>());
        vector<pair<int, int>> helper;
        for (int i = 0; i < n; i++)
        {
            helper.push_back({temp[i], cnt});
            cnt--;
        }
        long long ans = 0LL;
        for (int i = 0; i < n; i++)
        {
            ans += 1LL * helper[i].first * helper[i].second;
        }
        return ans;
    }
};
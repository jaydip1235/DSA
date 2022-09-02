// https://leetcode.com/problems/maximum-average-pass-ratio/
#include<bits/stdc++.h>
class Solution
{
public:
    double maxAverageRatio(vector<vector<int>> &classes, int extraStudents)
    {
        priority_queue<pair<double, pair<int, int>>> pq;
        for (int i = 0; i < classes.size(); i++)
        {
            int pass = classes[i][0];
            int total = classes[i][1];
            double delta = (double)(pass + 1) / (total + 1) - (double)(pass) / (total);
            pq.push({delta, {pass, total}});
        }
        while (extraStudents--)
        {
            int p = pq.top().second.first;
            int t = pq.top().second.second;
            p++;
            t++;
            double ndelta = (double)(p + 1) / (t + 1) - (double)(p) / (t);
            pq.pop();
            pq.push({ndelta, {p, t}});
        }
        double ans = 0.0;
        while (!pq.empty())
        {
            ans += (double)(pq.top().second.first) / (pq.top().second.second);
            pq.pop();
        }
        return (double)ans / classes.size();
    }
};
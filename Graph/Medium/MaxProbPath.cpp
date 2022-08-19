// https://leetcode.com/problems/path-with-maximum-probability/
#include<bits/stdc++.h>
class Solution
{
public:
    double maxProbability(int n, vector<vector<int>> &edges, vector<double> &succProb, int start, int end)
    {

        vector<pair<int, double>> adj[n];
        for (int i = 0; i < edges.size(); i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }

        vector<double> dist(n, INT_MAX);
        priority_queue<pair<double, int>, vector<pair<double, int>>, greater<pair<double, int>>> pq;
        dist[start] = -1.0;
        pq.push({dist[start], start});

        while (!pq.empty())
        {
            double predist = pq.top().first;
            int prenode = pq.top().second;
            pq.pop();
            for (auto it : adj[prenode])
            {
                if (dist[it.first] > predist * it.second)
                {
                    dist[it.first] = predist * it.second;
                    pq.push({dist[it.first], it.first});
                }
            }
        }
        if (dist[end] == INT_MAX)
            return 0.0;
        return -1.0 * dist[end];
    }
};
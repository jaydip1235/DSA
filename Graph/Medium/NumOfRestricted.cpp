// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
#include<bits/stdc++.h>
class Solution
{
public:
    int dfs(int src, vector<pair<int, int>> adj[], vector<int> &dp, vector<int> &dist)
    {
        if (dp[src] != -1)
            return dp[src];
        if (src == dist.size() - 1)
            return dp[src] = 1;
        int count = 0;
        int mod = 1000000007;
        for (auto it : adj[src])
        {
            if (dist[it.first] < dist[src])
            {
                count = (count + dfs(it.first, adj, dp, dist)) % mod;
            }
        }
        return dp[src] = count;
    }

    int countRestrictedPaths(int n, vector<vector<int>> &edges)
    {

        vector<pair<int, int>> adj[n];
        for (int i = 0; i < edges.size(); i++)
        {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            int wt = edges[i][2];
            adj[u].push_back({v, wt});
            adj[v].push_back({u, wt});
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> dist(n, INT_MAX);
        dist[n - 1] = 0;
        pq.push({0, n - 1});
        while (!pq.empty())
        {
            auto it = pq.top();
            pq.pop();
            int ele = it.second;
            int weight = it.first;
            for (auto nbr : adj[ele])
            {
                int nbrele = nbr.first;
                int wt = nbr.second;
                if (dist[ele] + wt < dist[nbrele])
                {
                    dist[nbrele] = dist[ele] + wt;
                    pq.push({dist[nbrele], nbrele});
                }
            }
        }

        vector<int> dp(n, -1);
        return dfs(0, adj, dp, dist);
    }
};
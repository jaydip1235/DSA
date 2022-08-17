// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
#include<bits/stdc++.h>
class Solution
{
public:
    long long sz;
    void dfs(int src, vector<int> adj[], vector<bool> &visited)
    {
        visited[src] = true;
        sz++;
        for (int nbr : adj[src])
        {
            if (!visited[nbr])
            {
                dfs(nbr, adj, visited);
            }
        }
    }

    long long countPairs(int n, vector<vector<int>> &edges)
    {

        vector<int> adj[n];
        for (int i = 0; i < edges.size(); i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        sz = 0;
        vector<bool> visited(n, false);
        vector<long long> siz;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                dfs(i, adj, visited);
                siz.push_back(sz);
                sz = 0;
            }
        }

        if (siz.size() == 1)
            return 0;
        long long len = siz.size();
        long long suf[len];
        suf[len - 1] = siz[len - 1];
        for (int i = len - 2; i >= 0; i--)
        {
            suf[i] = siz[i] + suf[i + 1];
        }
        long long ans = 0;
        for (int i = 0; i < len - 1; i++)
        {
            ans = ans + siz[i] * suf[i + 1];
        }
        return ans;
    }
};
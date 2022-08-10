// https://leetcode.com/problems/find-if-path-exists-in-graph/
#include<bits/stdc++.h>
class Solution{
public:
    bool dfs(int source, int destination, vector<int> adj[], vector<bool> &vis)
    {
        vis[source] = true;
        if (source == destination)
            return true;
        for (auto it : adj[source])
        {
            if (vis[it] == false)
            {
                if (dfs(it, destination, adj, vis))
                    return true;
            }
        }
        return false;
    }

    bool validPath(int n, vector<vector<int>> &edges, int source, int destination)
    {
        if (n == 1)
            return true;
        vector<int> adj[n];
        for (int i = 0; i < edges.size(); i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<bool> vis(n, false);
        return dfs(source, destination, adj, vis);
    }
};
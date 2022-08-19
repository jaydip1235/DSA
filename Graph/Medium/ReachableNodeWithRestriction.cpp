// https://leetcode.com/problems/reachable-nodes-with-restrictions/
#include<bits/stdc++.h>
class Solution
{
public:
    int ans;
    void dfs(int src, vector<int> adj[], vector<bool> &visited)
    {
        if (visited[src])
        {
            return;
        }
        ans++;
        visited[src] = true;
        for (auto it : adj[src])
        {
            if (visited[it] == false)
            {
                dfs(it, adj, visited);
            }
        }
    }
    int reachableNodes(int n, vector<vector<int>> &edges, vector<int> &restricted)
    {
        ans = 0;
        set<int> st;
        vector<bool> visited(n, false);
        for (int i = 0; i < restricted.size(); i++)
        {
            visited[restricted[i]] = true;
        }
        vector<int> adj[n];
        for (int i = 0; i < edges.size(); i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        dfs(0, adj, visited);
        return ans;
    }
};
// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
#include<bits/stdc++.h>
class Solution
{
public:
    int minReorder(int n, vector<vector<int>> &connections)
    {
        vector<int> adj[n];
        set<pair<int, int>> st;
        vector<bool> visited(n, false);
        for (int i = 0; i < connections.size(); i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            st.insert({u, v});
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        queue<int> q;
        q.push(0);
        int ans = 0;
        while (!q.empty())
        {

            int top = q.front();
            q.pop();
            if (!visited[top])
            {
                visited[top] = true;
                for (auto it : adj[top])
                {
                    if (!visited[it] && st.count({top, it}))
                    {
                        ans++;
                    }
                    if (!visited[it])
                        q.push(it);
                }
            }
        }
        return ans;
    }
};
// https://leetcode.com/problems/loud-and-rich/
#include<bits/stdc++.h>
class Solution
{
public:
    int dfs(int src, vector<int> adj[], vector<int> quite, vector<int> &ans)
    {

        int x = src;
        for (auto it : adj[x])
        {
            if (ans[it] != -1)
            {
                if (quite[ans[it]] < quite[x])
                {
                    x = ans[it];
                }
            }
            else
            {
                int y = dfs(it, adj, quite, ans);
                if (quite[y] < quite[x])
                    x = y;
            }
        }
        return ans[src] = x;
    }

    vector<int> loudAndRich(vector<vector<int>> &richer, vector<int> &quiet)
    {
        int n = quiet.size();
        vector<int> adj[n];
        for (int i = 0; i < richer.size(); i++)
        {
            int u = richer[i][1];
            int v = richer[i][0];
            adj[u].push_back(v);
        }
        vector<int> ans(quiet.size(), -1);
        for (int i = 0; i < n; i++)
        {
            if (ans[i] == -1)
            {
                ans[i] = dfs(i, adj, quiet, ans);
            }
        }
        return ans;
    }
};
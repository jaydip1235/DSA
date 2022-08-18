// https://leetcode.com/problems/possible-bipartition/
#include<bits/stdc++.h>
class Solution
{
public:
    bool possibleBipartition(int n, vector<vector<int>> &dislikes)
    {

        vector<int> adj[n + 1];
        for (int i = 0; i < dislikes.size(); i++)
        {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<int> color(n + 1, -1);
        for (int i = 1; i <= n; i++)
        {
            if (color[i] == -1)
            {

                queue<int> q;
                q.push(i);
                color[i] = 0;
                while (!q.empty())
                {
                    int rem = q.front();
                    int mycol = color[rem];
                    q.pop();
                    for (auto it : adj[rem])
                    {
                        if (color[it] != -1 && color[it] == mycol)
                            return false;
                        else if (color[it] != -1)
                        {
                        }
                        else
                        {
                            color[it] = 1 - mycol;
                            q.push(it);
                        }
                    }
                }
            }
        }
        return true;
    }
};